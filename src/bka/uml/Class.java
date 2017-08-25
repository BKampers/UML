/*
** Copyright © Bart Kampers
*/

package bka.uml;

import bka.ocl.*;
import java.util.*;


public interface Class extends Type, Named {

    public List<Attribute> getAttributes();
    public List<Operation> getOperations();
    
}
