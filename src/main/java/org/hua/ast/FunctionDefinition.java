package org.hua.ast;

import java.util.List;

public class FunctionDefinition extends ASTNode {

    private Specifiers typeSpecifier;
    private IdentifierExpression identifier;
    private List<ParameterDeclaration> parameters;
    private List<Statement> statements;

    
    

    public FunctionDefinition(Specifiers typeSpecifier, IdentifierExpression identifier,
            List<ParameterDeclaration> parameters, List<Statement> statements) {
        this.setTypeSpecifier(typeSpecifier);
        this.setIdentifier(identifier);
        this.setParameters(parameters);
        this.setStatements(statements);
    }




    public List<Statement> getStatements() {
        return statements;
    }




    public void setStatements(List<Statement> statements) {
        this.statements = statements;
    }




    public List<ParameterDeclaration> getParameters() {
        return parameters;
    }




    public void setParameters(List<ParameterDeclaration> parameters) {
        this.parameters = parameters;
    }




    public IdentifierExpression getIdentifier() {
        return identifier;
    }




    public void setIdentifier(IdentifierExpression identifier) {
        this.identifier = identifier;
    }




    public Specifiers getTypeSpecifier() {
        return typeSpecifier;
    }




    public void setTypeSpecifier(Specifiers typeSpecifier) {
        this.typeSpecifier = typeSpecifier;
    }




    @Override
    public void accept(ASTVisitor visitor) throws ASTVisitorException {
        visitor.visit(this);
        
    }
    
}
