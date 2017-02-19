/*
** Copyright © Bart Kampers
*/

package bka.uml;

import java.util.*;


public class Object extends bka.graph.Vertex implements bka.ocl.Typed {

    
    public Object() {
    }


    @Override
    public Type getType() {
        return type;
    }

    
    public void setType(Type type) {
        this.type = (bka.uml.Class) type;
    }

    
    public Map<Attribute, Expression> getAttributeValues() {
        if (attributeValues != null) {
            return new HashMap(attributeValues);
        }
        else {
            return null;
        }
    }

    
    public void setAttributeValues(Map<Attribute, Expression> values) {
        if (values != null) {
            attributeValues = new HashMap(values);
        }
        else {
            attributeValues = null;
        }
    }


    @Override
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

    
    private bka.uml.Class type;
    private Map<Attribute, Expression> attributeValues;
}
