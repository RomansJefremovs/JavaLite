package AST;

public class IdentifierStatement extends Statement {
    public Identifier id;
    public ExpList list;
    public IdentifierStatement(Identifier id, ExpList list) {
        this.id = id;
        this.list = list;
    }
}
