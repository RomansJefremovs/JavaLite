/*
 * 27.09.2016 Minor edit
 * 11.10.2010 dump() removed
 * 21.10.2009 New folder structure
 * 01.10.2006 Original version
 */
 
package AST;
import AST.Visitor;

public class Operator
	extends Terminal
{
	public Operator(String spelling )
	{
		this.spelling = spelling;
	}

	public Object visit(Visitor v, Object arg )
	{
		return v.visitOperator(this, arg );
	}
}