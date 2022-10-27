package AST;
import AST.Visitor;
public class ReadInteger extends AST{
    public IntegerLiteral literal;
    public ReadInteger( IntegerLiteral literal )
    {
        this.literal = literal;
    }
    public Object visit(Visitor v, Object arg )
    {
        return v.visitReadInteger(this, arg );
    }
}
