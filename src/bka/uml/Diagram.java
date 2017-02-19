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


    public Diagram getStateDiagram(Vertex container) {
        Collection<Vertex> vertices = new ArrayList<>();
        Collection<Edge> edges = new ArrayList<>();
        for (Vertex vertex : getVertices()) {
            if (isStateDiagramVertex(vertex) && findContainer(vertex) == container) {
                vertices.add(vertex);
                edges.addAll(allDirectedEdgesFrom(vertex));
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


    public boolean inheritance(bka.uml.Class descendantClass, bka.uml.Class ancestorClass) {
        boolean inheritance = false;
        if (descendantClass != null && ancestorClass != null) {
            if (descendantClass == ancestorClass) {
                inheritance = true;
            }
            else {
                Collection<Edge> generalizations = allEdges(bka.uml.Generalization.class);
                Graph classDiagram = new Graph(generalizations);
                java.util.List<Vertex> walk = classDiagram.directedWalk(descendantClass, ancestorClass);
                inheritance = ! walk.isEmpty();
            }
        }
        return inheritance;
    }


    private static boolean isStateDiagramVertex(Vertex vertex) {
        java.lang.Class cls = vertex.getClass();
        return cls == State.class || cls == ActionState.class || cls == InitialState.class || cls == FinalState.class;
    }

}
