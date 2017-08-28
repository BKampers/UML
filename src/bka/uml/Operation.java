package bka.uml;

import java.util.*;


public interface Operation extends Member {

    public boolean isAbstract();
    public List<Parameter> getParameters();
    public Set<Stereotype> getStereotypes();

}
