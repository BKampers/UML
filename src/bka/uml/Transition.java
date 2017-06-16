/*
** Copyright © Bart Kampers
*/

package bka.uml;

import bka.graph.*;

public class Transition<E, G, A> extends DirectedEdge {
    
    
    public E getEvent() {
        return event;
    }
    
    
    public void setAction(A action) {
        this.action = action;
    }


    public G getGuardCondition() {
        return guardCondition;
    }


    public void setGuardCondition(G guardCondition) {
        this.guardCondition = guardCondition;
    }
    
    
    public void setEvent(E event) {
        this.event = event;
    }


    public A getAction() {
        return action;
    }


    private E event;
    private G guardCondition;
    private A action;
    
}
