/*
** Copyright © Bart Kampers
*/

package bka.ocl;


import java.math.BigInteger;
import java.util.*;


public class BasicType implements bka.uml.Type {

    
    public static class Literal extends IntegerValue {
    
        public Literal() {
        }
    
        public Literal(String string, BasicType type) {
            this.string = string;
            this.type = type;
            setValue(string);
        }    
        
        public java.lang.Object getValue() {
            return string;
        }
        
        public final void setValue(java.lang.Object value) {
            string = value.toString();
            integer = new java.math.BigInteger(string);
            type = BasicType.INTEGER;
        }

        public String toString() {
            return string;
        }
        
        public bka.uml.Type getType() {
            return type;
        }
        
        public String getName() {
            return toString();
        }
        
        private String string;
        private BasicType type;
    }
    
    
    public static final BasicType INTEGER = new BasicType("Integer");

    
    public static final java.beans.PersistenceDelegate PERSISTENCE_DELEGATE = new java.beans.PersistenceDelegate() {
        
        protected java.beans.Expression instantiate(java.lang.Object oldInstance, java.beans.Encoder out) {
            return new java.beans.Expression(oldInstance, oldInstance.getClass(), "create", new java.lang.Object[] { oldInstance.toString() });
        }

    };

    
    public static BasicType create(String name) throws java.io.IOException {
        if (INTEGER.getName().equals(name)) {
            return INTEGER;
        }
        else {
            throw new java.io.IOException("Unknown Basic Type: " + name);
        }
    }

    
    public String getName() {
        return name;
    }
    
    
    public List<Operator> getOperators() {
        return operators;
    }
    
    
    public String toString() {
        return (name != null) ? name : super.toString();
    }
    
    
    public static Typed compute(Operator operator, Typed left, Typed right) {
        String symbol = operator.getSymbol();
        if (operator.getType() == INTEGER) {
            BigInteger leftInteger = ((NumberValue) left).asInteger();
            BigInteger rightInteger = ((NumberValue) right).asInteger();
            IntegerValue result = new IntegerValue();
            if ("*".equals(symbol)) {
                result.integer = leftInteger.multiply(rightInteger);
            }
            else if ("/".equals(symbol)) {
                result.integer = leftInteger.divide(rightInteger);
            }
            else if ("+".equals(symbol)) {
                result.integer = leftInteger.add(rightInteger);
            }
            else if ("-".equals(symbol)) {
                result.integer = leftInteger.subtract(rightInteger);
            }
            else {
                throw new IllegalArgumentException("Operations '" + symbol + "' not supported for INTEGER");
            }
            return result;
        }
        else {
            throw new IllegalArgumentException("No operators for '" + operator.getType() + "' not supported");
        }
    }
    
    
    protected Operator getOperator(String symbol) {
        for (Operator operator : operators) {
            if (operator.getSymbol().equals(symbol)) {
                return operator;
            }
        }
        throw new IllegalArgumentException("Unknown operator '" + symbol + "'");
    }


    private BasicType(String name) {
        this.name = name;
    }
    
    
    private interface NumberValue extends Typed {

        public java.math.BigInteger asInteger();
        
    }
    
    
    private static class IntegerValue implements NumberValue {

        public String getName() {
            return INTEGER.getName();
        }
        
        public bka.uml.Type getType() {
            return INTEGER;
        }
        
        public BigInteger asInteger() {
            return integer;
        }
        
        public String toString() {
            return integer.toString();
        }

        public boolean equals(Object other) {
            if (other == this) {
                return true;
            }
            else if (! (other instanceof IntegerValue)) {
                return false;
            }
            else if (integer != null) {
                return integer.equals(((IntegerValue) other).integer);
            }
            else {
                return ((IntegerValue) other).integer == null;
            }
        }
        
        protected java.math.BigInteger integer;
        
    }
    
    
    static {
        INTEGER.operators.add(new Operator("*", INTEGER));
        INTEGER.operators.add(new Operator("/", INTEGER));
        INTEGER.operators.add(new Operator("+", INTEGER));
        INTEGER.operators.add(new Operator("-", INTEGER));
    }
    
    
    private String name;
    private List<Operator> operators = new ArrayList<Operator>();
    
}


        
    
