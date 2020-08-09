package uml;

/*
 * © Bart Kampers
 */

import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;
import org.mockito.*;
import uml.annotation.*;
import uml.structure.*;


public class UtilTest {

    
    @Test
    public void testDisplay() {
        Stereotype stereotype = () -> "name";
        assertEquals("«name»", Util.display(stereotype));
    }


    @Test
    public void testIsConstructor() {
        Operation operation = Mockito.mock(Operation.class);
        Mockito.when(operation.getStereotypes()).thenReturn(null);
        assertFalse(Util.isConstructor(operation));
        Mockito.when(operation.getStereotypes()).thenReturn(Collections.emptySet());
        assertFalse(Util.isConstructor(operation));
        Mockito.when(operation.getStereotypes()).thenReturn(new HashSet<>(Arrays.asList(() -> "any")));
        assertFalse(Util.isConstructor(operation));
        Mockito.when(operation.getStereotypes()).thenReturn(new HashSet<>(Arrays.asList(() -> Stereotype.CONSTRUCTOR)));
        assertTrue(Util.isConstructor(operation));
        Mockito.when(operation.getStereotypes()).thenReturn(new HashSet<>(Arrays.asList(() -> Stereotype.CONSTRUCTOR, () -> "any")));
        assertTrue(Util.isConstructor(operation));
    }

}