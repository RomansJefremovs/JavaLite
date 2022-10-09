package AST;

public class ShowStatement extends Statement {
    public Expression expression;
    public ShowStatement(Expression expression) {
        this.expression = expression;
    }
}
