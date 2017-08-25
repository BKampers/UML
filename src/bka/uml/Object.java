/*
** Copyright © Bart Kampers
*/

package bka.uml;

import java.util.*;


public interface Object extends bka.ocl.Typed {

    public Map<Attribute, Expression> getAttributeValues();

}
