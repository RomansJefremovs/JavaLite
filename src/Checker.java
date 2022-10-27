

import AST.*;
import AST.Visitor;

import java.util.*;
public class Checker implements Visitor {
    private IdentificationTable idTable = new IdentificationTable();


    public void check( Program p )
    {
        p.visit( this, null );
    }


    public Object visitProgram( Program p, Object arg )
    {
        idTable.openScope();

        p.block.visit( this, null );

        idTable.closeScope();

        return null;
    }

    public Object visitBlock( Block b, Object arg )
    {
        b.decs.visit( this, null );
        b.stats.visit( this, null );

        return null;
    }

    @Override
    public Object visitDeclarations(Declarations d, Object arg) {
        return null;
    }

    @Override
    public Object visitBooleanDeclaration(BooleanDeclaration v, Object arg) {
        return null;
    }

    @Override
    public Object visitReadIntegerStatement(ReadIntStatement o, Object arg) {
        return null;
    }

    @Override
    public Object visitReadInteger(ReadInteger o, Object arg) {
        return null;
    }

    @Override
    public Object visitReadBooleanStatement( ReadBooleanStatement o, Object arg) {
        return null;
    }

    @Override
    public Object visitReadBoolean( ReadBoolean o, Object arg) {
        return null;
    }

    @Override
    public Object visitOperator( Operator o, Object arg) {
        return null;
    }

    @Override
    public Object visitBooleanLiteral( BooleanLiteral i, Object arg) {
        return null;
    }

    @Override
    public Object visitIntegerLiteral( IntegerLiteral i, Object arg) {
        return null;
    }

    @Override
    public Object visitIdentifier( Identifier i, Object arg) {
        return null;
    }

    @Override
    public Object visitExpList( ExpList e, Object arg) {
        return null;
    }

    @Override
    public Object visitOperatorLitExpression( OperatorLitExpression i, Object arg) {
        return null;
    }

    @Override
    public Object visitBooleanLitExpression( BooleanLitExpression i, Object arg) {
        return null;
    }

    @Override
    public Object visitIdentifierExpression( IdentifierExpression i, Object arg) {
        return null;
    }

    @Override
    public Object visitIntLitExpression( IntLitExpression i, Object arg) {
        return null;
    }

    @Override
    public Object visitCallExpression( CallExpression c, Object arg) {
        return null;
    }

    @Override
    public Object visitShowStatement( ShowStatement s, Object arg) {
        return null;
    }

    @Override
    public Object visitWhileStatement( WhileStatement w, Object arg) {
        return null;
    }

    @Override
    public Object visitIfStatement( IfStatement i, Object arg) {
        return null;
    }

    @Override
    public Object visitIdentifierStatement( IdentifierStatement s, Object arg) {
        return null;
    }

    @Override
    public Object visitStatements( Statements s, Object arg) {
        return null;
    }

    @Override
    public Object visitIntDeclaration( IntDeclaration f, Object arg) {
        return null;
    }

    @Override
    public Object visitFunctionDeclaration( FunctionDeclaration f, Object arg) {
        return null;
    }

}
