public class Type {
    private byte kind;
    public static final byte
    BOOL = 0, INT = 1, ERROR = - 1;
    public Type(byte kind){
        this.kind = kind;
    }
    public boolean equals (Object other) {
        Type otherType = (Type) other;
        return (this.kind == otherType.kind || this.kind == ERROR || otherType.kind == ERROR);
    }
    public static Type bool = new Type(BOOL);
    public static Type integer = new Type(INT);
    public static Type error = new Type(ERROR);
}
