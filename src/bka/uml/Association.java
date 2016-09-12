/*
** Copyright © Bart Kampers
*/

package bka.uml;


public class Association extends Dependency {

    
    public enum Kind {
        PLAIN,
        AGGREGATION,
        COMPOSITION
    }
    
    
    public Association() {
        setDirected(false);
    }
    
    
    public Kind getKind() {
        return kind;
    }

    
    public void setKind(Kind kind) {
        this.kind = kind;
    }

    
    private Kind kind = Kind.PLAIN;

}
