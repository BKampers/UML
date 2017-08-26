/*
** Copyright © Bart Kampers
*/

package bka.uml;

/**
 * @param <A> action or activity
 */
public interface State<A> {

    public String getName();
    public A getEntryAction();
    public A getExitAction();
    public A getActivity();
     
}
