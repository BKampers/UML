/*
** Copyright © Bart Kampers
*/

package bka.uml;


import java.util.ArrayList;


public class Stereotype {

    
    public static Stereotype get(String name) {
        synchronized (STEREOTYPES) {
            for (Stereotype stereotype : STEREOTYPES) {
                if (name.equals(stereotype.name)) {
                    return stereotype;
                }
            }
            Stereotype stereotype = new Stereotype();
            stereotype.name = name;
            STEREOTYPES.add(stereotype);
            return stereotype;
        }
    }

    
    public String getName() {
        return name;
    }

    
    public void setName(String name) {
        this.name = name;
    }
    
    
    public String toString() {
        return '«' + name + '»';
    }
    
    
    private String name;
    
    
    private static final ArrayList<Stereotype> STEREOTYPES = new ArrayList<Stereotype>();
}
