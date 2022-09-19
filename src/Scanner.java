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


    public boolean CharacterIsLetter(char a) {
            return !Character.isDigit(a);
            //TODO: Factor in symbols?
    }

    public boolean CharacterIsDigit(char a) {
        return Character.isDigit(a);
        //TODO: Factor in symbols?
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
        if( CharacterIsLetter( currentChar ) ) {
            takeNextChar();
            while( CharacterIsLetter( currentChar ) || CharacterIsDigit( currentChar ) )
                takeNextChar();

            return TokenKind.IDENTIFIER;

        } else if( CharacterIsDigit( currentChar ) ) {
            takeNextChar();
            while( CharacterIsDigit( currentChar ) )
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

        case SourceFile.EOT:
            return TokenKind.EOT;

        default:
            takeNextChar();
            return TokenKind.ERROR;
    }
    }

}

