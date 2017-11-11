package uml.structure;

import java.util.*;


public interface Class extends Type {

    public List<Attribute> getAttributes();
    public List<Operation> getOperations();
    
}
