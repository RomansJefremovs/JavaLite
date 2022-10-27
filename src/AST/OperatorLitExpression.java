package AST;
import AST.Visitor;
public class OperatorLitExpression extends Expression{
    public Operator literal;
    public OperatorLitExpression(Operator literal )
    {
        this.literal = literal;
    }
    public Object visit(Visitor v, Object arg )
    {
        return v.visitOperatorLitExpression(this, arg );
    }
}
