package uml.structure;

import java.util.*;


public interface Operation extends Member, Stereotyped {

    public boolean isAbstract();
    public List<Parameter> getParameters();

}
