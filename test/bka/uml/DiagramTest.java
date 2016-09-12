package bka.uml;

/*
 * Copyright © Bart Kampers
 */

import bka.graph.*;
import bka.uml.*;
import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;


public class DiagramTest {

    public DiagramTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void inheritanceTest() {
        Collection<Vertex> vertices = new ArrayList<>();
        Collection<Edge> edges = new ArrayList<>();
        bka.uml.Class rootClass = new bka.uml.Class();
        bka.uml.Class baseClass = new bka.uml.Class();
        bka.uml.Class derivedClass1 = new bka.uml.Class();
        bka.uml.Class derivedClass2 = new bka.uml.Class();
        vertices.add(rootClass);
        vertices.add(baseClass);
        vertices.add(derivedClass1);
        vertices.add(derivedClass2);
        bka.uml.Generalization baseGeneralization = new bka.uml.Generalization();
        baseGeneralization.setOrigin(baseClass);
        baseGeneralization.setTerminus(rootClass);
        edges.add(baseGeneralization);
        bka.uml.Generalization generalization1 = new bka.uml.Generalization();
        generalization1.setOrigin(derivedClass1);
        generalization1.setTerminus(baseClass);
        edges.add(generalization1);
        bka.uml.Generalization generalization2 = new bka.uml.Generalization();
        generalization2.setOrigin(derivedClass2);
        generalization2.setTerminus(baseClass);
        edges.add(generalization2);
        Diagram diagram = new Diagram(vertices, edges);
        assertTrue(diagram.inheritance(baseClass, rootClass));
        assertTrue(diagram.inheritance(derivedClass1, baseClass));
        assertTrue(diagram.inheritance(derivedClass1, rootClass));
        assertTrue(diagram.inheritance(baseClass, baseClass));
        assertFalse(diagram.inheritance(rootClass, baseClass));
        assertFalse(diagram.inheritance(derivedClass1, derivedClass2));
    }

}