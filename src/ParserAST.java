import AST.*;

import java.util.Objects;

public class ParserAST {
    private final Scanner scan;
    private Token currentToken;


    public ParserAST(Scanner scan )
    {
        this.scan = scan;

        currentToken = scan.scan();
    }

    public Program parseProgram()
    {
        Block block = parseBlock();
        accept(TokenKind.RETURN);
        accept(TokenKind.RIGHTCURLY);
        if( currentToken.kind != TokenKind.EOT )
            System.out.println( "Tokens found after end of program" );

        return new Program(block);
    }

    private Block parseBlock() {

        if(currentToken.kind == TokenKind.PROGRAM)
            accept(TokenKind.PROGRAM);

        accept(TokenKind.LEFTCURLY);
        Declarations decs = new Declarations();
        Statements statements = new Statements();
            while(isADeclaration() || isAStatement())
            {
                if(isADeclaration())
                {
                    decs.dec.addAll(Objects.requireNonNull(declareDeclarations()).dec);
                }
                if(isAStatement())
                {
                    statements.stat.addAll(Objects.requireNonNull(declareStatements()).stat);
                }
            }
        return new Block(decs, statements);
    }

    private Statements declareStatements() {
        Statements statements = new Statements();
        while(isAStatement())
        {
            Statement stat = parseStatement();
            statements.stat.add(stat);
        }
        return statements;
    }

    private Statement parseStatement() {
        switch (currentToken.kind) {
            case IF:
                accept(TokenKind.IF);
                accept(TokenKind.LEFTPARAN);
                if(currentToken.kind == TokenKind.OPERATOR)
                    System.out.println( "Cant start with a WordOperator" + currentToken.spelling );
                ExpList expList = parseExpressions();
                accept(TokenKind.RIGHTPARAN);
                accept(TokenKind.LEFTCURLY);
                Block block = parseBlock();
                accept(TokenKind.RIGHTCURLY);
                return new IfStatement(expList, block);
            case WHILE:
                accept(TokenKind.WHILE);
                accept(TokenKind.LEFTPARAN);
                if(currentToken.kind == TokenKind.OPERATOR)
                    System.out.println( "Cant start with a WordOperator" + currentToken.spelling);
                ExpList expList1 = parseExpressions();
                accept(TokenKind.RIGHTPARAN);
                accept(TokenKind.LEFTCURLY);
                Block block1 = parseBlock();
                accept(TokenKind.RIGHTCURLY);
                return new WhileStatement(expList1, block1);
            case SHOW:
                accept(TokenKind.SHOW);
                accept(TokenKind.LEFTPARAN);
                if(currentToken.kind == TokenKind.OPERATOR)
                    System.out.println( "Cant start with a WordOperator" + currentToken.spelling );
                Expression expression = parseExpression();
                accept(TokenKind.RIGHTPARAN);
                return new ShowStatement(expression);
            case READBOOLEAN:
                ReadBooleanStatement statement = new ReadBooleanStatement(new ReadBoolean(new BooleanLiteral(currentToken.spelling)));
                accept(TokenKind.READBOOLEAN);
                accept(TokenKind.LEFTPARAN);
                accept(TokenKind.RIGHTPARAN);
                return statement;
            case READINT:
                ReadIntStatement statement2 = new ReadIntStatement(new ReadInteger(new IntegerLiteral(currentToken.spelling)));
                accept(TokenKind.READINT);
                accept(TokenKind.LEFTPARAN);
                accept(TokenKind.RIGHTPARAN);
                return statement2;
            case IDENTIFIER:
                //Only in case of calling a method
                Identifier id = new Identifier(currentToken.spelling);
                accept(TokenKind.IDENTIFIER);
                accept(TokenKind.LEFTPARAN);
                ExpList list = parseExpressions();
                accept(TokenKind.RIGHTPARAN);
                return new IdentifierStatement(id, list);
            default:
                System.out.println( "statement expected (parseStatement)" + currentToken.spelling );
                return null; //TODO: THROW ERROR
        }
    }

    private ExpList parseExpressions() {
        ExpList expList = new ExpList();
        while(isAExpression())
        {
            expList.exp.add(parseExpression());
        }
        return expList;
    }

    private Expression parseExpression() {
        String booleanValue;
        switch (currentToken.kind) {
            case IDENTIFIER:
                IdentifierExpression id = new IdentifierExpression(new Identifier(currentToken.spelling));
                accept(TokenKind.IDENTIFIER);
                return id;
            case INTEGERLITERAL:
                String integerValue = currentToken.spelling;
                accept(TokenKind.INTEGERLITERAL);
                return new IntLitExpression(new IntegerLiteral(integerValue));
            case TRUE:
                booleanValue = currentToken.spelling;
                accept(TokenKind.TRUE);
                return new BooleanLitExpression(new BooleanLiteral(booleanValue));
            case FALSE:
                booleanValue = currentToken.spelling;
                accept(TokenKind.FALSE);
                return new BooleanLitExpression(new BooleanLiteral(booleanValue));
            case OPERATOR:
                String operatorSpelling = currentToken.spelling;
                accept(TokenKind.OPERATOR);
                return new OperatorLitExpression(new Operator(operatorSpelling));
            default:
                System.out.println("expression expected (parseExpression)" + currentToken.spelling);
                return null; //TODO: THROW ERROR
        }
    }

    private Declarations declareDeclarations() {
        Declarations decs = new Declarations();
        while(isADeclaration())
        {
            decs.dec.add(parseOneDeclaration());
        }
        return decs;
    }

    private Declaration parseOneDeclaration() {
        switch (currentToken.kind) {
            case INT:
                accept(TokenKind.INT);
                Identifier id = parseIdentifier();
                accept(TokenKind.IS);
                String value = currentToken.spelling;
                accept(TokenKind.INTEGERLITERAL);
                return new IntDeclaration(id, new IntegerLiteral(value));
            case BOOLEAN:
                ExpList expList = null;
                accept(TokenKind.BOOLEAN);
                Identifier idBool = parseIdentifier();
                accept(TokenKind.IS);
                if (currentToken.kind == TokenKind.TRUE)
                    accept(TokenKind.TRUE);
                else if (currentToken.kind == TokenKind.FALSE)
                    accept(TokenKind.FALSE);
                else if(currentToken.kind == TokenKind.LEFTPARAN)
                {
                    accept(TokenKind.LEFTPARAN);
                    if(currentToken.kind == TokenKind.OPERATOR)
                        System.out.println( "Cant start with a WordOperator" + currentToken.spelling);
                    expList = parseExpressions();
                    accept(TokenKind.RIGHTPARAN);
                }
                return new BooleanDeclaration(idBool, expList);
            case FUNC:
                Declarations declarations = null;
                accept(TokenKind.FUNC);
                Identifier name = new Identifier(currentToken.spelling);
                accept(TokenKind.IDENTIFIER);
                accept(TokenKind.LEFTPARAN);
                if (currentToken.kind == TokenKind.INT || currentToken.kind == TokenKind.BOOLEAN)
                    declarations = parseIdList();
                accept(TokenKind.RIGHTPARAN);
                Block blockFunc = parseBlock();
                accept(TokenKind.RETURN);
                accept(TokenKind.RIGHTCURLY);
                return new FunctionDeclaration(name, declarations, blockFunc);
            default:
                System.out.println("bool or func or int expected" + currentToken.spelling);
                return null; //TODO: THROW ERROR
        }
    }

    private Declarations parseIdList() {
        //todo extract method
        Declarations decList = new Declarations();
        if(currentToken.kind == TokenKind.BOOLEAN)
        {
            accept(TokenKind.BOOLEAN);
            decList.dec.add(new BooleanDeclaration(new Identifier(currentToken.spelling), null));
        }
        else if(currentToken.kind == TokenKind.INT)
        {
            accept(TokenKind.INT);
            decList.dec.add(new IntDeclaration(new Identifier(currentToken.spelling)));
        }
        accept(TokenKind.IDENTIFIER);

        while( currentToken.kind == TokenKind.COMMA ) {
            accept( TokenKind.COMMA );
            if(currentToken.kind == TokenKind.BOOLEAN)
            {
                accept(TokenKind.BOOLEAN);
                decList.dec.add(new BooleanDeclaration(new Identifier(currentToken.spelling), null));
            }
            else if(currentToken.kind == TokenKind.INT)
            {
                accept(TokenKind.INT);
                decList.dec.add(new IntDeclaration(new Identifier(currentToken.spelling)));
            }
            accept(TokenKind.IDENTIFIER);
        }
        return decList;
    }

    private Identifier parseIdentifier() {
        Identifier id = new Identifier(currentToken.spelling);
        accept(TokenKind.IDENTIFIER);
        return id;
    }

    private void accept( TokenKind expected )
    {
        if( currentToken.kind == expected )
        {
            System.out.println(currentToken.kind);
            currentToken = scan.scan();
        }
        else
            System.out.println( "Expected token of kind " + expected + "current: " + currentToken.spelling );
    }


    private boolean isADeclaration() {
        return currentToken.kind == TokenKind.INT || currentToken.kind == TokenKind.BOOLEAN ||
                currentToken.kind == TokenKind.FUNC;
    }

    private boolean isAStatement() {
        return isAExpression() || currentToken.kind == TokenKind.IF || currentToken.kind == TokenKind.WHILE ||
                currentToken.kind == TokenKind.SHOW || currentToken.kind == TokenKind.READINT ||
                    currentToken.kind == TokenKind.READBOOLEAN;
    }

    private boolean isAExpression()
    {
        return currentToken.kind == TokenKind.IDENTIFIER || currentToken.kind == TokenKind.INTEGERLITERAL  ||
                 currentToken.kind == TokenKind.TRUE || currentToken.kind == TokenKind.FALSE  || currentToken.kind == TokenKind.OPERATOR;
    }
}
