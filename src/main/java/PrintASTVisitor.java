/**
 * This code is part of the lab exercises for the Compilers course at Harokopio
 * University of Athens, Dept. of Informatics and Telematics.
 */
import ast.ASTVisitor;
import ast.ASTVisitorException;
import ast.AssignmentStatement;
import ast.BinaryExpression;
import ast.BooleanLiteralExpression;
import ast.BreakStatement;
import ast.CharacterLiteralExpression;
import ast.CompUnit;
import ast.CompoundStatement;
import ast.ContinueStatement;
import ast.Definitions;
import ast.DoWhileStatement;
import ast.DoubleLiteralExpression;
import ast.ExprEqExpr;
import ast.Expression;
import ast.FunctionDefinition;
import ast.IdentifierExpression;
import ast.IfElseStatement;
import ast.IfStatement;
import ast.IntegerLiteralExpression;
import ast.ParameterDeclaration;
import ast.ParenthesisExpression;
import ast.PrintStatement;
import ast.ReturnStatement;
import ast.Specifiers;
import ast.Statement;
import ast.StringLiteralExpression;
import ast.StructDefinition;
import ast.UnaryExpression;
import ast.VariableDefinition;
import ast.VariableDefinitionStatement;
import ast.WhileStatement;

import org.apache.commons.lang3.StringEscapeUtils;

public class PrintASTVisitor implements ASTVisitor {

    private int levels;

    @Override
    public void visit(CompUnit node) throws ASTVisitorException {
        for (Definitions d : node.getDefinitions()) {
            d.accept(this);
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

    @Override
    public void visit(VariableDefinition node) throws ASTVisitorException {
        node.getTypeSpecifier().accept(this);
        node.getIdentifier().accept(this);
    }

    @Override
    public void visit(FunctionDefinition functionDefinition) throws ASTVisitorException {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visit(StructDefinition structDefinition) throws ASTVisitorException {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visit(Definitions definitions) throws ASTVisitorException {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visit(ReturnStatement returnStatement) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visit(BooleanLiteralExpression booleanLiteralExpression) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visit(CharacterLiteralExpression characterLiteralExpression) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visit(BreakStatement breakStatement) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visit(ContinueStatement continueStatement) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visit(ParameterDeclaration parameterDeclaration) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visit(Expression expression) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visit(ExprEqExpr exprEqExpr) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visit(Specifiers specifiers) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visit(VariableDefinitionStatement variableDefinitionStatement) {
        // TODO Auto-generated method stub
        
    }
}
