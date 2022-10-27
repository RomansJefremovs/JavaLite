package AST;
import AST.Visitor;
public class ReadIntStatement extends Statement {
    public ReadInteger readInteger;
    public ReadIntStatement(ReadInteger readInteger)
    {
        this.readInteger = readInteger;
    }
    public Object visit(Visitor v, Object arg )
    {
        return v.visitReadIntegerStatement(this, arg );
    }
}
