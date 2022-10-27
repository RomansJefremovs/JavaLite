package AST;
import AST.Visitor;
public class IdentifierStatement extends Statement {
    public Identifier id;
    public ExpList list;
    public IdentifierStatement(Identifier id, ExpList list) {
        this.id = id;
        this.list = list;
    }

    public Object visit(Visitor v, Object arg )
    {
        return v.visitIdentifierStatement(this, arg );
    }

}
