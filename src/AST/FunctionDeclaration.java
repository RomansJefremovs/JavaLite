/*
 * 27.09.2016 Minor edit
 * 11.10.2010 dump() removed
 * 21.10.2009 New folder structure
 * 23.10.2006 IdList replaced by Declarations for function parameters
 * 29.09.2006 Original version
 */
 
package AST;
import AST.Visitor;

public class FunctionDeclaration
	extends Declaration
{
	public Identifier name;
	public Declarations params;
	public Block block;

	
	public FunctionDeclaration(Identifier name, Declarations params,
                               Block block )
	{
		this.name = name;
		this.params = params;
		this.block = block;
	}


	public Object visit(Visitor v, Object arg )
	{
		return v.visitFunctionDeclaration( this, arg );
	}
}