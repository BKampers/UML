package bka.uml;


public interface Parameter extends bka.ocl.Typed {

    
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
