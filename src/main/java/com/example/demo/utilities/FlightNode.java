package com.example.demo.utilities;

import com.example.demo.model.Flight;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/** the class that represents the node with all its adjacent information */

public class FlightNode {
    private Flight info;
    private FlightNode parent;
    private List<FlightNode> neighbours;
    private Boolean visited;

    public FlightNode(Flight info){
        this.info=info;
        this.parent=null;
        this.neighbours=new ArrayList<>();
        this.visited=false;
    }


    public Flight getInfo() {
        return info;
    }

    public FlightNode getParent() {
        return this.parent;
    }

    public List<FlightNode> getNeighbours()
    {
        return this.neighbours;
    }

    public boolean isVisited() {
        return this.visited;
    }

    public void setParent(FlightNode parent) {
        this.parent = parent;
    }

    public void setVisited(Boolean visited) {
        this.visited = visited;
    }



    //FAC EQUALS IN FUNCTIE DR FROM SI TO
    //MODIFICA DIRECT IN this.info== other.info
    /** compares the equality according to the info field which is a Flight*/
    public boolean equals(Object obj) {

        if (obj == this) {
            return true;
        }
        if (!(obj instanceof FlightNode other)) {
            return false;
        }
        return Objects.equals(this.info.getFrom(), other.info.getFrom()) &&
                Objects.equals(this.info.getTo(), other.info.getTo());
    }



    //UNDE VERIFICI DISPONIBILITATEA???
    /** generates the neighbors of a node from the flight list*/
    public void findNeighbours(List<Flight> flights)
    {
        for(Flight flight:flights){
            if(Objects.equals(this.info.getTo(), flight.getFrom()) )
                this.neighbours.add(new FlightNode(flight));
        }
    }

    /** generates the neighbors of a node from the node list*/
    public void findNeighboursByNodes(List<FlightNode> nodes)
    {
        this.neighbours=new ArrayList<>();
        for(FlightNode node:nodes){
            if(Objects.equals(this.info.getTo(), node.getInfo().getFrom()) )
                this.neighbours.add(node);
        }
    }

    /**
     * verifies the direct flight situation
     */
    public Boolean isDirectFlight(String from, String to){
        return Objects.equals(this.info.getFrom(), from) && Objects.equals(this.info.getTo(), to);
    }

    /** for printing the node */
    public String toString(){
        return this.getInfo().getFrom()+" "+this.getInfo().getTo() ;
    }

}
