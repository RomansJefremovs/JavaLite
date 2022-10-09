/*
 * 27.09.2016 Minor edit
 * 11.10.2010 dump() removed
 * 21.10.2009 New folder structure
 * 01.01.2006 Original version
 */
 
package AST;


import java.util.Vector;


public class ExpList
	extends AST
{
	public Vector<Expression> exp = new Vector<Expression>();
}