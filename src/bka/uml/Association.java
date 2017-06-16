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
    }
    
    
    public Kind getKind() {
        return kind;
    }

    
    public void setKind(Kind kind) {
        this.kind = kind;
    }


    @Override
    public boolean isDirected() {
        return directed;
    }


    public void setDirected(boolean directed) {
        this.directed = directed;
    }

    
    private Kind kind = Kind.PLAIN;
    private boolean directed;

}
