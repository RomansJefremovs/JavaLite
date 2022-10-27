/*
 * 13.09.2016 Minor edit
 * 11.10.2010 dump() removed
 * 21.10.2009 New folder structure
 * 29.09.2006 Original version
 */
 
package AST;
import AST.Visitor;

public class Block
	extends AST
{
	public Declarations decs;
	public Statements stats;
	
	
	public Block(Declarations decs, Statements stats )
	{
		this.decs = decs;
		this.stats = stats;
	}
	public Object visit(Visitor v, Object arg )
	{
		return v.visitBlock( this, arg );
	}
}