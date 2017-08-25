/*
** Copyright © Bart Kampers
*/

package bka.uml;

import bka.ocl.*;
import java.util.*;


public interface Interface extends Type, Named {

    public List<Operation> getOperations();

}
