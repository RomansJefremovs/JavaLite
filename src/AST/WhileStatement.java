package AST;

public class WhileStatement extends Statement {
    public ExpList expList;
    public Block block;
    public WhileStatement(ExpList expList, Block block) {
        this.expList = expList;
        this.block = block;
    }
}
