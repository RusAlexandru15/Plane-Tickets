package com.example.demo.utilities;

import com.example.demo.model.Flight;

import java.util.*;

/** the class that builds the graph in which BFS  algorithm is applied for finding the indirect route */
public class FlightGraph {
    private List<FlightNode> nodes;

    /**
     * in the constructor, it generates the graph (nodes + neighboring links)
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
     * finds the route (BFS algorithm) with stops and returns it in the form of a list of flights.
     * if no route is found, the empty list will be returned
     */
    public List<Flight> findPath(String from, String to) {
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
     * verifies the direct flight situation
     */
    public Flight directCase(String from, String to) {
        for (FlightNode node : this.nodes)
            if (node.isDirectFlight(from, to))
                return node.getInfo();
        return null;
    }

    /**
     *  marks all nodes as unvisited
     */
    public void setUnvisited() {
        for (FlightNode node : this.nodes)
            node.setVisited(false);
    }

    /**
     *  finds the starting node for the search
     */
    public FlightNode findFirst(String from) {
        for (FlightNode node : this.nodes)
            if (Objects.equals(node.getInfo().getFrom(), from))
                return node;
        return null;
    }


    /**
     * method that builds the final solution
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
