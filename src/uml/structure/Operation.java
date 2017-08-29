package uml.structure;

import uml.annotation.*;
import java.util.*;


public interface Operation extends Member {

    public boolean isAbstract();
    public List<Parameter> getParameters();
    public Set<Stereotype> getStereotypes();

}
