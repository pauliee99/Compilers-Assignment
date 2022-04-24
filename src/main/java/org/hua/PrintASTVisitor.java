/**
 * This code is part of the lab exercises for the Compilers course at Harokopio
 * University of Athens, Dept. of Informatics and Telematics.
 */
import org.apache.commons.lang3.StringEscapeUtils;
import org.hua.ast.ASTVisitor;
import org.hua.ast.ASTVisitorException;
import org.hua.ast.AssignmentStatement;
import org.hua.ast.BinaryExpression;
import org.hua.ast.CompUnit;
import org.hua.ast.CompoundStatement;
import org.hua.ast.PrintStatement;
import org.hua.ast.Statement;
import org.hua.ast.StringLiteralExpression;
import org.hua.ast.UnaryExpression;
import org.hua.ast.WhileStatement;
import org.hua.ast.BooleanLiteralExpression;
import org.hua.ast.BreakStatement;
import org.hua.ast.CharacterLiteralExpression;
import org.hua.ast.ContinueStatement;
import org.hua.ast.ExprEqExpr;
import org.hua.ast.FunctionDefinition;
import org.hua.ast.ParameterDeclaration;
import org.hua.ast.ReturnStatement;
import org.hua.ast.Specifiers;
import org.hua.ast.StructDefinition;
import org.hua.ast.VariableDefinition;
import org.hua.ast.VariableDefinitionStatement;
import org.hua.ast.IfElseStatement;
import org.hua.ast.IfStatement;
import org.hua.ast.Definitions;
import org.hua.ast.DoWhileStatement;
import org.hua.ast.DoubleLiteralExpression;
import org.hua.ast.IdentifierExpression;
import org.hua.ast.IntegerLiteralExpression;
import org.hua.ast.ParenthesisExpression;
import org.hua.ast.Expression;

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
    public void visit(VariableDefinitionStatement node) throws ASTVisitorException {
        // TODO Auto-generated method stub
        
    }
}
