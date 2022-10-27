package AST;
import AST.Visitor;
public class ReadBooleanStatement extends Statement{
    public ReadBoolean readBoolean;
    public ReadBooleanStatement(ReadBoolean readBoolean)
    {
        this.readBoolean = readBoolean;
    }

    public Object visit(Visitor v, Object arg )
    {
        return v.visitReadBooleanStatement(this, arg );
    }
}
