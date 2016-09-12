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


    public Collection<Edge> allEdges(java.lang.Class cls) {
        Collection<Edge> all = new Vector<Edge>();
        for (Edge edge : getEdges()) {
            if (edge.getClass() == cls) {
                all.add(edge);
            }
        }
        return all;
    }


    public Collection<Vertex> allVertices(java.lang.Class cls) {
        Vector<Vertex> all = new Vector<Vertex>();
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

}
