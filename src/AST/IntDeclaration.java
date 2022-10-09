package AST;

public class IntDeclaration  extends Declaration {

    public Identifier name;
    public int value;


    public IntDeclaration( Identifier name, int value )
    {
        this.name = name;
        this.value = value;
    }

    public IntDeclaration(Identifier name) {
        super();
    }
}
