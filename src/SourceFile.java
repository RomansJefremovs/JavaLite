import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class SourceFile {

    public static final char EOL = '\n';
    public static final char EOT = 0;


    private FileInputStream source;


    public SourceFile( String sourceFileName )
    {
        try {
            source = new FileInputStream( sourceFileName );
        } catch( FileNotFoundException ex ) {
            System.out.println( "*** FILE NOT FOUND *** (" + sourceFileName + ")" );
            System.exit( 1 );
        }
    }


    public char getSource()
    {
        try {
            int c = source.read();
            if( c < 0 )
                return EOT;
            else
                return (char) c;
        } catch( IOException ex ) {
            return EOT;
        }
    }
}
