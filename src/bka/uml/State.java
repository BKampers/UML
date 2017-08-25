/*
** Copyright © Bart Kampers
*/

package bka.uml;

public class State<A> extends bka.graph.Vertex {


    public A getEntryAction() {
        return entryAction;
    }
    
    
    public void setEntryAction(A action) {
        entryAction = action;
    }
    
    
    public A getExitAction() {
        return exitAction;
    }
    
    
    public void setExitAction(A action) {
        exitAction = action;
    }
    
    
    public A getActivity() {
        return activity;
    }
    
    
    public void setActivity(A activity) {
        this.activity = activity;
    }
    
    
    private A entryAction;
    private A activity;
    private A exitAction;
     
}
