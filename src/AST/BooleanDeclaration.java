package AST;

public class BooleanDeclaration extends Declaration{
    Identifier value;
    ExpList expList;

    public BooleanDeclaration(Identifier value, ExpList list)
    {
        this.value = value;
        expList = list;
    }
}
