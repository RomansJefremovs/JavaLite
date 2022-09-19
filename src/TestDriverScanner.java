/*
 * 23.08.2019 TokenKind enum introduced
 * 13.08.2018 Example path change
 * 16.08.2016 IScanner gone, minor editing
 * 21.09.2012 Examples Directory Changed
 * 20.09.2010 IScanner
 * 25.09.2009 New package structure
 * 21.09.2007 File Chooser
 * 22.09.2006 Original version
 */

import javax.swing.*;


public class TestDriverScanner
{
    private static final String EXAMPLES_DIR = "c:\\usr\\undervisning\\CMC\\IntLang\\examples";


    public static void main( String args[] )
    {
        JFileChooser fc = new JFileChooser( EXAMPLES_DIR );

        if( fc.showOpenDialog( null ) == JFileChooser.APPROVE_OPTION ) {
            SourceFile in = new SourceFile( fc.getSelectedFile().getAbsolutePath() );
            Scanner s = new Scanner( in );

            Token t = s.scan();
            while( t.kind != TokenKind.EOT ) {
                System.out.println( t.kind + " " + t.spelling );

                t = s.scan();
            }
        }
    }
}