package uml.structure;

public interface Realization extends Dependency {

    public Type getAncestor();
    public Type getDescendant();

}
