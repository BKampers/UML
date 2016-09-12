/*
** Copyright © Bart Kampers
*/

package bka.uml;

import bka.ocl.Typed;
import bka.ocl.*;


public class Parameter implements Typed {

    
    public static final int UNDEFINED = 0; 
    public static final int IN        = 1;
    public static final int OUT       = 2; 
    public static final int INOUT     = 3;

        
    public Parameter() {
    }
    
    
    public int getDirection() {
        return direction;
    }
    
    
    public void setDirection(int direction) {
        this.direction = direction;
    }

    
    public String getName() {
        return name;
    }

    
    public void setName(String name) {
        this.name = name;
    }

    
    public Type getType() {
        return type;
    }

    
    public void setType(Type type) {
        this.type = type;
    }
    
    
    public Value getDefaultValue() {
        return defaultValue;
    }
    
    
    public void setDefaultValue(Value value) {
        defaultValue = value;
    }
    
    
    public static String directionString(int direction) {
        switch (direction) {
            case Parameter.IN    : return "[IN]";
            case Parameter.OUT   : return "[OUT]";
            case Parameter.INOUT : return "[IN/OUT]";
            default              : return "";
        }
    }
    
    
    public String directionString() {
        return directionString(direction);
    }
    
    
    public String toString() {
        String string = directionString();
        if (string.length() > 0) {
            string += " ";
        }
        if (name != null) {
            string += name;
        }
        if (getType() != null) {
            string += " : " + getType();
        }
        return string;
    }
    
    
    private int direction = UNDEFINED;
    private String name;
    private Type type;
    
    private Value defaultValue = null;
    
}
