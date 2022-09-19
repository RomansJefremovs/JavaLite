public class Token {

	public TokenKind kind;
	public String spelling;

	public Token(TokenKind kind, String spelling)
	{
		this.kind = kind;
		this.spelling = spelling;

		if( kind == TokenKind.IDENTIFIER )
			for( TokenKind tk: OPERATOR )
				if( spelling.equals( tk.getSpelling() ) ) {
					this.kind = TokenKind.OPERATOR;
					break;
				}

			for( TokenKind tk: KEYWORDS )
				if( spelling.equals( tk.getSpelling() ) ) {
					this.kind = tk;
					break;
				}
	}

	private static final TokenKind[] KEYWORDS = { TokenKind.IF, TokenKind.ELSE, TokenKind.FUNC, TokenKind.TRUE, TokenKind.FALSE, TokenKind.RETURN, TokenKind.MAP,
													 TokenKind.INT, TokenKind.BOOLEAN, TokenKind.ENTERBOOLEANMESSAGE, TokenKind.ENTERINTMESSAGE,
													TokenKind.READINT, TokenKind.READBOOLEAN, TokenKind.WHILE, TokenKind.SHOW, TokenKind.PROGRAM};

	private static final TokenKind[] OPERATOR = { TokenKind.PLUS, TokenKind.MINUS,
			TokenKind.MULTIPLY, TokenKind.DIVIDE, TokenKind.EQUALS, TokenKind.NOT, TokenKind.OR, TokenKind.AND, TokenKind.MODULUS, TokenKind.IS};


}
