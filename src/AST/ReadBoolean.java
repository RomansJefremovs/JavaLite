package AST;
import AST.Visitor;
public class ReadBoolean extends AST{
    public BooleanLiteral booleanLiteral;
    public ReadBoolean( BooleanLiteral literal )
    {
        this.booleanLiteral = literal;
    }
    public Object visit(Visitor v, Object arg )
    {
        return v.visitReadBoolean(this, arg );
    }
}
