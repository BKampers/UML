package uml.structure;

import java.util.*;


public interface Object extends Structural, bka.ocl.Typed {

    public Map<Attribute, Expression> getAttributeValues();

}
