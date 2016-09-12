/*
** Copyright © Bart Kampers
*/

package bka.uml;

import bka.ocl.Typed;


public interface Member extends Typed {

    public static final char UNDEFINED_VISIBILITY = ' ';
    public static final char PRIVATE              = '-';
    public static final char PROTECTED            = '#';
    public static final char PUBLIC               = '+';
    
    public String getName();
    public Type getOwner();
    public char getVisibility();
    public boolean isClassScoped();
    
}
