package AST;

public class ReadBoolean extends AST{
    public BooleanLiteral booleanLiteral;
    public ReadBoolean( BooleanLiteral literal )
    {
        this.booleanLiteral = literal;
    }
}
