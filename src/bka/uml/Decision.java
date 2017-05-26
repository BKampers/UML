/*
** Copyright © Bart Kampers
*/

package bka.uml;

import bka.ocl.*;


public class Decision<A> extends State<A> implements Named, Typed {


    @Override
    public Type getType() {
        return type;
    }


    public void setType(Type type) {
        this.type = type;
    }


    private Type type;
    
}
