package org.hua.ast;

public class ParameterDeclaration extends ASTNode{

    private Specifiers typeSpecifier;
    private IdentifierExpression identifier;

    

    public ParameterDeclaration(Specifiers typeSpecifier, IdentifierExpression identifier) {
        this.setTypeSpecifier(typeSpecifier);
        this.setIdentifier(identifier);
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
