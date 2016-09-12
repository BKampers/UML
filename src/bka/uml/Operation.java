/*
** Copyright © Bart Kampers
*/

package bka.uml;

import java.util.*;


public class Operation implements Member {

    
    public Operation() {
    }
    
    
    public Type getOwner() {
        return owner;
    }
    
    
    public void setOwner(Type owner) {
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
    
    
    public boolean isAbstract() {
        return abstr;
    } 
    
    
    public void setAbstract(boolean abstr) {
        this.abstr = abstr;
    } 
    
    
    public String getName() {
        return name;
    }
    
    
    public void setName(String name) {
        this.name = name;
    }
    
    
    public List<Parameter> getParameters() {
        return parameters;
    }
    
    
    public void setParameters (List<Parameter> parameters) {
        this.parameters = parameters;
    }
    
    
    public Type getType() {
        return type;
    }
    
    
    public void setType(Type type) {
        this.type = type;
    }
    
    
    public ArrayList<Stereotype> getStereotypes() {
        synchronized (stereotypes) {
            return stereotypes;
        }        
    }
    
    
    public void setStereotypes(ArrayList<Stereotype> list) {
        synchronized (stereotypes) {
            stereotypes.clear();
            stereotypes.addAll(list);
        }        
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
    
    
    public String parameterString() {
        String string = "(";
        Iterator p = parameters.iterator();
        while (p.hasNext()) {
            string += p.next();
            if (p.hasNext()) {
                string += ", ";
            }
        }
        string += ")";
        return string;
    }
    
    
    public String signature() {
        String string = "";
        if (name != null) {
            string += name;
        }
        string += parameterString();
        if (type != null) {
            string +=  " : " + type;
        }
        return string;
    }
    
    
    public String toString() {
        return owner + "::" + signature();
    }
    
    
    private Type owner = null;
    private char visibility = Member.UNDEFINED_VISIBILITY;
    private boolean classScoped = false;
    private boolean abstr = false;
    private String name = null;
    private List<Parameter> parameters = new ArrayList<Parameter>();
    private Type type = null;
    
    private final ArrayList<Stereotype> stereotypes = new ArrayList<Stereotype>();
    
}
