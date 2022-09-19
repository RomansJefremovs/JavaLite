public class Scanner {

    private SourceFile source;
    private char currentChar;
    private StringBuffer currentSpelling = new StringBuffer();

    public Scanner( SourceFile source )
    {
        this.source = source;
        currentChar = source.getSource();
    }


    private void takeNextChar()
    {
        currentSpelling.append( currentChar );
        currentChar = source.getSource();
    }


    private boolean isLetter( char c )
    {
        return c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z';
    }


    private boolean isDigit( char c )
    {
        return c >= '0' && c <= '9';
    }


    public Token scan()
    {
        while( currentChar == '#' || currentChar == '\n' ||
                currentChar == '\r' || currentChar == '\t' ||
                currentChar == ' ' )
            scanSeparator();

        currentSpelling = new StringBuffer( "" );
        TokenKind kind = scanToken();

        return new Token( kind, new String( currentSpelling ) );
    }





    private void scanSeparator()
    {
        switch( currentChar ) {
            case '#':
                takeNextChar();
                while( currentChar != SourceFile.EOL && currentChar != SourceFile.EOT )
                    takeNextChar();

                if( currentChar == SourceFile.EOL )
                    takeNextChar();
                break;

            case ' ': case '\n': case '\r': case '\t':
                takeNextChar();
                break;
        }
    }

    private TokenKind scanToken()
    {
        if( isLetter( currentChar ) ) {
            takeNextChar();
            while( isLetter( currentChar ) || isDigit( currentChar ))
                takeNextChar();

            return TokenKind.IDENTIFIER;

        } else if( isDigit( currentChar ) ) {
            takeNextChar();
            while( isDigit( currentChar ) )
                takeNextChar();

            return TokenKind.INTEGERLITERAL;

        } switch( currentChar ) {

        case ',':
            takeNextChar();
            return TokenKind.COMMA;

        case ';':
            takeNextChar();
        return TokenKind.SEMICOLON;

        case '(':
            takeNextChar();
            return TokenKind.LEFTPARAN;

        case ')':
            takeNextChar();
            return TokenKind.RIGHTPARAN;

        case '{':
            takeNextChar();
            return TokenKind.LEFTCURLY;

        case '}':
            takeNextChar();
            return TokenKind.RIGHTCURLY;


        case SourceFile.EOT:
            return TokenKind.EOT;

        default:
            takeNextChar();
            return TokenKind.ERROR;
    }
    }

}

