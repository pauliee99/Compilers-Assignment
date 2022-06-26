package org.hua.ast;

import java.util.ArrayList;
import java.util.List;
import org.objectweb.asm.Type;

import org.hua.symbol.SymbolTable;
import org.hua.symbol.Info;
import org.hua.threeaddr.GotoInstr;

/**
 * Class with static helper methods for AST handling
 */
public class ASTUtils {

	public static final String SYMTABLE_PROPERTY = "SYMTABLE_PROPERTY";
	public static final String IS_BOOLEAN_EXPR_PROPERTY = "IS_BOOLEAN_EXPR_PROPERTY";
	public static final String TYPE_PROPERTY = "TYPE_PROPERTY";
	public static final String NEXT_LIST_PROPERTY = "NEXT_LIST_PROPERTY";
	public static final String BREAK_LIST_PROPERTY = "BREAK_LIST_PROPERTY";
	public static final String CONTINUE_LIST_PROPERTY = "CONTINUE_LIST_PROPERTY";
	public static final String TRUE_LIST_PROPERTY = "TRUE_LIST_PROPERTY";
	public static final String FALSE_LIST_PROPERTY = "FALSE_LIST_PROPERTY";

	private ASTUtils() {
	}

	@SuppressWarnings("unchecked")
	public static SymbolTable<Info> getSymbolTable(ASTNode node) {
		return (SymbolTable<Info>) node.getProperty(SYMTABLE_PROPERTY);
	}

	@SuppressWarnings("unchecked")
	public static SymbolTable<Info> getSafeSymbolTable(ASTNode node) throws ASTVisitorException {
		SymbolTable<Info> symTable = (SymbolTable<Info>) node.getProperty(SYMTABLE_PROPERTY);
		if (symTable == null) {
			ASTUtils.error(node, "Symbol table not found.");
		}
		return symTable;
	}

	public static void setSymbolTable(ASTNode node, SymbolTable<Info> symbolTable) {
		node.setProperty(SYMTABLE_PROPERTY, symbolTable);
	}

	public static boolean isBooleanExpression(Expression node) {
		Boolean b = (Boolean) node.getProperty(IS_BOOLEAN_EXPR_PROPERTY);
		if (b == null) {
			return false;
		}
		return b;
	}

	public static void setBooleanExpression(Expression node, boolean value) {
		node.setProperty(IS_BOOLEAN_EXPR_PROPERTY, value);
	}

	public static Type getType(ASTNode node) {
		return (Type) node.getProperty(TYPE_PROPERTY);
	}

	public static Type getSafeType(ASTNode node) throws ASTVisitorException {
		Type type = (Type) node.getProperty(TYPE_PROPERTY);
		if (type == null) {
			ASTUtils.error(node, "Type not found.");
		}
		return type;
	}

	public static void setType(ASTNode node, Type type) {
		node.setProperty(TYPE_PROPERTY, type);
	}

	@SuppressWarnings("unchecked")
	public static List<GotoInstr> getTrueList(Expression node) {
		List<GotoInstr> l = (List<GotoInstr>) node.getProperty(TRUE_LIST_PROPERTY);
		if (l == null) {
			l = new ArrayList<GotoInstr>();
			node.setProperty(TRUE_LIST_PROPERTY, l);
		}
		return l;
	}

	public static void setTrueList(Expression node, List<GotoInstr> list) {
		node.setProperty(TRUE_LIST_PROPERTY, list);
	}

	@SuppressWarnings("unchecked")
	public static List<GotoInstr> getFalseList(Expression node) {
		List<GotoInstr> l = (List<GotoInstr>) node.getProperty(FALSE_LIST_PROPERTY);
		if (l == null) {
			l = new ArrayList<GotoInstr>();
			node.setProperty(FALSE_LIST_PROPERTY, l);
		}
		return l;
	}

	public static void setFalseList(Expression node, List<GotoInstr> list) {
		node.setProperty(FALSE_LIST_PROPERTY, list);
	}

	@SuppressWarnings("unchecked")
	public static List<GotoInstr> getNextList(Definitions ps) {
		List<GotoInstr> l = (List<GotoInstr>) ps.getProperty(NEXT_LIST_PROPERTY);
		if (l == null) {
			l = new ArrayList<GotoInstr>();
			ps.setProperty(NEXT_LIST_PROPERTY, l);
		}
		return l;
	}
	@SuppressWarnings("unchecked")
	public static List<GotoInstr> getNextList(Statement ps) {
		List<GotoInstr> l = (List<GotoInstr>) ps.getProperty(NEXT_LIST_PROPERTY);
		if (l == null) {
			l = new ArrayList<GotoInstr>();
			ps.setProperty(NEXT_LIST_PROPERTY, l);
		}
		return l;
	}
	@SuppressWarnings("unchecked")
	public static List<GotoInstr> getNextList(Expression ps) {
		List<GotoInstr> l = (List<GotoInstr>) ps.getProperty(NEXT_LIST_PROPERTY);
		if (l == null) {
			l = new ArrayList<GotoInstr>();
			ps.setProperty(NEXT_LIST_PROPERTY, l);
		}
		return l;
	}

	public static void setNextList(Statement node, List<GotoInstr> list) {
		node.setProperty(NEXT_LIST_PROPERTY, list);
	}

	@SuppressWarnings("unchecked")
	public static List<GotoInstr> getBreakList(Definitions s) {
		List<GotoInstr> l = (List<GotoInstr>) s.getProperty(BREAK_LIST_PROPERTY);
		if (l == null) {
			l = new ArrayList<GotoInstr>();
			s.setProperty(BREAK_LIST_PROPERTY, l);
		}
		return l;
	}
	@SuppressWarnings("unchecked")
	public static List<GotoInstr> getBreakList(Statement s) {
		List<GotoInstr> l = (List<GotoInstr>) s.getProperty(BREAK_LIST_PROPERTY);
		if (l == null) {
			l = new ArrayList<GotoInstr>();
			s.setProperty(BREAK_LIST_PROPERTY, l);
		}
		return l;
	}

	public static void setBreakList(Statement node, List<GotoInstr> list) {
		node.setProperty(BREAK_LIST_PROPERTY, list);
	}

	@SuppressWarnings("unchecked")
	public static List<GotoInstr> getContinueList(Definitions s) {
		List<GotoInstr> l = (List<GotoInstr>) s.getProperty(CONTINUE_LIST_PROPERTY);
		if (l == null) {
			l = new ArrayList<GotoInstr>();
			s.setProperty(CONTINUE_LIST_PROPERTY, l);
		}
		return l;
	}
	@SuppressWarnings("unchecked")
	public static List<GotoInstr> getContinueList(Statement s) {
		List<GotoInstr> l = (List<GotoInstr>) s.getProperty(CONTINUE_LIST_PROPERTY);
		if (l == null) {
			l = new ArrayList<GotoInstr>();
			s.setProperty(CONTINUE_LIST_PROPERTY, l);
		}
		return l;
	}

	public static void setContinueList(Statement node, List<GotoInstr> list) {
		node.setProperty(CONTINUE_LIST_PROPERTY, list);
	}

	public static void error(ASTNode node, String message) throws ASTVisitorException {
		throw new ASTVisitorException(node.getLine() + ":" + node.getColumn() + ": " + message);
	}

}