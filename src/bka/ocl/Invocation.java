/*
** Copyright © Bart Kampers
*/

package bka.ocl;


import bka.uml.Type;
import bka.uml.*;
import java.util.*;


public class Invocation implements Typed {


    public Invocation(Operation operation, Map<Parameter, Expression> parameters) {
        this.operation = operation;
        this.parameters = parameters;
    }

    
    public Invocation() {
    }

    
    public String getName() {
        return operation.getName();
    }
    
    
    public Operation getOperation() {
        return operation;
    }

    
    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    
    public Map<Parameter, Expression> getParameters() {
        return parameters;
    }

    
    public void setParameters(Map<Parameter, Expression> parameters) {
        this.parameters = parameters;
    }

    
    public Type getType() {
        return operation.getType();
    }
    
    
    public String toString() {
        String string =  operation.getName() + '(';
        boolean first = true;
        for (Parameter parameter : operation.getParameters()) {
            if (! first) {
                string += ", ";
            }
            first = false;
            Expression expression = parameters.get(parameter);
            if (expression != null) {
                string += expression.toString();
            }
        }
        string += ')';
        return string;
    }

    
    private Operation operation;
    private Map<Parameter, Expression> parameters = new HashMap<Parameter, Expression>();

}
