/**
 * This code is part of the lab exercises for the Compilers course at Harokopio
 * University of Athens, Dept. of Informatics and Telematics.
 */
import ast.ASTVisitor;
import ast.ASTVisitorException;
import ast.AssignmentStatement;
import ast.BinaryExpression;
import ast.CompUnit;
import ast.CompoundStatement;
import ast.DoWhileStatement;
import ast.DoubleLiteralExpression;
import ast.IdentifierExpression;
import ast.IfElseStatement;
import ast.IfStatement;
import ast.IntegerLiteralExpression;
import ast.ParenthesisExpression;
import ast.PrintStatement;
import ast.Statement;
import ast.StringLiteralExpression;
import ast.UnaryExpression;
import ast.WhileStatement;

import org.apache.commons.lang3.StringEscapeUtils;

public class PrintASTVisitor implements ASTVisitor {

    private int levels;

    @Override
    public void visit(CompUnit node) throws ASTVisitorException {
        for (Statement s : node.getStatements()) {
            s.accept(this);
        }
    }

    @Override
    public void visit(AssignmentStatement node) throws ASTVisitorException {
        System.out.print(node.getIdentifier());
        System.out.print(" = ");
        node.getExpression().accept(this);
        System.out.println(";");
    }

    @Override
    public void visit(PrintStatement node) throws ASTVisitorException {
        System.out.print("print( ");
        node.getExpression().accept(this);
        System.out.println(" );");
    }

    @Override
    public void visit(BinaryExpression node) throws ASTVisitorException {
        node.getExpression1().accept(this);
        System.out.print(" ");
        System.out.print(node.getOperator());
        System.out.print(" ");
        node.getExpression2().accept(this);
    }

    @Override
    public void visit(UnaryExpression node) throws ASTVisitorException {
        System.out.print(node.getOperator());
        System.out.print(" ");
        node.getExpression().accept(this);
    }

    @Override
    public void visit(IdentifierExpression node) throws ASTVisitorException {
        System.out.print(node.getIdentifier());
    }

    @Override
    public void visit(DoubleLiteralExpression node) throws ASTVisitorException {
        System.out.print(node.getLiteral());
    }

    @Override
    public void visit(IntegerLiteralExpression node) throws ASTVisitorException {
        System.out.print(node.getLiteral());
    }
    
    @Override
    public void visit(StringLiteralExpression node) throws ASTVisitorException {
        System.out.print("\"");
        System.out.print(StringEscapeUtils.escapeJava(node.getLiteral()));
        System.out.print("\"");
    }

    @Override
    public void visit(ParenthesisExpression node) throws ASTVisitorException {
        System.out.print("( ");
        node.getExpression().accept(this);
        System.out.print(" )");
    }

    @Override
    public void visit(CompoundStatement node) throws ASTVisitorException {
        levels++;
        System.out.println(" { ");
        for(Statement st: node.getStatements()) { 
            st.accept(this);
        }
        System.out.println(" } ");
        levels--;
    }

    @Override
    public void visit(WhileStatement node) throws ASTVisitorException {
        System.out.print("while ( ");
        node.getExpression().accept(this);
        System.out.println(" ) ");
        node.getStatement().accept(this);
    }

    @Override
    public void visit(DoWhileStatement node) throws ASTVisitorException {
        System.out.println("Do ");
        node.getStatement().accept(this);
        System.out.print("while ( ");
        node.getExpression().accept(this);
        System.out.println(" ); ");
    }

    @Override
    public void visit(IfElseStatement node) throws ASTVisitorException {
        System.out.print("if ( ");
        node.getExpression().accept(this);
        System.out.println(" ) ");
        node.getStatement1().accept(this);
        System.out.print("else ");
        node.getStatement2().accept(this);
    }

    @Override
    public void visit(IfStatement node) throws ASTVisitorException {
        System.out.print("if ( ");
        node.getExpression().accept(this);
        System.out.println(" ) ");
        node.getStatement().accept(this);
    }

}
