package AST;

public class ReadInteger extends AST{
    public IntegerLiteral literal;
    public ReadInteger( IntegerLiteral literal )
    {
        this.literal = literal;
    }
}
