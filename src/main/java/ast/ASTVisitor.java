/**
 * This code is part of the lab exercises for the Compilers course at Harokopio
 * University of Athens, Dept. of Informatics and Telematics.
 */
package ast;

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

    void visit(VariableDefinition variableDefinition) throws ASTVisitorException;

    void visit(FunctionDefinition functionDefinition) throws ASTVisitorException;

    void visit(StructDefinition structDefinition) throws ASTVisitorException;

    void visit(Definitions definitions) throws ASTVisitorException;

    void visit(TypeSpecifier typeSpecifier) throws ASTVisitorException;

    void visit(ReturnStatement returnStatement);

    void visit(BooleanLiteralExpression booleanLiteralExpression);

    void visit(CharacterLiteralExpression characterLiteralExpression);

    void visit(BreakStatement breakStatement);

    void visit(ContinueStatement continueStatement);

    void visit(ParameterDeclaration parameterDeclaration);

    void visit(Identifier identifier);

    void visit(SpecifierExpression specifierExpression);

}
