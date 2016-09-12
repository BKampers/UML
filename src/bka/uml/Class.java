/*
** Copyright © Bart Kampers
*/

package bka.uml;

import java.util.*;


public class Class extends bka.graph.Vertex implements Type {
    
    
    public void setAttributes(Collection<Attribute> attributes) {
        this.attributes = attributes;
    }
    
    
    public Collection<Attribute> getAttributes() {
        return attributes;
    }
    
    
    public Collection<Operation> getOperations() {
        return operations;
    }
    
    
    public void setOperations(List<Operation> operations) {
        this.operations = operations;
    }
    
    
    public void setAbstract(boolean abs) {
        abstractClass = abs;
    }
    
    
    public boolean isAbstract() {
        return abstractClass;
    }
    
    
    private Collection<Attribute> attributes = new Vector<Attribute>();
    private Collection<Operation> operations = new Vector<Operation>();

    private boolean abstractClass = false;
}
