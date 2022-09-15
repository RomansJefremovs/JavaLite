public class Scanner {

    private SourceFile source;
    private char currentChar;
    private StringBuffer currentSpelling = new StringBuffer();

    public Scanner( SourceFile source )
    {
        this.source = source;
        currentChar = source.getSource();
    }

    public boolean CharacterIsLetter(char a) {
            return !Character.isDigit(a);
    }

    public boolean CharacterIsDigit(char a) {
        return Character.isDigit(a);
    }



}

