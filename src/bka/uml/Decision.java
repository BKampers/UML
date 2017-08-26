/*
** Copyright © Bart Kampers
*/

package bka.uml;

/**
 * @param <E> expression
 */
public interface Decision<E> extends bka.ocl.Typed {

    public E getExpression();

}
