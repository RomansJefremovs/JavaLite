import AST.AST;

import javax.swing.*;


public class TestDriverParser
{
    private static final String EXAMPLES_DIR = "C:\\Users\\roman\\Desktop\\School\\CMC\\TestProgram1.txt";


    public static void main( String args[] )
    {
        JFileChooser fc = new JFileChooser( EXAMPLES_DIR );

        if( fc.showOpenDialog( null ) == JFileChooser.APPROVE_OPTION ) {
            SourceFile in = new SourceFile( fc.getSelectedFile().getAbsolutePath() );
            Scanner s = new Scanner( in );
            ParserAST p = new ParserAST( s );

            AST ast = p.parseProgram();
            new ASTViewer( ast );
        }
    }
}