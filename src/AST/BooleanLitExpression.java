package AST;
import AST.Visitor;
public class BooleanLitExpression extends Expression{
    public BooleanLiteral literal;
    public BooleanLitExpression(BooleanLiteral literal )
    {
        this.literal = literal;
    }
    public Object visit(Visitor v, Object arg )
    {
        return v.visitBooleanLitExpression(this, arg );
    }
}
