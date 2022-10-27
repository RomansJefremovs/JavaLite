package AST;
import AST.Visitor;

public abstract class AST
{
    public abstract Object visit(Visitor v, Object arg );
}