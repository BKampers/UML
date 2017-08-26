/*
** Copyright © Bart Kampers
*/

package bka.uml;


public interface Transition<E, G, A> {

    public E getEvent();
    public G getGuardCondition();
    public A getAction();
    
}
