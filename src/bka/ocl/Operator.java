/*
** Copyright © Bart Kampers
*/

package bka.ocl;

import uml.structure.Type;


public class Operator implements Typed {

    
    public static final java.beans.PersistenceDelegate PERSISTENCE_DELEGATE = new java.beans.PersistenceDelegate() {
        
        protected java.beans.Expression instantiate(java.lang.Object oldInstance, java.beans.Encoder out) {
            Operator operator = (Operator) oldInstance;
            return new java.beans.Expression(oldInstance, oldInstance.getClass(), "create", new java.lang.Object[] { operator.getType().getName(), operator.getSymbol() });
        }

    };

    
    public static Operator create(String typeName, String symbol) {
        if (BasicType.INTEGER.getName().equals(typeName)) {
            return BasicType.INTEGER.getOperator(symbol);
        }
        else {
            throw new IllegalArgumentException("Type mismatch: '" + typeName + "' vs 'INTEGER'");
        }
    }
    
    
    public String getSymbol() {
        return symbol;
    }

    
    public String getName() {
        return symbol;
    }

    
    public Type getType() {
        return type;
    }

    
    protected Operator(String symbol, Type type) {
        this.symbol = symbol;
        this.type = type;
    }
    
    
    private String symbol;
    private Type type;
    
}
