import javax.swing.*;


public class TestDriverParser
{
    private static final String EXAMPLES_DIR = "C:\\Users\\Sjunn\\OneDrive\\Skrivebord\\CMC\\1stTestProgram.txt";


    public static void main( String args[] )
    {
        JFileChooser fc = new JFileChooser( EXAMPLES_DIR );

        if( fc.showOpenDialog( null ) == JFileChooser.APPROVE_OPTION ) {
            SourceFile in = new SourceFile( fc.getSelectedFile().getAbsolutePath() );
            Scanner s = new Scanner( in );
            Parser p = new Parser( s );

            p.parseProgram();
        }
    }
}