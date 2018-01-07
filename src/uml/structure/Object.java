package uml.structure;

import java.util.*;


public interface Object extends Structural, Typed {

    public Map<Attribute, Expression> getAttributeValues();

}
