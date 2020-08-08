/*
** © Bart Kampers
*/

package uml;

import java.util.*;
import uml.annotation.*;
import uml.structure.*;


public class Util {
    
    
    public static String display(Stereotype stereotype) {
        return '«' + stereotype.getName() + '»';
    }
    
    
    public static boolean isConstructor(Operation operation) {
        return hasStereotype(operation, Stereotype.CONSTRUCTOR);
    }
    
    
    private static boolean hasStereotype(Stereotyped stereotyped, String name) {
        Set<Stereotype> stereotypes = stereotyped.getStereotypes();
        return stereotypes != null && stereotypes.stream().anyMatch(s -> name.equals(s.getName()));
    }

}
