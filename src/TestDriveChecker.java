import AST.*;

import javax.swing.*;

public class TestDriveChecker
{
    private static final String EXAMPLES_DIR = "c:\\usr\\undervisning\\CMC\\IntLang\\examples";


    public static void main( String args[] )
    {
        JFileChooser fc = new JFileChooser( EXAMPLES_DIR );

        if( fc.showOpenDialog( null ) == fc.APPROVE_OPTION ) {
            SourceFile in = new SourceFile( fc.getSelectedFile().getAbsolutePath() );
            Scanner s = new Scanner( in );
            ParserOperatorPrecedence p = new ParserOperatorPrecedence( s );
            Checker c = new Checker();

            AST ast = (AST) p.parseProgram();
            c.check( (Program) ast );
        }
    }
}
