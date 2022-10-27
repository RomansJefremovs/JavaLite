package AST;
import AST.Visitor;
public class BooleanLiteral extends Terminal{
        public BooleanLiteral( String spelling )
        {
            this.spelling = spelling;
        }
        public Object visit(Visitor v, Object arg )
    {
        return v.visitBooleanLiteral(this, arg );
    }
}
