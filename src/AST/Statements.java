package AST;

import java.util.Vector;
import AST.Visitor;
public class Statements
        extends AST
{
    public Vector<Statement> stat = new Vector<Statement>();
    public Object visit(Visitor v, Object arg )
    {
        return v.visitStatements( this, arg );
    }
}