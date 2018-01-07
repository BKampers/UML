package uml.structure;


public interface Member extends Typed {

    
    public enum Visibility {

        PUBLIC('+'),
        PROTECTED('#'),
        PRIVATE('-');

        Visibility(char symbol) {
            this.symbol = symbol;
        }

        public char getSymbol()  {
            return symbol;
        }

        private final char symbol;
    }


    public Type getOwner();
    public Visibility getVisibility();
    public boolean isClassScoped();
    
}
