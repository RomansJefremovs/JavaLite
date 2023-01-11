
package AST;


    public interface Visitor
    {
        public Object visitProgram( Program p, Object arg );

        public Object visitBlock( Block b, Object arg );

        public Object visitDeclarations( Declarations d, Object arg );

        public Object visitBooleanDeclaration( BooleanDeclaration v, Object arg );

        public Object visitFunctionDeclaration( FunctionDeclaration f, Object arg );

        public Object visitIntDeclaration( IntDeclaration f, Object arg );

        public Object visitStatements( Statements s, Object arg );

        public Object visitIdentifierStatement( IdentifierStatement s, Object arg );

        public Object visitIfStatement( IfStatement i, Object arg );

        public Object visitWhileStatement( WhileStatement w, Object arg );

        public Object visitShowStatement( ShowStatement s, Object arg );


        public Object visitCallExpression( CallExpression c, Object arg );

        public Object visitIntLitExpression( IntLitExpression i, Object arg );

        public Object visitIdentifierExpression( IdentifierExpression i, Object arg );

        public Object visitBooleanLitExpression( BooleanLitExpression i, Object arg );

        public Object visitOperatorLitExpression( OperatorLitExpression i, Object arg );

        public Object visitExpList( ExpList e, Object arg );

        public Object visitIdentifier( Identifier i, Object arg );

        public Object visitIntegerLiteral( IntegerLiteral i, Object arg );

        public Object visitBooleanLiteral( BooleanLiteral i, Object arg );

        public Object visitOperator( Operator o, Object arg );

        public Object visitReadBoolean( ReadBoolean o, Object arg );

        public Object visitReadBooleanStatement( ReadBooleanStatement o, Object arg );

        public Object visitReadInteger( ReadInteger o, Object arg );

        public Object visitReadIntegerStatement( ReadIntStatement o, Object arg );

        public Object visitBinaryExpression(BinaryExpression o, Object arg);
    }
