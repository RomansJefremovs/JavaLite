package AST;

public class BooleanDeclaration extends Declaration{
    public Identifier value;
    public ExpList expList;

    public BooleanDeclaration(Identifier value, ExpList list)
    {
        this.value = value;
        expList = list;
    }
}
