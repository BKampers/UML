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
        Collection<Edge> edges = new ArrayList<>();
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
        assertFalse(diagram.inheritance(DERIVED_CLASS_1, INTERFACE));
        assertTrue(diagram.inheritance(DERIVED_CLASS_2, INTERFACE));
    }


    @Test
    public void typeHierarchyTest() {
        Diagram typeHierarchy = diagram.getTypeHierarchy(DERIVED_CLASS_1);
        assertTrue(typeHierarchy.getVertices().contains(ROOT_CLASS));
        assertTrue(typeHierarchy.getVertices().contains(BASE_CLASS));
        assertFalse(typeHierarchy.getVertices().contains(INTERFACE));
        assertTrue(typeHierarchy.getVertices().contains(DERIVED_CLASS_1));
        assertFalse(typeHierarchy.getVertices().contains(DERIVED_CLASS_2));
        assertEquals(2, typeHierarchy.getEdges().size());
        typeHierarchy = diagram.getTypeHierarchy(DERIVED_CLASS_2);
        assertTrue(typeHierarchy.getVertices().contains(ROOT_CLASS));
        assertTrue(typeHierarchy.getVertices().contains(BASE_CLASS));
        assertTrue(typeHierarchy.getVertices().contains(INTERFACE));
        assertTrue(typeHierarchy.getVertices().contains(DERIVED_CLASS_2));
        assertFalse(typeHierarchy.getVertices().contains(DERIVED_CLASS_1));
        assertEquals(3, typeHierarchy.getEdges().size());
    }

    
    @Test
    public void stateDiagramTest() {
        Diagram<State<Action>, Transition<Event, Guard, Action>> stateDiagram = diagram.getStateDiagram(METHOD);
        assertTrue(stateDiagram.getVertices().contains(INITIAL_STATE));
        assertTrue(stateDiagram.getVertices().contains(ACTION_STATE_1));
        assertTrue(stateDiagram.getVertices().contains(DECISION));
        assertTrue(stateDiagram.getVertices().contains(ACTION_STATE_2A));
        assertTrue(stateDiagram.getVertices().contains(ACTION_STATE_2B));
        assertTrue(stateDiagram.getVertices().contains(FINAL_STATE));
        assertEquals(6, stateDiagram.getEdges().size());
    }


    private void initClasses(Collection<Vertex> vertices, Collection<Edge> edges) {
        vertices.add(INTERFACE);
        vertices.add(ROOT_CLASS);
        vertices.add(BASE_CLASS);
        vertices.add(DERIVED_CLASS_1);
        vertices.add(DERIVED_CLASS_2);
        Generalization baseGeneralization = new Generalization();
        baseGeneralization.setOrigin(BASE_CLASS);
        baseGeneralization.setTerminus(ROOT_CLASS);
        edges.add(baseGeneralization);
        Generalization generalization1 = new Generalization();
        generalization1.setOrigin(DERIVED_CLASS_1);
        generalization1.setTerminus(BASE_CLASS);
        edges.add(generalization1);
        Generalization generalization2 = new Generalization();
        generalization2.setOrigin(DERIVED_CLASS_2);
        generalization2.setTerminus(BASE_CLASS);
        edges.add(generalization2);
        Realization realization = new Realization();
        realization.setOrigin(DERIVED_CLASS_2);
        realization.setTerminus(INTERFACE);
        edges.add(realization);

    }


    private void initStateMachine(Collection<Vertex> vertices, Collection<Edge> edges) {
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
        Transition<Event, Guard, Action> initialTransition = new Transition<>();
        initialTransition.setOrigin(INITIAL_STATE);
        initialTransition.setTerminus(ACTION_STATE_1);
        edges.add(initialTransition);
        Transition<Event, Guard, Action> transition1 = new Transition<>();
        transition1.setOrigin(ACTION_STATE_1);
        transition1.setTerminus(DECISION);
        edges.add(transition1);
        Transition<Event, Guard, Action> transition2a = new Transition<>();
        transition2a.setOrigin(DECISION);
        transition2a.setTerminus(ACTION_STATE_2A);
        edges.add(transition2a);
        Transition<Event, Guard, Action> transition2b = new Transition<>();
        transition2b.setOrigin(DECISION);
        transition2b.setTerminus(ACTION_STATE_2B);
        edges.add(transition2b);
        Transition<Event, Guard, Action> transition3a = new Transition<>();
        transition3a.setOrigin(ACTION_STATE_2A);
        transition3a.setTerminus(FINAL_STATE);
        edges.add(transition3a);
        Transition<Event, Guard, Action> transition3b = new Transition<>();
        transition3b.setOrigin(ACTION_STATE_2B);
        transition3b.setTerminus(FINAL_STATE);
        edges.add(transition3b);
    }


    private class Event {}
    private class Guard {}
    private class Action {}


    private Diagram diagram;

    private static final bka.uml.Interface INTERFACE = new bka.uml.Interface();
    private static final bka.uml.Class ROOT_CLASS = new bka.uml.Class();
    private static final bka.uml.Class BASE_CLASS = new bka.uml.Class();
    private static final bka.uml.Class DERIVED_CLASS_1 = new bka.uml.Class();
    private static final bka.uml.Class DERIVED_CLASS_2 = new bka.uml.Class();

    private static final Vertex METHOD = new Vertex();
    private static final InitialState INITIAL_STATE = new InitialState();
    private static final ActionState  ACTION_STATE_1 = new ActionState<Action>();
    private static final Decision DECISION = new Decision<Action>();
    private static final ActionState  ACTION_STATE_2A = new ActionState<Action>();
    private static final ActionState  ACTION_STATE_2B = new ActionState<Action>();
    private static final FinalState FINAL_STATE = new FinalState();


}