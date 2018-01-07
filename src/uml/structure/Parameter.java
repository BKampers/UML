package uml.structure;


public interface Parameter extends uml.structure.Typed {

    
    public enum Direction { 

        IN, OUT, INOUT;
        
        @Override 
        public String toString() {
            return '[' + super.toString() + ']';
        }

    }

        
    public Direction getDirection();
    public Expression getDefaultValue();

}
