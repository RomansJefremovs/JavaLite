/*
 * 27.09.2016 Minor edit
 * 11.10.2010 dump() removed
 * 21.10.2009 New folder structure
 * 01.10.2006 Original version
 */
 
package AST;
import AST.Visitor;

public class IntLitExpression
	extends Expression
{
	public IntegerLiteral literal;
	
	
	public IntLitExpression(IntegerLiteral literal )
	{
		this.literal = literal;
	}


	public Object visit(Visitor v, Object arg )
	{
		return v.visitIntLitExpression(this, arg );
	}
}