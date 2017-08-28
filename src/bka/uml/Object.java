package bka.uml;

import java.util.*;


public interface Object extends Thing, bka.ocl.Typed {

    public Map<Attribute, Expression> getAttributeValues();

}
