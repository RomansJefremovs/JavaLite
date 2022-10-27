package AST;
import  AST.Visitor;
public class Program
	extends AST
{
	public Block block;
	
	
	public Program( Block block )
	{
		this.block = block;
	}

	public Object visit(Visitor v, Object arg )
	{
		return v.visitProgram( this, arg );
	}
}