/**
 * This code is part of the lab exercises for the Compilers course at Harokopio
 * University of Athens, Dept. of Informatics and Telematics.
 */
package org.hua;

import org.hua.ast.ASTNode;
import org.hua.ast.ASTUtils;
import org.hua.ast.ASTVisitor;
import org.hua.ast.ASTVisitorException;
import org.hua.ast.AssignmentStatement;
import org.hua.ast.BinaryExpression;
import org.hua.ast.BreakStatement;
import org.hua.ast.CompUnit;
import org.hua.ast.CompoundStatement;
import org.hua.ast.ContinueStatement;
import org.hua.ast.DoWhileStatement;
import org.hua.ast.DoubleLiteralExpression;
import org.hua.ast.IdentifierExpression;
import org.hua.ast.IfElseStatement;
import org.hua.ast.IfStatement;
import org.hua.ast.IntegerLiteralExpression;
import org.hua.ast.ParenthesisExpression;
import org.hua.ast.PrintStatement;
import org.hua.ast.Statement;
import org.hua.ast.StringLiteralExpression;
import org.hua.ast.UnaryExpression;
import org.hua.ast.VarDeclarationStatement;
import org.hua.ast.WhileStatement;
import org.hua.symbol.Info;
import org.hua.symbol.SymbolTable;
import org.hua.types.TypeException;
import org.hua.types.TypeUtils;
import org.objectweb.asm.Type;

/**
 * Compute possible types for each node.
 */
public class CollectTypesASTVisitor implements ASTVisitor {

	public CollectTypesASTVisitor() {
	}

	@Override
	public void visit(CompUnit node) throws ASTVisitorException {
		for (Statement s : node.getStatements()) {
			s.accept(this);
		}
		ASTUtils.setType(node, Type.VOID_TYPE);
	}

	@Override
	public void visit(AssignmentStatement node) throws ASTVisitorException {
        // FIXME
		// 1. find symbol table
		// 2. lookup identifier in symbol table
		// 3. error if not found
		// 4. get expression type (recursive invocation of visitor)
		// 5. Error if types are not assignable 
		//    Use TypeUtils class with helper functions
		// 6. set type of statement
		// throw new UnsupportedOperationException("PLEASE FIXME");
		SymbolTable<Info> symtable = ASTUtils.getSafeSymbolTable(node);
		Info info = symtable.lookup(node.getIdentifier());
		if (info == null)
			ASTUtils.error(node, "error undefined identifier " + node.getIdentifier());

		node.getExpression().accept(this);
		Type srourceType = ASTUtils.getSafeType(node.getExpression());

		if (!TypeUtils.isAssignable(info.getType(), srourceType)){
			ASTUtils.error(node, "cannot assign " + info.getType() + "to " + srourceType);
		}
		ASTUtils.setType(node, info.getType());
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
		ASTUtils.setType(node, Type.VOID_TYPE);
	}

	@Override
	public void visit(BinaryExpression node) throws ASTVisitorException {
        // FIXME
		// 1. find type of expression1
		// 2. find type of expression2
		// 3. Use TypeUtils.applyBinary to figure type of result
		// 4. error if TypeException
		// 5. set type of result
		// throw new UnsupportedOperationException("PLEASE FIXME");
		node.getExpression1().accept(this);
		Type type1 = ASTUtils.getSafeType(node.getExpression1());

		node.getExpression2().accept(this);
		Type type2 = ASTUtils.getSafeType(node.getExpression2());

		try {
			ASTUtils.setType(node,
					TypeUtils.applyBinary(node.getOperator(), type1, type2));
		} catch (TypeException e) {
			ASTUtils.error(node, e.getMessage());
		}
	}

	@Override
	public void visit(UnaryExpression node) throws ASTVisitorException {
		node.getExpression().accept(this);
		try {
			ASTUtils.setType(node,
					TypeUtils.applyUnary(node.getOperator(), ASTUtils.getSafeType(node.getExpression())));
		} catch (TypeException e) {
			ASTUtils.error(node, e.getMessage());
		}
	}

	@Override
	public void visit(IdentifierExpression node) throws ASTVisitorException {
        // FIXME
		// 1. find symbol table
		// 2. lookup identifier in symbol table
		// 3. error if not found
		// 4. set type of expression from symbol table
		// throw new UnsupportedOperationException("PLEASE FIXME");
		SymbolTable<Info> symtable = ASTUtils.getSafeSymbolTable(node);
		Info lookup = symtable.lookup(node.getIdentifier());
		if (lookup == null)
			ASTUtils.error(node, "error undefined identifier " + node.getIdentifier());
	}

	@Override
	public void visit(IntegerLiteralExpression node) throws ASTVisitorException {
        // FIXME
		// 1. set type to integer
		// throw new UnsupportedOperationException("PLEASE FIXME");
		ASTUtils.setType(node, Type.INT_TYPE);
	}

	@Override
	public void visit(DoubleLiteralExpression node) throws ASTVisitorException {
		ASTUtils.setType(node, Type.DOUBLE_TYPE);
	}

	@Override
	public void visit(StringLiteralExpression node) throws ASTVisitorException {
        // FIXME
		// 1. set type to string
		// throw new UnsupportedOperationException("PLEASE FIXME");
		ASTUtils.setType(node, Type.DOUBLE_TYPE); //gia methodous kano ge method type kai ipologizo sosta tous typous
	}

	@Override
	public void visit(ParenthesisExpression node) throws ASTVisitorException {
		node.getExpression().accept(this);
		ASTUtils.setType(node, ASTUtils.getSafeType(node.getExpression()));
	}

	@Override
	public void visit(DoWhileStatement node) throws ASTVisitorException {
        // FIXME
		// recursively run visitor
		// make sure that type of expression is BOOLEAN_TYPE
        // set type of statement to void
		// throw new UnsupportedOperationException("PLEASE FIXME");
		node.getExpression().accept(this);
		if (!ASTUtils.getSafeType(node.getExpression()).equals(Type.BOOLEAN_TYPE)) {
			ASTUtils.error(node.getExpression(), "Invalid expression, should be boolean");
		}
		node.getStatement().accept(this);
		ASTUtils.setType(node, Type.VOID_TYPE);
	}

	@Override
	public void visit(WhileStatement node) throws ASTVisitorException {
		node.getExpression().accept(this);
		if (!ASTUtils.getSafeType(node.getExpression()).equals(Type.BOOLEAN_TYPE)) {
			ASTUtils.error(node.getExpression(), "Invalid expression, should be boolean");
		}
		node.getStatement().accept(this);
		ASTUtils.setType(node, Type.VOID_TYPE);
	}

	@Override
	public void visit(VarDeclarationStatement node) throws ASTVisitorException {
		ASTUtils.setType(node, Type.VOID_TYPE);
	}

	@Override
	public void visit(BreakStatement node) throws ASTVisitorException {
		ASTUtils.setType(node, Type.VOID_TYPE);
	}

	@Override
	public void visit(ContinueStatement node) throws ASTVisitorException {
		ASTUtils.setType(node, Type.VOID_TYPE);
	}

	@Override
	public void visit(IfElseStatement node) throws ASTVisitorException {
		node.getExpression().accept(this);
		if (!ASTUtils.getSafeType(node.getExpression()).equals(Type.BOOLEAN_TYPE)) {
			ASTUtils.error(node.getExpression(), "Invalid expression, should be boolean");
		}
		node.getStatement1().accept(this);
		node.getStatement2().accept(this);
		ASTUtils.setType(node, Type.VOID_TYPE);
	}

	@Override
	public void visit(IfStatement node) throws ASTVisitorException {
		node.getExpression().accept(this);
		if (!ASTUtils.getSafeType(node.getExpression()).equals(Type.BOOLEAN_TYPE)) {
			ASTUtils.error(node.getExpression(), "Invalid expression, should be boolean");
		}
		node.getStatement().accept(this);
		ASTUtils.setType(node, Type.VOID_TYPE);
	}

}
