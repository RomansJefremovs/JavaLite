

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
    public Object visitReadIntegerStatement(AST.ReadIntStatement o, Object arg) {
        return null;
    }

    @Override
    public Object visitReadInteger(AST.ReadInteger o, Object arg) {
        return null;
    }

    @Override
    public Object visitReadBooleanStatement(AST.ReadBooleanStatement o, Object arg) {
        return null;
    }

    @Override
    public Object visitReadBoolean(AST.ReadBoolean o, Object arg) {
        return null;
    }

    @Override
    public Object visitOperator(AST.Operator o, Object arg) {
        return null;
    }

    @Override
    public Object visitBooleanLiteral(AST.BooleanLiteral i, Object arg) {
        return null;
    }

    @Override
    public Object visitIntegerLiteral(AST.IntegerLiteral i, Object arg) {
        return null;
    }

    @Override
    public Object visitIdentifier(AST.Identifier i, Object arg) {
        return null;
    }

    @Override
    public Object visitExpList(AST.ExpList e, Object arg) {
        return null;
    }

    @Override
    public Object visitOperatorLitExpression(AST.OperatorLitExpression i, Object arg) {
        return null;
    }

    @Override
    public Object visitBooleanLitExpression(AST.BooleanLitExpression i, Object arg) {
        return null;
    }

    @Override
    public Object visitIdentifierExpression(AST.IdentifierExpression i, Object arg) {
        return null;
    }

    @Override
    public Object visitIntLitExpression(AST.IntLitExpression i, Object arg) {
        return null;
    }

    @Override
    public Object visitCallExpression(AST.CallExpression c, Object arg) {
        return null;
    }

    @Override
    public Object visitShowStatement(AST.ShowStatement s, Object arg) {
        return null;
    }

    @Override
    public Object visitWhileStatement(AST.WhileStatement w, Object arg) {
        return null;
    }

    @Override
    public Object visitIfStatement(AST.IfStatement i, Object arg) {
        return null;
    }

    @Override
    public Object visitIdentifierStatement(AST.IdentifierStatement s, Object arg) {
        return null;
    }

    @Override
    public Object visitStatements(AST.Statements s, Object arg) {
        return null;
    }

    @Override
    public Object visitIntDeclaration(AST.IntDeclaration f, Object arg) {
        return null;
    }

    @Override
    public Object visitFunctionDeclaration(AST.FunctionDeclaration f, Object arg) {
        return null;
    }

}
