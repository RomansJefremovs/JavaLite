package AST;
import AST.Visitor;
public class ShowStatement extends Statement {
    public Expression expression;
    public ShowStatement(Expression expression) {
        this.expression = expression;
    }

    public Object visit(Visitor v, Object arg )
    {
        return v.visitShowStatement(this, arg );
    }
}
