/*
** Copyright © Bart Kampers
*/

package bka.uml;

import bka.ocl.*;


public class Attribute implements Member {
    
    
    public Attribute() {
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
    

    @Override
    public Type getOwner() {
        return owner;
    }
    
    
    public void setOwner(Type owner) {
        this.owner = owner;
    }
    

    @Override
    public Visibility getVisibility() {
        return visibility;
    }
    
    
    public void setVisibility(Visibility visibility) {
        this.visibility = visibility;
    }
    

    @Override
    public boolean isClassScoped() {
        return classScoped;
    }
    
    
    public void setClassScoped(boolean classScoped) {
        this.classScoped = classScoped;
    }
    
    
    public Typed getInitialValue() {
        return initialValue;
    }

    
    public void setInitialValue(Typed value) {
        initialValue = value;
    }
    

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        if (owner != null) {
            builder.append(owner.toString());
            builder.append('.');
        }
        if (name != null) {
            builder.append(name);
        }
        builder.append(": ");
        if (type != null) {
            builder.append(type.getName());
        }
        return builder.toString();
    }

    
    private String name;
    private Type type;
    private Type owner;
    private Visibility visibility;
    private boolean classScoped;
    private Typed initialValue;
    
}
