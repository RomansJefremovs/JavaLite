package AST;
import AST.Visitor;
public class BooleanDeclaration extends Declaration{
    public Identifier value;
    public ExpList expList;

    public BooleanDeclaration(Identifier value, ExpList list)
    {
        this.value = value;
        expList = list;
    }
    public Object visit(Visitor v, Object arg )
    {
        return v.visitBooleanDeclaration( this, arg );
    }
}
