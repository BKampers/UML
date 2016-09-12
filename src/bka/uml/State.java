package bka.uml;

public class State extends bka.graph.Vertex {

    
    public Action getEntryAction() {
        return entryAction;
    }
    
    
    public void setEntryAction(Action action) {
        entryAction = action;
    }
    
    
    public Action getExitAction() {
        return exitAction;
    }
    
    
    public void setExitAction(Action action) {
        exitAction = action;
    }
    
    
    public Activity getActivity() {
        return activity;
    }
    
    
    public void setActivity(Activity activity) {
        this.activity = activity;
    }
    
    
    public State getContainingState() {
        return containingState;
    }
    
    
    public void setContainingState(State state) {
        containingState = state;
    }
    
    
    private Action entryAction = null;
    private Activity activity = null;
    private Action exitAction = null;
    
    private State containingState = null;
    
}
