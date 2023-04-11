package com.example.demo.utilities;

import com.example.demo.model.Flight;

import java.util.*;


public class FlightGraph {
    private List<FlightNode> nodes;

    /**
     * in constructor generez graful(noduri+legaturi vecini)
     */
    public FlightGraph(List<Flight> flights) {
        this.nodes = new ArrayList<>();
        for (Flight flight : flights) {
            FlightNode node = new FlightNode(flight);
            node.findNeighbours(flights);
            this.nodes.add(node);
        }
    }


    /**
     * gaseste traseul(algoritmul BFS) cu escale si il returneaza sub forma unei liste de zboruri.
     * daca nu se va gasi un traseu ,se va returna lista vida
     */
    public List<Flight> findPath(String from, String to, List<Flight> flights) {
        List<Flight> result = new ArrayList<>();

        Flight directFlight = this.directCase(from, to);
        if (directFlight != null) {
            result.add(directFlight);
            return result;
        }

        FlightNode firstNode = this.findFirst(from);
        if (firstNode == null) {
            return result;
        }

        //BFS
        this.setUnvisited();
        LinkedList<FlightNode> queue = new LinkedList<>();

        queue.add(firstNode);
        while (queue.size() != 0) {
            FlightNode currentNode = queue.poll();

            //verific daca am ajuns la destinatie
            if (Objects.equals(currentNode.getInfo().getTo(), to)) {
                return this.constructSolution(firstNode, currentNode);
            }

            //marchez nodul curent ca vizitat
            currentNode.setVisited(true);

            for (FlightNode node : currentNode.getNeighbours()) {
                node.setParent(currentNode);
                //node.findNeighbours(flights);
                node.findNeighboursByNodes(this.nodes);
                if(!node.isVisited())
                  queue.add(node);
            }
        }
        return result;
    }


    /**
     * verific situatia zborului direct
     */
    public Flight directCase(String from, String to) {
        for (FlightNode node : this.nodes)
            if (node.isDirectFlight(from, to))
                return node.getInfo();
        return null;
    }

    /**
     * marchez nodurile ca nevizitate
     */
    public void setUnvisited() {
        for (FlightNode node : this.nodes)
            node.setVisited(false);
    }

    /**
     * gasesc nodul de la care incep cautarea
     */
    public FlightNode findFirst(String from) {
        for (FlightNode node : this.nodes)
            if (Objects.equals(node.getInfo().getFrom(), from))
                return node;
        return null;
    }


    /**
     * metoda care construieste solutia
     */
    public List<Flight> constructSolution(FlightNode first, FlightNode current) {
        List<Flight> result = new ArrayList<>();

        while (first != current) {
            result.add(current.getInfo());
            current = current.getParent();
        }
        Collections.reverse(result);
        result.add(0, first.getInfo());
        return result;
    }

}
