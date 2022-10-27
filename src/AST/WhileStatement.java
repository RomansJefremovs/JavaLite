package AST;
import AST.Visitor;
public class WhileStatement extends Statement {
    public ExpList expList;
    public Block block;
    public WhileStatement(ExpList expList, Block block) {
        this.expList = expList;
        this.block = block;
    }

    public Object visit(Visitor v, Object arg )
    {
        return v.visitWhileStatement(this, arg );
    }

}
