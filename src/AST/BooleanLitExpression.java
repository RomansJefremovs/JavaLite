package AST;

public class BooleanLitExpression extends Expression{
    public BooleanLiteral literal;


    public BooleanLitExpression(BooleanLiteral literal )
    {
        this.literal = literal;
    }
}
