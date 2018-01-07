package uml.structure;

import java.util.*;


public interface Object extends Structural, uml.structure.Typed {

    public Map<Attribute, Expression> getAttributeValues();

}
