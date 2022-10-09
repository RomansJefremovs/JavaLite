/*
 * 27.09.2016 Minor edit
 * 08.10.2010 Original Version
 */


import AST.AST;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import java.awt.*;
import AST.*;

public class ASTViewer
	extends JFrame
{
	private static final Font NODE_FONT = new Font( "Verdana", Font.PLAIN, 24 );
	
	
	public ASTViewer(AST ast )
	{
		super( "Abstract Syntax Tree" );
		
		DefaultMutableTreeNode root = createTree( ast );
		JTree tree = new JTree( root );
		DefaultTreeCellRenderer renderer = new DefaultTreeCellRenderer();
		renderer.setFont( NODE_FONT );
		tree.setCellRenderer( renderer );
		
		add( new JScrollPane( tree ) );
		
		setSize( 1024, 768 );
		setVisible( true );
		
		setDefaultCloseOperation( EXIT_ON_CLOSE );
	}
	
	
	private DefaultMutableTreeNode createTree( AST ast )
	{
		DefaultMutableTreeNode node = new DefaultMutableTreeNode( "*** WHAT??? ***" );
		
		if( ast == null )
			node.setUserObject( "*** NULL ***" );
		else if( ast instanceof Program) {
			node.setUserObject( "Program" );
			node.add( createTree( ((Program)ast).block ) );
		} else if( ast instanceof Block ) {
			node.setUserObject( "Block" );
			node.add( createTree( ((Block)ast).decs ) );
			node.add( createTree( ((Block)ast).stats ) );
		} else if( ast instanceof Declarations ) {
			node.setUserObject( "Declarations" );

			for( Declaration d: ((Declarations)ast).dec )
				node.add( createTree( d ) );
		}  else if( ast instanceof FunctionDeclaration ) {
			node.setUserObject( "FunctionDeclaration" );
			node.add( createTree( ((FunctionDeclaration)ast).name ) );
			node.add( createTree( ((FunctionDeclaration)ast).params ) );
			node.add( createTree( ((FunctionDeclaration)ast).block ) );
		} else if( ast instanceof Statements ) {
			node.setUserObject( "Statements" );

			for( Statement s: ((Statements)ast).stat )
				node.add( createTree( s ) );
		}  else if( ast instanceof IfStatement ) {
			node.setUserObject( "IfStatement" );
			node.add( createTree( ((IfStatement)ast).expList ) );
			node.add( createTree( ((IfStatement)ast).block ) );
		} else if( ast instanceof WhileStatement ) {
			node.setUserObject( "WhileStatement" );
			node.add( createTree( ((WhileStatement)ast).expList ) );
			node.add( createTree( ((WhileStatement)ast).block ) );
		}  else if( ast instanceof ExpList ) {
			node.setUserObject( "ExpList" );
			for( Expression e: ((ExpList)ast).exp )
				node.add( createTree( e ) );
		} else if( ast instanceof Identifier ) {
			node.setUserObject( "Identifier " + ((Identifier)ast).spelling );
			} else if( ast instanceof IntegerLiteral ) {
			node.setUserObject( "IntegerLiteral " + ((IntegerLiteral)ast).spelling );
		} else if( ast instanceof Operator ) {
			node.setUserObject( "Operator " + ((Operator)ast).spelling );
		} else if ( ast instanceof BooleanLiteral ) {
			node.setUserObject( "BooleanLiteral " + ((Operator)ast).spelling );
		} else if(ast instanceof BooleanDeclaration) {
			node.setUserObject( "BooleanDeclaration" );
			node.add( createTree( ((BooleanDeclaration)ast).value ) );
			node.add( createTree( ((BooleanDeclaration)ast).expList ) );
		} else if(ast instanceof BooleanLitExpression) {
			node.setUserObject( "BooleanLitExpression" );
			node.add( createTree( ((BooleanLitExpression)ast).literal ) );
		} else if(ast instanceof CallExpression) {
			node.setUserObject( "CallExpression" );
			node.add( createTree( ((CallExpression)ast).name ) );
			node.add( createTree( ((CallExpression)ast).args ) );
		} else if(ast instanceof IdentifierExpression) {
			node.setUserObject( "IdentifierExpression" );
			node.add( createTree( ((IdentifierExpression)ast).literal ) );
		} else if(ast instanceof IdentifierStatement) {
			node.setUserObject( "IdentifierStatement" );
			node.add( createTree( ((IdentifierStatement)ast).id ) );
			node.add( createTree( ((IdentifierStatement)ast).list ) );
		} else if(ast instanceof IntDeclaration) {
			node.setUserObject( "IntDeclaration" );
			node.add( createTree( ((IntDeclaration)ast).name ) );
			node.add( createTree( ((IntDeclaration)ast).value ) );
		} else if(ast instanceof IntLitExpression) {
			node.setUserObject( "IntLitExpression" );
			node.add( createTree( ((IntLitExpression)ast).literal ) );
		} else if(ast instanceof OperatorLitExpression) {
			node.setUserObject( "OperatorLitExpression" );
			node.add( createTree( ((OperatorLitExpression)ast).literal ) );
		} else if(ast instanceof ReadBoolean) {
			node.setUserObject( "ReadBoolean" );
			node.add( createTree( ((ReadBoolean)ast).booleanLiteral ) );
		} else if(ast instanceof ReadBooleanStatement) {
			node.setUserObject( "ReadBooleanStatement" );
			node.add( createTree( ((ReadBooleanStatement)ast).readBoolean ) );
		} else if(ast instanceof ReadInteger) {
			node.setUserObject( "ReadInteger" );
			node.add( createTree( ((ReadInteger)ast).literal ) );
		} else if(ast instanceof ReadIntStatement) {
			node.setUserObject( "ReadIntStatement" );
			node.add( createTree( ((ReadIntStatement)ast).readInteger ) );
		} else if(ast instanceof ShowStatement) {
			node.setUserObject( "ShowStatement" );
			node.add( createTree( ((ShowStatement)ast).expression ) );
		}


		return node;
	}
}