/*
** Copyright © Bart Kampers
*/

package bka.uml;

import java.util.*;


public class Interface extends bka.graph.Vertex implements Type {

    
    public Interface() {    
    }
    
    
    public List<Operation> getOperations() {
        return operations;
    }
    
    
    public void setOperations(List<Operation> operations) {
        this.operations = operations;
    }
    
    
    private List<Operation> operations = new ArrayList<Operation>();
    
    
}
