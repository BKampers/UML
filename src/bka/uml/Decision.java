package bka.uml;

/**
 * @param <E> expression
 */
public interface Decision<E> extends StateDiagramVertex<E>, bka.ocl.Typed {

    public E getExpression();

}
