package uml.structure;


public interface Association {

    
    public enum Kind {
        PLAIN,
        AGGREGATION,
        COMPOSITION
    }


    public Structural getDependent();
    public Structural getIndependent();

    public Kind getKind();
    public boolean isDirected();

}
