/*
** Copyright © Bart Kampers
*/

package bka.uml;


import bka.ocl.*;
import java.util.*;


public class Object extends bka.graph.Vertex implements Typed {

    
    public Object() {
    }

    
    public Type getType() {
        return type;
    }

    
    public void setType(Type type) {
        assert type instanceof bka.uml.Class || type == null;
        this.type = (bka.uml.Class) type;
    }

    
    public Map<Attribute, Typed> getAttributeValues() {
        return attributeValues;
    }

    
    public void setAttributeValues(Map<Attribute, Typed> values) {
        attributeValues.clear();
        for (Map.Entry<Attribute, Typed> entry : values.entrySet()) {
            if (entry.getValue() != null) {
                attributeValues.put(entry.getKey(), entry.getValue());
            }
        }
    }

    
    public String toString() {
        String string = ":";
        if (name != null) {
            string = name + ' ' + string;
        }
        if (type != null) {
            String typeName = type.getName();
            if (typeName != null) {
                string += ' ' + typeName;
            }
        }
        return string;
    }

    
    private bka.uml.Class type = null;
    private final Map<Attribute, Typed> attributeValues = new HashMap<>();
}
