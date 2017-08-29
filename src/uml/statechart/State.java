package uml.statechart;


/**
 * @param <A> action or activity
 */
public interface State<A> extends TransitionSource<A>, TransitionTarget<A> {

    public String getName();
    public A getEntryAction();
    public A getExitAction();
    public A getActivity();
     
}
