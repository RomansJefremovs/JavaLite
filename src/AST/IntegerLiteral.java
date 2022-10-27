package AST;
import AST.Visitor;
public class IntegerLiteral
        extends Terminal
{
    public IntegerLiteral( String spelling )
    {
        this.spelling = spelling;
    }
    public Object visit(Visitor v, Object arg )
    {
        return v.visitIntegerLiteral(this, arg );
    }
}