package bka.uml;

/**
 * @param <A> action
 */
public interface ActionState<A> extends StateDiagramVertex<A> {

    public A getAction();
    
}
