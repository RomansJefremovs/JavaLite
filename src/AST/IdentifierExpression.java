package AST;

public class IdentifierExpression extends Expression{
    public Identifier literal;


    public IdentifierExpression(Identifier literal )
    {
        this.literal = literal;
    }
}
