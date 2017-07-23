/*
** Copyright © Bart Kampers
*/

package bka.uml;

import java.util.*;


public class Operation implements Member {

    
    public Operation() {
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
    
    
    public boolean isAbstract() {
        return abstr;
    } 
    
    
    public void setAbstract(boolean abstr) {
        this.abstr = abstr;
    } 
    

    @Override
    public String getName() {
        return name;
    }
    
    
    public void setName(String name) {
        this.name = name;
    }
    
    
    public List<Parameter> getParameters() {
        return (parameters != null) ? new ArrayList<>(parameters) : null;
    }
    
    
    public void setParameters (List<Parameter> parameters) {
        this.parameters = (parameters != null) ? new ArrayList<>(parameters) : null;
    }
    

    @Override
    public Type getType() {
        return type;
    }
    
    
    public void setType(Type type) {
        this.type = type;
    }
    
    
    public void addStereotype(Stereotype stereotype) {
        synchronized (stereotypes) {
            stereotypes.add(stereotype);
        }
    }
    
    
    public boolean removeStereotype(Stereotype stereotype) {
        synchronized (stereotypes) {
            return stereotypes.remove(stereotype);
        }
    }


    public Set<Stereotype> getStereotypes() {
        return new HashSet<>(stereotypes);
    }
    
    
    public String parameterString() {
        StringBuilder builder = new StringBuilder("(");
        if (parameters != null) {
            boolean first = true;
            for (Parameter p : parameters) {
                if (! first) {
                    builder.append(", ");
                }
                builder.append(p.toString());
                first = false;
            }
        }
        builder.append(")");
        return builder.toString();
    }
    
    
    public String signature() {
        StringBuilder builder = new StringBuilder();
        if (name != null) {
            builder.append(name);
        }
        builder.append(parameterString());
        if (type != null) {
            builder.append(": ");
            builder.append(type.getName());
        }
        return builder.toString();
    }
    

    @Override
    public String toString() {
        return owner + "::" + signature();
    }
    
    
    private Type owner;
    private Visibility visibility;
    private boolean classScoped;
    private boolean abstr;
    private String name;
    private List<Parameter> parameters;
    private Type type;
    private final Set<Stereotype> stereotypes = new HashSet<>();
    
}
