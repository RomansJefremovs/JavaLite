package AST;
import AST.Visitor;
public class IntDeclaration  extends Declaration {

    public Identifier name;
    public IntegerLiteral value;


    public IntDeclaration( Identifier name, IntegerLiteral value )
    {
        this.name = name;
        this.value = value;
    }

    public IntDeclaration(Identifier name) {

        this.name = name;
    }

    public Object visit(Visitor v, Object arg )
    {
        return v.visitIntDeclaration(this, arg );
    }
}
