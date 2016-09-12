/*
** Copyright © Bart Kampers
*/

package bka.uml;

import bka.ocl.*;


public class Attribute implements Member {
    
    
    public Attribute() {
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
    
    
    public Type getOwner() {
        return owner;
    }
    
    
    public void setOwner(Type owner) {
        assert owner instanceof bka.uml.Class;
        this.owner = owner;
    }
    
    
    public char getVisibility() {
        return visibility;
    }
    
    
    public void setVisibility(char visibility) {
        this.visibility = visibility;
    }
    
    
    public boolean isClassScoped() {
        return classScoped;
    }
    
    
    public void setClassScoped(boolean classScoped) {
        this.classScoped = classScoped;
    }
    
    
    public Value getInitialValue() {
        return initialValue;
    }

    
    public void setInitialValue(Value value) {
        initialValue = value;
    }
    
    
    public String nameTypeString() {
        return name + " : " + type;
    }
    
    
    public String toString() {
        return owner + "." + nameTypeString();
    }

    
    private String name;
    private Type type;
    private Type owner;
    private char visibility;
    private boolean classScoped;
    private Value initialValue;
    
}
