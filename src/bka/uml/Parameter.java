/*
** Copyright © Bart Kampers
*/

package bka.uml;

import bka.ocl.Typed;


public class Parameter implements Typed {

    
    public enum Direction { 

        IN, OUT, INOUT;
        
        @Override 
        public String toString() {
            return '[' + super.toString() + ']';
        }

    }

        
    public Parameter() {
    }
    
    
    public Direction getDirection() {
        return direction;
    }
    
    
    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    
    @Override
    public String getName() {
        return name;
    }

    
    public void setName(String name) {
        this.name = name;
    }

    
    @Override
    public Type getType() {
        return type;
    }

    
    public void setType(Type type) {
        this.type = type;
    }
    
    
    public Expression getDefaultValue() {
        return defaultValue;
    }
    
    
    public void setDefaultValue(Expression value) {
        defaultValue = value;
    }
    
    
    public String directionString() {
        return direction.toString();
    }
    

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        if (direction != null) {
            builder.append(direction);
            builder.append(' ');
        }
        if (name != null) {
            builder.append(name);
        }
        if (getType() != null) {
            builder.append(" : ");
            builder.append(getType().getName());
        }
        return builder.toString();
    }
    
    
    private Direction direction;
    private String name;
    private Type type;
    
    private Expression defaultValue = null;
    
}
