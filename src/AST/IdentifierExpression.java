package AST;
import AST.Visitor;
public class IdentifierExpression extends Expression{
    public Identifier literal;
    public IdentifierExpression(Identifier literal )
    {
        this.literal = literal;
    }
    public Object visit(Visitor v, Object arg )
    {
        return v.visitIdentifierExpression(this, arg );
    }
}
