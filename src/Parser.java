public class Parser {
    private final Scanner scan;
    private Token currentToken;


    public Parser( Scanner scan )
    {
        this.scan = scan;

        currentToken = scan.scan();
    }

    public void parseProgram()
    {
        parseBlock();
        accept(TokenKind.RETURN);
        accept(TokenKind.RIGHTCURLY);
        if( currentToken.kind != TokenKind.EOT )
            System.out.println( "Tokens found after end of program" );
    }

    private void parseBlock() {
        if(currentToken.kind == TokenKind.PROGRAM)
        {
            accept(TokenKind.PROGRAM);
            accept(TokenKind.LEFTCURLY);

            while(isADeclaration() || isAStatement())
            {
                if(isADeclaration())
                {
                    declareDeclarations();
                }
                if(isAStatement())
                {
                    declareStatements();
                }
            }
        }
        else if(currentToken.kind == TokenKind.LEFTCURLY)
        {
            accept(TokenKind.LEFTCURLY);
            while(isADeclaration() || isAStatement())
            {
                if(isADeclaration())
                {
                    declareDeclarations();
                }
                if(isAStatement())
                {
                    declareStatements();
                }
            }
        }

    }

    private void declareStatements() {
        while(isAStatement())
        {
            parseStatement();
        }
    }

    private void parseStatement() {
        switch (currentToken.kind) {
            case IF:
                accept(TokenKind.IF);
                accept(TokenKind.LEFTPARAN);
                if(currentToken.kind == TokenKind.OPERATOR)
                    System.out.println( "Cant start with a WordOperator" );
                parseExpressions();
                accept(TokenKind.RIGHTPARAN);
                accept(TokenKind.LEFTCURLY);
                parseBlock();
                accept(TokenKind.RIGHTCURLY);
                break;
            case WHILE:
                accept(TokenKind.WHILE);
                accept(TokenKind.LEFTPARAN);
                if(currentToken.kind == TokenKind.OPERATOR)
                    System.out.println( "Cant start with a WordOperator" );
                parseExpressions();
                accept(TokenKind.RIGHTPARAN);
                accept(TokenKind.LEFTCURLY);
                parseBlock();
                accept(TokenKind.RIGHTCURLY);
                break;
            case SHOW:
                accept(TokenKind.SHOW);
                accept(TokenKind.LEFTPARAN);
                if(currentToken.kind == TokenKind.OPERATOR)
                    System.out.println( "Cant start with a WordOperator" );
                parseExpressions();
                accept(TokenKind.RIGHTPARAN);
                break;
            case READBOOLEAN:
                accept(TokenKind.READBOOLEAN);
                accept(TokenKind.LEFTPARAN);
                accept(TokenKind.RIGHTPARAN);
                break;
            case READINT:
                accept(TokenKind.READINT);
                accept(TokenKind.LEFTPARAN);
                accept(TokenKind.RIGHTPARAN);
                break;
            case IDENTIFIER:
                //Only in case of calling a method
                accept(TokenKind.IDENTIFIER);
                if(currentToken.kind == TokenKind.LEFTPARAN)
                {
                    accept(TokenKind.LEFTPARAN);
                    if(currentToken.kind == TokenKind.IDENTIFIER)
                    {
                        accept(TokenKind.IDENTIFIER);
                        accept(TokenKind.RIGHTPARAN);
                    }
                    else if (currentToken.kind == TokenKind.INTEGERLITERAL)
                    {
                        accept(TokenKind.INTEGERLITERAL);
                        accept(TokenKind.RIGHTPARAN);
                    }
                    else if (currentToken.kind == TokenKind.TRUE)
                    {
                        accept(TokenKind.TRUE);
                        accept(TokenKind.RIGHTPARAN);
                    }
                    else if (currentToken.kind == TokenKind.FALSE)
                    {
                        accept(TokenKind.FALSE);
                        accept(TokenKind.RIGHTPARAN);
                    }
                }
                break;
            default:
                System.out.println( "statement expected (parseStatement)" + currentToken.spelling );
        }

    }

    private void parseExpressions() {
        while(isAExpression())
        {
            switch (currentToken.kind) {
                case IDENTIFIER:
                    accept(TokenKind.IDENTIFIER);
                    break;
                case INTEGERLITERAL:
                    accept(TokenKind.INTEGERLITERAL);
                    break;
                case TRUE:
                    accept(TokenKind.TRUE);
                    break;
                case FALSE:
                    accept(TokenKind.FALSE);
                    break;
                case OPERATOR:
                    accept(TokenKind.OPERATOR);
                    break;
                default:
                    System.out.println("expression expected (parseExpression)");
            }
        }
    }

    private void declareDeclarations() {
        while(isADeclaration())
        {
            parseOneDeclaration();
        }
    }

    private void parseOneDeclaration() {
        switch (currentToken.kind) {
            case INT:
                accept(TokenKind.INT);
                parseIdentifier();
                accept(TokenKind.IS);
                accept(TokenKind.INTEGERLITERAL);
                break;
            case BOOLEAN:
                accept(TokenKind.BOOLEAN);
                parseIdentifier();
                accept(TokenKind.IS);
                if (currentToken.kind == TokenKind.TRUE)
                    accept(TokenKind.TRUE);
                else if (currentToken.kind == TokenKind.FALSE)
                    accept(TokenKind.FALSE);
                else if(currentToken.kind == TokenKind.LEFTPARAN)
                {
                    accept(TokenKind.LEFTPARAN);
                    if(currentToken.kind == TokenKind.OPERATOR)
                        System.out.println( "Cant start with a WordOperator" );
                    parseExpressions();
                    accept(TokenKind.RIGHTPARAN);
                }
                break;
            case FUNC:
                accept(TokenKind.FUNC);
                accept(TokenKind.IDENTIFIER);
                accept(TokenKind.LEFTPARAN);
                if (currentToken.kind == TokenKind.INT || currentToken.kind == TokenKind.BOOLEAN)
                    parseIdList();
                accept(TokenKind.RIGHTPARAN);
                parseBlock();
                accept(TokenKind.RETURN);
                accept(TokenKind.RIGHTCURLY);
                break;
            default:
                System.out.println("bool or func or int expected");
        }
    }

    private void parseIdList() {
        if(currentToken.kind == TokenKind.BOOLEAN)
            accept(TokenKind.BOOLEAN);
        else if(currentToken.kind == TokenKind.INT)
            accept(TokenKind.INT);
        accept(TokenKind.IDENTIFIER);

        while( currentToken.kind == TokenKind.COMMA ) {
            accept( TokenKind.COMMA );
            if(currentToken.kind == TokenKind.BOOLEAN)
                accept(TokenKind.BOOLEAN);
            else if(currentToken.kind == TokenKind.INT)
                accept(TokenKind.INT);
            accept(TokenKind.IDENTIFIER);
        }
    }

    private void parseIdentifier() {
        accept(TokenKind.IDENTIFIER);
    }

    private void accept( TokenKind expected )
    {
        if( currentToken.kind == expected )
        {
            System.out.println(currentToken.kind);
            currentToken = scan.scan();
        }
        else
            System.out.println( "Expected token of kind " + expected );
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
