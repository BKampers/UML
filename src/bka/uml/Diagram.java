/*
** Copyright © Bart Kampers
*/

package bka.uml;


import bka.graph.*;
import java.util.*;


public class Diagram<V extends Vertex, E extends Edge<V>> extends Graph<V, E> {


    public Diagram(Collection<V> vertices, Collection<E> edges) {
        super(vertices, edges);
    }


    public Diagram(Graph<V, E> graph) {
        super(graph.getVertices(), graph.getEdges());
    }


    public Diagram getTypeHierarchy(V type) {
        if (! isTypeVertex(type)) {
            throw new IllegalArgumentException("Not a type: " + type);
        }
        Collection<V> vertices = new ArrayList<>();
        Collection<E> edges = new ArrayList<>();
        vertices.add(type);
        for (E edge : allDirectedEdgesFrom(type)) {
            if (isInheritanceEdge(edge)) {
                edges.add(edge);
                Diagram parentDiagram = getTypeHierarchy(edge.getTerminus());
                vertices.addAll(parentDiagram.getVertices());
                edges.addAll(parentDiagram.getEdges());
            }
        }
        return new Diagram(vertices, edges);
    }


    public Diagram getStateDiagram(V container) {
        Collection<State> vertices = new ArrayList<>();
        Collection<Transition> edges = new ArrayList<>();
        for (V vertex : getVertices()) {
            if (isStateDiagramVertex(vertex) && findContainer(vertex) == container) {
                vertices.add((State) vertex);
                for (E edge : allDirectedEdgesFrom(vertex)) {
                    if (edge.getClass() == Transition.class) {
                        edges.add((Transition) edge);
                    }
                }
            }
        }
        return new Diagram<>(vertices, edges);
    }


    public Collection<E> allEdges(java.lang.Class cls) {
        Collection<E> all = new ArrayList<>();
        for (E edge : getEdges()) {
            if (edge.getClass() == cls) {
                all.add(edge);
            }
        }
        return all;
    }


    public Collection<V> allVertices(java.lang.Class cls) {
        Collection<V> all = new ArrayList<>();
        for (V vertex : getVertices()) {
            if (vertex.getClass() == cls) {
                all.add(vertex);
            }
        }
        return all;
    }


    public Collection<Vertex> allClassVertices() {
        Collection<Vertex> collection = new ArrayList<>();
        for (Vertex vertex : getVertices()) {
            if (bka.uml.Class.class.isAssignableFrom(vertex.getClass())) {
                collection.add(vertex);
            }
        }
        return collection;
    }


    public Collection<Vertex> allTypeVertices() {
        Collection<Vertex> collection = new ArrayList<>();
        for (Vertex vertex : getVertices()) {
            if (vertex instanceof bka.uml.Type) {
                collection.add(vertex);
            }
        }
        return collection;
    }


    /**
     *
     * @param descendantType
     * @param ancestorType
     * @return true if the first argument is a descendant of the second
     */
    public boolean inheritance(V descendantType, V ancestorType) {
        if (! (descendantType instanceof Type) || ! (ancestorType instanceof Type)) {
            throw new IllegalArgumentException();
        }
        if (descendantType == ancestorType) {
            return true;
        }
        else {
            Graph<V, E> classDiagram = new Graph<>(allEdges(bka.uml.Generalization.class));
            classDiagram.addEdges(allEdges(bka.uml.Realization.class));
            java.util.List<V> walk = classDiagram.directedWalk(descendantType, ancestorType);
            return ! walk.isEmpty();
        }
    }
    
    
    private static boolean isInheritanceEdge(Edge edge) {
        java.lang.Class cls = edge.getClass();
        return cls == Generalization.class || cls == Realization.class;
        
    }


    private static boolean isTypeVertex(Vertex vertex) {
        java.lang.Class cls = vertex.getClass();
        return bka.uml.Type.class.isAssignableFrom(cls);
    }


    private static boolean isStateDiagramVertex(Vertex vertex) {
        java.lang.Class cls = vertex.getClass();
        return cls == State.class || cls == ActionState.class || cls == Decision.class || cls == InitialState.class || cls == FinalState.class;
    }

}
