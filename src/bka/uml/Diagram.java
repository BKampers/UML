/*
** Copyright © Bart Kampers
*/

package bka.uml;


import bka.graph.*;
import java.util.*;


public class Diagram extends Graph {


    public Diagram(Collection<Vertex> vertices, Collection<Edge> edges) {
        super(vertices, edges);
    }


    public Diagram(Graph graph) {
        super(graph.getVertices(), graph.getEdges());
    }


    public Diagram getTypeHierarchy(Vertex type) {
        if (! isTypeVertex(type)) {
            throw new IllegalArgumentException("Not a type: " + type);
        }
        Collection<Vertex> vertices = new ArrayList<>();
        Collection<Edge> edges = new ArrayList<>();
        vertices.add(type);
        for (Edge edge : allDirectedEdgesFrom(type)) {
            if (isInheritanceEdge(edge)) {
                edges.add(edge);
                Diagram parentDiagram = getTypeHierarchy(edge.getTerminus());
                vertices.addAll(parentDiagram.getVertices());
                edges.addAll(parentDiagram.getEdges());
            }
        }
        return new Diagram(vertices, edges);
    }


    public Diagram getStateDiagram(Vertex container) {
        Collection<Vertex> vertices = new ArrayList<>();
        Collection<Edge> edges = new ArrayList<>();
        for (Vertex vertex : getVertices()) {
            if (isStateDiagramVertex(vertex) && findContainer(vertex) == container) {
                vertices.add(vertex);
                for (Edge edge : allDirectedEdgesFrom(vertex)) {
                    if (edge.getClass() == Transition.class) {
                        edges.add(edge);
                    }
                }
            }
        }
        return new Diagram(vertices, edges);
    }


    public Collection<Edge> allEdges(java.lang.Class cls) {
        Collection<Edge> all = new ArrayList<>();
        for (Edge edge : getEdges()) {
            if (edge.getClass() == cls) {
                all.add(edge);
            }
        }
        return all;
    }


    public Collection<Vertex> allVertices(java.lang.Class cls) {
        Collection<Vertex> all = new ArrayList<>();
        for (Vertex vertex : getVertices()) {
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
    public boolean inheritance(Vertex descendantType, Vertex ancestorType) {
        if (! (descendantType instanceof Type) || ! (ancestorType instanceof Type)) {
            throw new IllegalArgumentException();
        }
        if (descendantType == ancestorType) {
            return true;
        }
        else {
            Graph classDiagram = new Graph(allEdges(bka.uml.Generalization.class));
            classDiagram.addEdges(allEdges(bka.uml.Realization.class));
            java.util.List<Vertex> walk = classDiagram.directedWalk(descendantType, ancestorType);
            return ! walk.isEmpty();
        }
    }
    
    
    private static boolean isInheritanceEdge(Edge edge) {
        java.lang.Class cls = edge.getClass();
        return cls == Generalization.class || cls == Realization.class;
        
    }


    private static boolean isTypeVertex(Vertex vertex) {
        java.lang.Class cls = vertex.getClass();
        return cls == bka.uml.Class.class || cls == bka.uml.Interface.class;
    }


    private static boolean isStateDiagramVertex(Vertex vertex) {
        java.lang.Class cls = vertex.getClass();
        return cls == State.class || cls == ActionState.class || cls == InitialState.class || cls == FinalState.class;
    }

}
