/*
** Copyright © Bart Kampers
*/

package bka.ocl;


import bka.uml.Type;
import java.util.*;


public class Expression {

    
    public Expression(List<Typed> path) {
        this.path = new LinkedList<Typed>(path);
    }
    
    
    public Expression(Typed typed) {
        path = new LinkedList<Typed>();
        path.add(typed);
    }


    public Expression() {
    }

    
    public LinkedList<Typed> getPath() {
        return path;
    }

    
    public final void setPath(LinkedList<Typed> path) {
        this.path = path;
    }

    
    public Type getType() {
        return (! path.isEmpty()) ? path.getLast().getType() : null;
    }
    
    
    public String name() {
        String string = new String();
        Typed head = path.getFirst();
        for (Typed typed : path) {
            if (typed != head && ! (typed instanceof BinaryOperation)) {
                string += '.';
            }
            string += name(typed);
        }
        return string;
    }


    public Typed evaluate() {
        throw new UnsupportedOperationException();
    }

    
    public String toString() {
        String string = new String();
        Typed tail = path.getLast();
        for (Typed typed : path) {
            if (typed != null) {
                string += typed.toString();
            }
            else {
                string += "(null)";
            }
            if (typed != tail) {
                string += '.';
            }
        }
        return string;
    }
    
    
    private String name(Typed typed) {
        if (typed instanceof bka.uml.Class) {
            return ((bka.uml.Class) typed).getName();
        }
        else if (typed instanceof bka.uml.Object) {
            return ((bka.uml.Object) typed).getName();
        }
        else if (typed instanceof bka.uml.Attribute) {
            return ((bka.uml.Attribute) typed).getName();
        }
        else if (typed instanceof bka.uml.Operation) {
            return ((bka.uml.Operation) typed).getName();
        }
        else if (typed instanceof bka.uml.Parameter) {
            return ((bka.uml.Parameter) typed).getName();
        }
        else if (typed instanceof bka.ocl.Invocation) {
            String string = new String();
            bka.uml.Operation operation = ((bka.ocl.Invocation) typed).getOperation();
            if (operation != null) {
                string += operation.getName();
            }
            else {
                string += "(null)";
            }
            string += "(";
            Map<bka.uml.Parameter, Expression> parameters = ((bka.ocl.Invocation) typed).getParameters();
            if (parameters != null) {
                boolean first = true;
                for (Map.Entry<bka.uml.Parameter, Expression> entry : ((bka.ocl.Invocation) typed).getParameters().entrySet()) {
                    if (! first) {
                        string += ", ";
                    }
                    first = false;
                    string += entry.getValue().name();
                }
            }
            string += ")";
            return string;
        }
        else {
            return typed.toString();
        }
    }
    
    
    private LinkedList<Typed> path;

}
