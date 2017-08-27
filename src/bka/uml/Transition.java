package bka.uml;


public interface Transition<E, G, A> {

    public StateDiagramVertex getSource();
    public StateDiagramVertex getTarget();

    public E getEvent();
    public G getGuardCondition();
    public A getAction();
    
}
