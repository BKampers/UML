package bka.uml;


public interface Association {

    
    public enum Kind {
        PLAIN,
        AGGREGATION,
        COMPOSITION
    }


    public Thing getDependent();
    public Thing getIndependent();

    public Kind getKind();
    public boolean isDirected();

}
