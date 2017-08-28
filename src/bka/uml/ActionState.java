package bka.uml;

/**
 * @param <A> action
 */
public interface ActionState<A> extends TransitionSource<A>, TransitionTarget<A> {

    public A getAction();
    
}
