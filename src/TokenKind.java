public enum TokenKind {
    IDENTIFIER,
    INTEGERLITERAL,
    OPERATOR,

    RIGHTCURLY("}"),
    LEFTCURLY("{"),
    PROGRAM("program"),

    IF("if"),
    ELSE("else"),
    COMMA(","),
    SEMICOLON(";"),
    LEFTPARAN("("),
    RIGHTPARAN(")"),
    FUNC("func"),
    TRUE("true"),
    FALSE("false"),
    PLUS("plus"),
    MINUS("minus"),
    MULTIPLY("multiply"),
    DIVIDE("divide"),
    MODULUS("modulo"),
    RETURN("return"),
    WHILE("while"),
    SHOW("show"),
    ENTERINTMESSAGE("enterIntMessage"),
    ENTERBOOLEANMESSAGE("enterBooleanMessage"),
    READINT("readInt"),
    READBOOLEAN("readBoolean"),
    INT("int"),
    BOOLEAN("boolean"),
    IS("is"),
    AND("and"),
    OR("or"),
    MAP("map"),
    NOT("not"),
    EQUALS("equals"),


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


