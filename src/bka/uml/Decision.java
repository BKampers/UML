package bka.uml;

/**
 * @param <E> expression
 */
public interface Decision<E> extends TransitionSource<E>, TransitionTarget<E>, bka.ocl.Typed {

    public E getExpression();

}
