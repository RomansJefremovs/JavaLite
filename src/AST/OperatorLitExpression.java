package AST;

public class OperatorLitExpression extends Expression{
    public Operator literal;


    public OperatorLitExpression(Operator literal )
    {
        this.literal = literal;
    }
}
