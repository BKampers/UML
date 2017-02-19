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
    
    
    private Action entryAction;
    private Activity activity;
    private Action exitAction;
     
}
