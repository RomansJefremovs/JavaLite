import AST.Declaration;

public class IdEntry {
    public int level;
    public String id;
    public Declaration attr;


    public IdEntry( int level, String id, Declaration attr )
    {
        this.level = level;
        this.id = id;
        this.attr = attr;
    }


    public String toString()
    {
        return level + "," + id;
    }
}
