

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
        for (Declaration decl: d.dec)
            decl.visit(this,null);
        return null;
    }

    @Override
    public Object visitIntDeclaration( IntDeclaration f, Object arg) {
        String id = (String) f.name.visit( this, null );

        idTable.enter( id, f );
        return null;
    }

    @Override
    public Object visitBooleanDeclaration(BooleanDeclaration v, Object arg) {
        String id = (String) v.value.visit( this, null );

        idTable.enter( id, v );
        return null;
    }
    @Override
    public Object visitFunctionDeclaration( FunctionDeclaration f, Object arg) {
        String id = (String) f.name.visit( this, null );
        idTable.enter( id, f );
        idTable.openScope();

        f.params.visit( this, null );
        f.block.visit( this, null );

        idTable.closeScope();
        return null;
    }

    @Override
    public Object visitStatements( Statements s, Object arg) {
        for( Statement stat: s.stat )
            stat.visit( this, null );

        return null;
    }
    @Override
    public Object visitIfStatement( IfStatement i, Object arg) {
        i.expList.visit( this, null );
        i.block.visit( this, null );
        return null;
    }
    public Object visitExpList( ExpList e, Object arg )
    {
        Vector<Type> types = new Vector<Type>();

        for( Expression exp: e.exp )
            types.add( (Type) exp.visit( this, null ) );

        return types;
    }
    public Object visitBinaryExpression( BinaryExpression b, Object arg )
    {
        Type t1 = (Type) b.operand1.visit( this, null );
        Type t2 = (Type) b.operand2.visit( this, null );
        String operator = (String) b.operator.visit( this, null );

        if( operator == null ){
            System.out.println( "no such operator" );
            return new Type(Type.ERROR);
        } else if (operator.equals("is")) {
            System.out.println("Left-hand side of is must be a variable");
            return new Type(Type.ERROR);
        } else if ( !t1.equals(t2)) {
            System.out.println("Left subexpression is of wrong type");
            return new Type(Type.ERROR);
        }else if ( !t2.equals(t1)) {
            System.out.println("right subexpression is of wrong type");
            return new Type(Type.ERROR);
        }
        return t1;
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
    public Object visitIdentifierStatement( IdentifierStatement s, Object arg) {
        return null;
    }





}
