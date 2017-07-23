/*
** Copyright © Bart Kampers
*/

package bka.uml;

import java.util.*;


public class Interface extends bka.graph.Vertex implements Type, bka.ocl.Named {

    
    public Interface() {    
    }


    @Override
    public boolean isAbstract() {
        return true;
    }
   
    
    public List<Operation> getOperations() {
        return (operations != null) ? new ArrayList<>(operations) : null;
    }
    
    
    public void setOperations(List<Operation> operations) {
        this.operations = (operations != null) ? new ArrayList<>(operations) : null;
    }
    
    
    private List<Operation> operations;

    
}
