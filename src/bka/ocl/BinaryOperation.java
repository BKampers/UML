/*
** Copyright © Bart Kampers
*/

package bka.ocl;

import uml.structure.Type;


public class BinaryOperation implements Typed {

    
    public BinaryOperation() {
    }
    
    
    public Operator getOperator() {
        return operator;
    }

    
    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    
    public Expression getLeftOperand() {
        return leftOperand;
    }

    
    public void setLeftOperand(Expression leftOperand) {
        this.leftOperand = leftOperand;
    }

    
    public Expression getRightOperand() {
        return rightOperand;
    }

    
    public void setRightOperand(Expression rightOperand) {
        this.rightOperand = rightOperand;
    }
    
    
    public String getName() {
        return operator.getName();
    }
    
    
    public Type getType() {
        return operator.getType();
    }
    
    
    public String toString() {
        assert operator != null;
        assert rightOperand != null;
        return ' ' + operator.getSymbol() + ' ' + rightOperand.name();
    }
    
    
    private Operator operator;
    private Expression leftOperand;
    private Expression rightOperand;
    
}
