/**
 * This code is part of the lab exercises for the Compilers course at Harokopio
 * University of Athens, Dept. of Informatics and Telematics.
 */
package org.hua.ast;

/**
 * Abstract syntax tree visitor.
 */
public interface ASTVisitor {

    void visit(CompUnit node) throws ASTVisitorException;

    void visit(AssignmentStatement node) throws ASTVisitorException;

    void visit(PrintStatement node) throws ASTVisitorException;

    void visit(CompoundStatement node) throws ASTVisitorException;

    void visit(BinaryExpression node) throws ASTVisitorException;

    void visit(UnaryExpression node) throws ASTVisitorException;

    void visit(IdentifierExpression node) throws ASTVisitorException;

    void visit(DoubleLiteralExpression node) throws ASTVisitorException;

    void visit(IntegerLiteralExpression node) throws ASTVisitorException;

    void visit(StringLiteralExpression node) throws ASTVisitorException;

    void visit(ParenthesisExpression node) throws ASTVisitorException;

    void visit(WhileStatement node) throws ASTVisitorException;

    void visit(DoWhileStatement node) throws ASTVisitorException;

    void visit(IfElseStatement node) throws ASTVisitorException;

    void visit(IfStatement node) throws ASTVisitorException;

    void visit(VariableDefinition node) throws ASTVisitorException;

    void visit(FunctionDefinition node) throws ASTVisitorException;

    void visit(StructDefinition node) throws ASTVisitorException;

    void visit(Definitions node) throws ASTVisitorException;

    void visit(ReturnStatement node) throws ASTVisitorException;

    void visit(BooleanLiteralExpression node) throws ASTVisitorException;
    
    void visit(CharacterLiteralExpression node) throws ASTVisitorException;

    void visit(BreakStatement node) throws ASTVisitorException;

    void visit(ContinueStatement node) throws ASTVisitorException;

    void visit(ParameterDeclaration node) throws ASTVisitorException;

    void visit(Expression node) throws ASTVisitorException;

    void visit(ExprEqExpr node) throws ASTVisitorException;

    void visit(Specifiers node) throws ASTVisitorException;

    void visit(VariableDefinitionStatement node) throws ASTVisitorException;

}
