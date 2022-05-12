/**
 * This code is part of the lab exercises for the Compilers course at Harokopio
 * University of Athens, Dept. of Informatics and Telematics.
 */
package org.hua;

import org.hua.ast.ASTUtils;
import org.hua.ast.ASTVisitor;
import org.hua.ast.ASTVisitorException;
import org.hua.ast.AssignmentStatement;
import org.hua.ast.BinaryExpression;
import org.hua.ast.BooleanLiteralExpression;
import org.hua.ast.BreakStatement;
import org.hua.ast.CharacterLiteralExpression;
import org.hua.ast.CompUnit;
import org.hua.ast.CompoundStatement;
import org.hua.ast.ContinueStatement;
import org.hua.ast.Definitions;
import org.hua.ast.DoWhileStatement;
import org.hua.ast.DoubleLiteralExpression;
import org.hua.ast.ExprEqExpr;
import org.hua.ast.Expression;
import org.hua.ast.FunctionDefinition;
import org.hua.ast.IdentifierExpression;
import org.hua.ast.IfElseStatement;
import org.hua.ast.IfStatement;
import org.hua.ast.IntegerLiteralExpression;
import org.hua.ast.ParameterDeclaration;
import org.hua.ast.ParenthesisExpression;
import org.hua.ast.PrintStatement;
import org.hua.ast.ReturnStatement;
import org.hua.ast.Specifiers;
import org.hua.ast.Statement;
import org.hua.ast.StringLiteralExpression;
import org.hua.ast.StructDefinition;
import org.hua.ast.UnaryExpression;
import org.hua.ast.VarDeclarationStatement;
import org.hua.ast.VariableDefinition;
import org.hua.ast.VariableDefinitionStatement;
import org.hua.ast.WhileStatement;
import org.hua.symbol.Info;
import org.hua.symbol.SymbolTable;
import org.objectweb.asm.Type;

import java_cup.runtime.Symbol;

/**
 * Collect all symbols such as variables, methods, etc in symbol table.
 */
public class CollectSymbolsASTVisitor implements ASTVisitor {

	public CollectSymbolsASTVisitor() {
	}

	@Override
	public void visit(CompUnit node) throws ASTVisitorException {
		for (Definitions d : node.getDefinitions()) {
			d.accept(this);
		}
	}

	@Override
	public void visit(AssignmentStatement node) throws ASTVisitorException {
		node.getExpression().accept(this);
	}

	@Override
	public void visit(PrintStatement node) throws ASTVisitorException {
		node.getExpression().accept(this);
		ASTUtils.setType(node, Type.VOID_TYPE);
	}

	@Override
	public void visit(CompoundStatement node) throws ASTVisitorException {
		for (Statement st : node.getStatements()) {
			st.accept(this);
		}
	}

	@Override
	public void visit(BinaryExpression node) throws ASTVisitorException {
		node.getExpression1().accept(this);
		node.getExpression2().accept(this);
	}

	@Override
	public void visit(UnaryExpression node) throws ASTVisitorException {
		node.getExpression().accept(this);
	}

	@Override
	public void visit(IdentifierExpression node) throws ASTVisitorException {
		// nothing
	}

	@Override
	public void visit(IntegerLiteralExpression node) throws ASTVisitorException {
		// nothing
	}

	@Override
	public void visit(DoubleLiteralExpression node) throws ASTVisitorException {
		// nothing
	}

	@Override
	public void visit(StringLiteralExpression node) throws ASTVisitorException {
		// nothing
	}

	@Override
	public void visit(ParenthesisExpression node) throws ASTVisitorException {
		node.getExpression().accept(this);
	}

	@Override
	public void visit(DoWhileStatement node) throws ASTVisitorException {
		node.getExpression().accept(this);
		node.getStatement().accept(this);
	}

	@Override
	public void visit(WhileStatement node) throws ASTVisitorException {
		node.getExpression().accept(this);
		node.getStatement().accept(this);
	}

	@Override
	public void visit(VarDeclarationStatement node) throws ASTVisitorException {
        // FIXME
        // 1. find symbol table
        // 2. lookup identifier only in top scope
        // to make sure it is not redefined
        // 3. register identifier with type in symbol table
        // use org.objectweb.asm.Type for the type
        // throw new UnsupportedOperationException("PLEASE FIXME");
		SymbolTable<Info> symtable = ASTUtils.getSafeSymbolTable(node);
		if (symtable.innerScopeLookup(node.getIdentifier()) != null) 
			ASTUtils.error(node, "redeclaired variable " + node.getIdentifier());

		symtable.put(node.getIdentifier(), new Info(node.getIdentifier(), Type.VOID_TYPE)); 
	}

	@Override
	public void visit(BreakStatement node) throws ASTVisitorException {
		// nothing
	}

	@Override
	public void visit(ContinueStatement node) throws ASTVisitorException {
		// nothing
	}

	@Override
	public void visit(IfElseStatement node) throws ASTVisitorException {
		node.getExpression().accept(this);
		node.getStatement1().accept(this);
		node.getStatement2().accept(this);
	}

	@Override
	public void visit(IfStatement node) throws ASTVisitorException {
		node.getExpression().accept(this);
		node.getStatement().accept(this);
	}

	@Override
	public void visit(VariableDefinition node) throws ASTVisitorException {
		node.getTypeSpecifier().accept(this);
		node.getIdentifier().accept(this);
		node.getIntegerLiteral().accept(this);
		
	}

	@Override
	public void visit(FunctionDefinition node) throws ASTVisitorException {
		node.getTypeSpecifier().accept(this);
		node.getIdentifier().accept(this);
		
	}

	@Override
	public void visit(StructDefinition node) throws ASTVisitorException {
		node.getIdentifier().accept(this);
		
	}

	@Override
	public void visit(Definitions node) throws ASTVisitorException {
		node.getStructDefinition().accept(this);
		node.getVariableDefinition().accept(this);
		node.getFunctionDefinition().accept(this);
		
	}

	@Override
	public void visit(ReturnStatement node) throws ASTVisitorException {
		node.getExpression().accept(this);
		
	}

	@Override
	public void visit(BooleanLiteralExpression node) throws ASTVisitorException {
		// nothing		
	}

	@Override
	public void visit(CharacterLiteralExpression node) throws ASTVisitorException {
		// nothing
		
	}

	@Override
	public void visit(ParameterDeclaration node) throws ASTVisitorException {
		node.getTypeSpecifier().accept(this);
		node.getIdentifier().accept(this);
		
	}

	@Override
	public void visit(Expression node) throws ASTVisitorException {
		// nothing
		
	}

	@Override
	public void visit(ExprEqExpr node) throws ASTVisitorException {
		node.getExpression1().accept(this);
		node.getExpression2().accept(this);
		
	}

	@Override
	public void visit(Specifiers node) throws ASTVisitorException {
		node.getIdentifier().accept(this);
		
	}

	@Override
	public void visit(VariableDefinitionStatement node) throws ASTVisitorException {
		node.getVariableDefinition().accept(this);
		
	}

}
