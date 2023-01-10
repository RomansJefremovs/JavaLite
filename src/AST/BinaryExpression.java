/*
 * 27.09.2016 Minor edit
 * 11.10.2010 dump() removed
 * 29.10.2009 New package structure
 * 22.10.2006 visit()
 * 01.10.2006 Original version
 */

package AST;

import AST.*;
import AST.Visitor;



public class BinaryExpression
	extends Expression
{
	public Operator operator;
	public Expression operand1;
	public Expression operand2;



	public BinaryExpression(Operator operator, Expression operand1, Expression operand2 )
	{
		this.operator = operator;
		this.operand1 = operand1;
		this.operand2 = operand2;
	}

	public Object visit(Visitor v, Object arg) {
		return v.visitBinaryExpression(this, arg );
	}
}