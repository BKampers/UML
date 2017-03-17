/*
** Copyright © Bart Kampers
*/

package bka.uml;

import bka.ocl.*;
import java.util.*;


public class Class extends bka.graph.Vertex implements Type, Named {

   
    public void setAttributes(Collection<Attribute> attributes) {
        this.attributes = (attributes != null) ? new ArrayList<>(attributes) : null;
    }
    
    
    public Collection<Attribute> getAttributes() {
        return (attributes != null) ? new ArrayList<>(attributes) : null;
    }
    
    
    public void setOperations(List<Operation> operations) {
        this.operations = (operations != null) ? new ArrayList<>(operations) : null;
    }


    public List<Operation> getOperations() {
        return (operations != null) ? new ArrayList<>(operations) : null;
    }
    
    
    public void setAbstract(boolean abs) {
        abstractClass = abs;
    }
    
    
    public boolean isAbstract() {
        return abstractClass;
    }
    
    
    private Collection<Attribute> attributes;
    private Collection<Operation> operations;

    private boolean abstractClass;

}
