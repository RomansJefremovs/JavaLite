public enum TokenKind {
    IDENTIFIER,
    INTEGERLITERAL,
    OPERATOR,
    IF,
    ELSE,
    COMMA,
    SEMICOLON,
    LEFTPARAN,
    RIGHTPARAN,
    FUNC,
    TRUE,
    FALSE,
    PLUS,
    MINUS,
    MULTIPLY,
    DIVIDE,
    MODULUS,
    RETURN,
    WHILE,
    SHOW,
    ENTERINTMESSAGE,
    ENTERBOOLEANMESSAGE,
    READINT,
    READBOOLEAN,
    INT,
    BOOLEAN,
    IS,
    AND,
    OR,
    MAP,
    NOT,
    EQUALS,
    EOT,
    ERROR;

    private String spelling = null;


    private TokenKind()
    {
    }


    private TokenKind( String spelling )
    {
        this.spelling = spelling;
    }


    public String getSpelling()
    {
        return spelling;
    }
}


