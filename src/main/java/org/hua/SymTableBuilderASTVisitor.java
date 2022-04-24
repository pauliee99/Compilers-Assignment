/**
 * This code is part of the lab exercises for the Compilers course at Harokopio

 * University of Athens, Dept. of Informatics and Telematics.
 */
package org.hua;

import java.util.ArrayDeque;
import java.util.Deque;

import org.hua.ast.ASTUtils;
import org.hua.ast.ASTVisitor;
import org.hua.ast.ASTVisitorException;
import org.hua.ast.AssignmentStatement;
import org.hua.ast.BinaryExpression;
import org.hua.ast.CompUnit;
import org.hua.ast.CompoundStatement;
import org.hua.ast.DoWhileStatement;
import org.hua.ast.DoubleLiteralExpression;
import org.hua.ast.IdentifierExpression;
import org.hua.ast.IntegerLiteralExpression;
import org.hua.ast.ParenthesisExpression;
import org.hua.ast.PrintStatement;
import org.hua.ast.Statement;
import org.hua.ast.StringLiteralExpression;
import org.hua.ast.UnaryExpression;
import org.hua.ast.VarDeclarationStatement;
import org.hua.ast.WhileStatement;
import org.hua.symbol.HashSymbolTable;
import org.hua.symbol.Info;
import org.hua.symbol.SymbolTable;

/**
 * Build symbol tables for each node of the AST.
 */
public class SymTableBuilderASTVisitor implements ASTVisitor {

	private final Deque<SymbolTable<Info>> stack;

	public SymTableBuilderASTVisitor() {
		stack = new ArrayDeque<>();
	}

	@Override
	public void visit(CompUnit node) throws ASTVisitorException {
		startScope();
		ASTUtils.setSymbolTable(node, stack.element());
		for (Statement s : node.getStatements()) {
			s.accept(this);
		}
		endScope();
	}

	@Override
	public void visit(AssignmentStatement node) throws ASTVisitorException {
		ASTUtils.setSymbolTable(node, stack.element());
		node.getExpression().accept(this);
	}

	@Override
	public void visit(PrintStatement node) throws ASTVisitorException {
		ASTUtils.setSymbolTable(node, stack.element());
		node.getExpression().accept(this);
	}

	@Override
	public void visit(BinaryExpression node) throws ASTVisitorException {
		ASTUtils.setSymbolTable(node, stack.element());
		node.getExpression1().accept(this);
		node.getExpression2().accept(this);
	}

	@Override
	public void visit(UnaryExpression node) throws ASTVisitorException {
		ASTUtils.setSymbolTable(node, stack.element());
		node.getExpression().accept(this);
	}

	@Override
	public void visit(VarDeclarationStatement node) throws ASTVisitorException {
		ASTUtils.setSymbolTable(node, stack.element());
	}

	@Override
	public void visit(IdentifierExpression node) throws ASTVisitorException {
		ASTUtils.setSymbolTable(node, stack.element());
	}

	@Override
	public void visit(DoubleLiteralExpression node) throws ASTVisitorException {
		ASTUtils.setSymbolTable(node, stack.element());
	}

	@Override
	public void visit(IntegerLiteralExpression node) throws ASTVisitorException {
		ASTUtils.setSymbolTable(node, stack.element());
	}

	@Override
	public void visit(StringLiteralExpression node) throws ASTVisitorException {
		ASTUtils.setSymbolTable(node, stack.element());
	}

	@Override
	public void visit(ParenthesisExpression node) throws ASTVisitorException {
		ASTUtils.setSymbolTable(node, stack.element());
		node.getExpression().accept(this);
	}

	@Override
	public void visit(WhileStatement node) throws ASTVisitorException {
		ASTUtils.setSymbolTable(node, stack.element());
		node.getExpression().accept(this);
		node.getStatement().accept(this);
	}

	@Override
	public void visit(DoWhileStatement node) throws ASTVisitorException {
		ASTUtils.setSymbolTable(node, stack.element());
		node.getExpression().accept(this);
		node.getStatement().accept(this);
	}

	@Override
	public void visit(CompoundStatement node) throws ASTVisitorException {
		startScope();
		ASTUtils.setSymbolTable(node, stack.element());
		for (Statement s : node.getStatements()) {
			s.accept(this);
		}
		endScope();
	}

	private void startScope() {
		SymbolTable<Info> oldSymTable = stack.peek();
		SymbolTable<Info> symTable = new HashSymbolTable<>(oldSymTable);
		stack.push(symTable);
	}

	private void endScope() {
		stack.pop();
	}

}
