package AST;

public class IfStatement extends Statement {
    public ExpList expList;
    public Block block;
    public IfStatement(ExpList expList, Block block) {
        this.expList = expList;
        this.block = block;
    }
}
