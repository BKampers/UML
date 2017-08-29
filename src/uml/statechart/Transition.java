package uml.statechart;


public interface Transition<E, G, A> {

    public TransitionSource getSource();
    public TransitionTarget getTarget();

    public E getEvent();
    public G getGuardCondition();
    public A getAction();
    
}
