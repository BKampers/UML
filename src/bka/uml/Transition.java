package bka.uml;

import bka.graph.*;

public class Transition extends Edge {
    
    public Transition() {
        setDirected(true);
    }
    
    
    public Event getEvent() {
        return event;
    }
    
    
    public void setEvent(Event event) {
        this.event = event;
    }
    
    
    public Action getAction() {
        return action;
    }

    
    public void setAction(Action action) {
        this.action = action;
    }
    
    
    private Event event = null;
    private Action action = null;
    
}
