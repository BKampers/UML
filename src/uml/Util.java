/*
** © Bart Kampers
*/

package uml;

import java.util.*;
import uml.annotation.*;
import uml.structure.*;


public class Util {
    
    
    public static boolean isConstructor(Operation operation) {
        return hasStereotype(operation, Stereotype.CONSTRUCTOR);
    }
    
    
    private static boolean hasStereotype(Stereotyped stereotyped, String name) {
        Set<Stereotype> stereotypes = stereotyped.getStereotypes();
        if (stereotypes != null) {
            for (Stereotype stereotype : stereotypes) {
                if (name.equals(stereotype.getName())) {
                    return true;
                }
            }
        }
        return false;
    }
    
}
