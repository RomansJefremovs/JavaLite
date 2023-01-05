import AST.*;

import javax.swing.*;

public class testMain {
    public static void main( String args[] )
    {
        System.out.println(" ----------- ! Scanning test Program ! ------------------");
        testRunScanner();
        System.out.println(" ----------- ! Parsing test Program ! ------------------");
        testDriverParser();
        System.out.println(" ----------- ! Constructing AST tree from test Program ! ------------------");
        constructASTTree();
    }


    private static void testRunScanner() {
        final String EXAMPLES_DIR = "C:\\Users\\Sjunn\\OneDrive\\Skrivebord\\CMC";
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

    private static void constructASTTree() {
        final String EXAMPLES_DIR = "C:\\Users\\Sjunn\\OneDrive\\Skrivebord\\CMC";

        JFileChooser fc = new JFileChooser( EXAMPLES_DIR );

        if( fc.showOpenDialog( null ) == JFileChooser.APPROVE_OPTION ) {
            SourceFile in = new SourceFile( fc.getSelectedFile().getAbsolutePath() );
            Scanner s = new Scanner( in );
            ParserAST p = new ParserAST( s );

            AST ast = p.parseProgram();
            new ASTViewer( ast );
        }
    }

    private static void testDriverParser() {
        final String EXAMPLES_DIR = "C:\\Users\\Sjunn\\OneDrive\\Skrivebord\\CMC";

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

