import AST.*;
import AST.Visitor;
import TAM.*;

import java.io.DataOutputStream;
import java.io.FileOutputStream;


public class Encoder implements Visitor {
    private int nextAdr = Instruction.CB;
    private int currentLevel = 0;
    private void emit( int op, int n, int r, int d){
        // append an instruction
        Instruction instr = new Instruction();
        instr.op = op;
        instr.n = n;
        instr.r = r;
        instr.d = d;
        if( nextAdr >= Instruction.PB )
            System.out.println( "Program too large" );
        else {
            Instruction.code[nextAdr++] = instr;
        }
    }
    private void patch( int adr, int d )
    {
        Instruction.code[adr].d = d;
    }

    private int displayRegister( int currentLevel, int entityLevel )
    {
        if( entityLevel == 0 )
            return Instruction.SBr;
        else if( currentLevel - entityLevel <= 6 )
            return Instruction.LBr + currentLevel - entityLevel;
        else {
            System.out.println( "Accessing across to many levels" );
            return Instruction.L6r;
        }
    }


    public void saveTargetProgram( String fileName )
    {
        try {
            DataOutputStream out = new DataOutputStream( new FileOutputStream( fileName ) );

            for( int i = Instruction.CB; i < nextAdr; ++i )
                Instruction.code[i].write( out );
            out.close();
        } catch( Exception ex ) {
            ex.printStackTrace();
            System.out.println( "Trouble writing " + fileName );
        }
    }

    public void encode( Program p )
    {
        p.visit( this, null );
    }

    @Override
    public Object visitProgram(Program p, Object arg) {
        currentLevel = 0;
        p.block.visit(this,new Address());
        emit( Instruction.HALTop, 0, 0, 0 );
        return null;
    }

    @Override
    public Object visitBlock(Block b, Object arg) {
        int before = nextAdr;
        emit( Instruction.JUMPop, 0, Instruction.CB, 0 );

        int size = ((Integer) b.decs.visit( this, arg )).intValue();

        patch( before, nextAdr );

        if( size > 0 )
            emit( Instruction.PUSHop, 0, 0, size );

        b.stats.visit( this, null );

        return size;
    }


    @Override
    public Object visitDeclarations(Declarations d, Object arg) {
        int startDisplacement = ((Address) arg).displacement;

        for( Declaration dec : d.dec )
            arg = dec.visit( this, arg );

        Address adr = (Address) arg;
        int size = adr.displacement - startDisplacement;

        return size;
    }
    @Override
    public Object visitIntDeclaration(IntDeclaration f, Object arg) {
        f.adr = (Address) arg;

        return new Address( (Address) arg, 1 );
    }

    @Override
    public Object visitFunctionDeclaration(FunctionDeclaration f, Object arg) {
        f.address = new Address( currentLevel, nextAdr );

        ++currentLevel;

        Address adr = new Address( (Address) arg );

        int size = ((Integer) f.params.visit( this, adr ) ).intValue();
        f.params.visit( this, new Address( adr, -size ) );

        f.block.visit( this, new Address( adr, Instruction.linkDataSize ) );

        emit( Instruction.RETURNop, 1, 0, size );

        currentLevel--;

        return arg;
    }
    @Override
    public Object visitBooleanDeclaration(BooleanDeclaration v, Object arg) {
        return null;
    }

    @Override
    public Object visitBinaryExpression(BinaryExpression o, Object arg) {
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
    public Object visitReadBooleanStatement(ReadBooleanStatement o, Object arg) {
        return null;
    }

    @Override
    public Object visitReadBoolean(ReadBoolean o, Object arg) {
        return null;
    }

    @Override
    public Object visitOperator(Operator o, Object arg) {
        return null;
    }

    @Override
    public Object visitBooleanLiteral(BooleanLiteral i, Object arg) {
        return null;
    }

    @Override
    public Object visitIntegerLiteral(IntegerLiteral i, Object arg) {
        return null;
    }

    @Override
    public Object visitIdentifier(Identifier i, Object arg) {
        return null;
    }

    @Override
    public Object visitExpList(ExpList e, Object arg) {
        return null;
    }

    @Override
    public Object visitOperatorLitExpression(OperatorLitExpression i, Object arg) {
        return null;
    }

    @Override
    public Object visitBooleanLitExpression(BooleanLitExpression i, Object arg) {
        return null;
    }

    @Override
    public Object visitIdentifierExpression(IdentifierExpression i, Object arg) {
        return null;
    }

    @Override
    public Object visitIntLitExpression(IntLitExpression i, Object arg) {
        return null;
    }

    @Override
    public Object visitCallExpression(CallExpression c, Object arg) {
        return null;
    }

    @Override
    public Object visitShowStatement(ShowStatement s, Object arg) {
        return null;
    }

    @Override
    public Object visitWhileStatement(WhileStatement w, Object arg) {
        return null;
    }

    @Override
    public Object visitIfStatement(IfStatement i, Object arg) {
        return null;
    }

    @Override
    public Object visitIdentifierStatement(IdentifierStatement s, Object arg) {
        return null;
    }

    @Override
    public Object visitStatements(Statements s, Object arg) {
        return null;
    }


}
