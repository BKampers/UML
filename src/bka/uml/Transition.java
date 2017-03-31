/*
** Copyright © Bart Kampers
*/

package bka.uml;

import bka.graph.*;

public class Transition<E, A> extends Edge {
    
    public Transition() {
        setDirected(true);
    }
    
    
    public E getEvent() {
        return event;
    }
    
    
    public void setEvent(E event) {
        this.event = event;
    }
    
    
    public A getAction() {
        return action;
    }

    
    public void setAction(A action) {
        this.action = action;
    }
    
    
    private E event;
    private A action;
    
}
