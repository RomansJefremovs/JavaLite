package AST;

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
}
