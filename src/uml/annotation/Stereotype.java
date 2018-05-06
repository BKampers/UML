package uml.annotation;


public interface Stereotype {

    public static final String CONSTRUCTOR = "constructor";
    public static final String CREATE = "create";
    public static final String DESTRUCTOR = "destructor";
    
    public String getName();
    
}
