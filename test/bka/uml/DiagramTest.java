package bka.uml;

/*
 * Copyright © Bart Kampers
 */

import bka.graph.*;

import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;


public class DiagramTest {


    @Before
    public void init() {
        Collection<Vertex> vertices = new ArrayList<>();
        Collection<Edge<Vertex>> edges = new ArrayList<>();
        initClasses(vertices, edges);
        initStateMachine(vertices, edges);
        diagram = new Diagram(vertices, edges);
    }


    @Test
    public void inheritanceTest() {
        assertTrue(diagram.inheritance(BASE_CLASS, ROOT_CLASS));
        assertTrue(diagram.inheritance(DERIVED_CLASS_1, BASE_CLASS));
        assertTrue(diagram.inheritance(DERIVED_CLASS_1, ROOT_CLASS));
        assertTrue(diagram.inheritance(BASE_CLASS, BASE_CLASS));
        assertFalse(diagram.inheritance(ROOT_CLASS, BASE_CLASS));
        assertFalse(diagram.inheritance(DERIVED_CLASS_1, DERIVED_CLASS_2));
    }

    
    @Test
    public void stateMachineTest() {
        Diagram stateDiagram = diagram.getStateDiagram(METHOD);
        assertTrue(stateDiagram.getVertices().contains(INITIAL_STATE));
        assertTrue(stateDiagram.getVertices().contains(ACTION_STATE_1));
        assertTrue(stateDiagram.getVertices().contains(DECISION));
        assertTrue(stateDiagram.getVertices().contains(ACTION_STATE_2A));
        assertTrue(stateDiagram.getVertices().contains(ACTION_STATE_2B));
        assertTrue(stateDiagram.getVertices().contains(FINAL_STATE));
    }


    private void initClasses(Collection<Vertex> vertices, Collection<Edge<Vertex>> edges) {
        vertices.add(ROOT_CLASS);
        vertices.add(BASE_CLASS);
        vertices.add(DERIVED_CLASS_1);
        vertices.add(DERIVED_CLASS_2);
        bka.uml.Generalization baseGeneralization = new bka.uml.Generalization();
        baseGeneralization.setOrigin(BASE_CLASS);
        baseGeneralization.setTerminus(ROOT_CLASS);
        edges.add(baseGeneralization);
        bka.uml.Generalization generalization1 = new bka.uml.Generalization();
        generalization1.setOrigin(DERIVED_CLASS_1);
        generalization1.setTerminus(BASE_CLASS);
        edges.add(generalization1);
        bka.uml.Generalization generalization2 = new bka.uml.Generalization();
        generalization2.setOrigin(DERIVED_CLASS_2);
        generalization2.setTerminus(BASE_CLASS);
        edges.add(generalization2);
    }


    private void initStateMachine(Collection<Vertex> vertices, Collection<Edge<Vertex>> edges) {
        vertices.add(METHOD);
        vertices.add(INITIAL_STATE);
        vertices.add(ACTION_STATE_1);
        vertices.add(DECISION);
        vertices.add(ACTION_STATE_2A);
        vertices.add(ACTION_STATE_2B);
        vertices.add(FINAL_STATE);
        edges.add(new ContainerEdge(METHOD, INITIAL_STATE));
        edges.add(new ContainerEdge(METHOD, ACTION_STATE_1));
        edges.add(new ContainerEdge(METHOD, DECISION));
        edges.add(new ContainerEdge(METHOD, ACTION_STATE_2A));
        edges.add(new ContainerEdge(METHOD, ACTION_STATE_2B));
        edges.add(new ContainerEdge(METHOD, FINAL_STATE));
        Transition initialTransition = new Transition();
        initialTransition.setOrigin(INITIAL_STATE);
        initialTransition.setTerminus(ACTION_STATE_1);
        edges.add(initialTransition);
        Transition transition1 = new Transition();
        transition1.setOrigin(ACTION_STATE_1);
        transition1.setTerminus(DECISION);
        edges.add(transition1);
        Transition transition2a = new Transition();
        transition2a.setOrigin(DECISION);
        transition2a.setTerminus(ACTION_STATE_2A);
        edges.add(transition2a);
        Transition transition2b = new Transition();
        transition2b.setOrigin(DECISION);
        transition2b.setTerminus(ACTION_STATE_2B);
        edges.add(transition2b);
        Transition transition3a = new Transition();
        transition3a.setOrigin(ACTION_STATE_2A);
        transition3a.setTerminus(FINAL_STATE);
        edges.add(transition3a);
        Transition transition3b = new Transition();
        transition3b.setOrigin(ACTION_STATE_2B);
        transition3b.setTerminus(FINAL_STATE);
        edges.add(transition3b);
    }


    private Diagram diagram;

    private static final bka.uml.Class ROOT_CLASS = new bka.uml.Class();
    private static final bka.uml.Class BASE_CLASS = new bka.uml.Class();
    private static final bka.uml.Class DERIVED_CLASS_1 = new bka.uml.Class();
    private static final bka.uml.Class DERIVED_CLASS_2 = new bka.uml.Class();

    private static final Vertex METHOD = new Vertex();
    private static final InitialState INITIAL_STATE = new InitialState();
    private static final ActionState  ACTION_STATE_1 = new ActionState();
    private static final Decision DECISION = new Decision();
    private static final ActionState  ACTION_STATE_2A = new ActionState();
    private static final ActionState  ACTION_STATE_2B = new ActionState();
    private static final FinalState FINAL_STATE = new FinalState();


}