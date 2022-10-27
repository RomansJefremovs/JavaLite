package AST;
import AST.Visitor;
public class IfStatement extends Statement {
    public ExpList expList;
    public Block block;
    public IfStatement(ExpList expList, Block block) {
        this.expList = expList;
        this.block = block;
    }

    public Object visit(Visitor v, Object arg )
    {
        return v.visitIfStatement(this, arg );
    }
}
