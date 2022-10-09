package AST;

public class Program
	extends AST
{
	public Block block;
	
	
	public Program( Block block )
	{
		this.block = block;
	}
}