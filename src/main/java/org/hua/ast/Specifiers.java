package org.hua.ast;

public class Specifiers extends ASTNode {

    private String type;
    private IdentifierExpression identifier;

    private Specifiers(String type) {
        this.type = type;
    }

    private Specifiers(String type, IdentifierExpression identifier) {
        this.type = type;
        this.identifier = identifier;
    }

    public IdentifierExpression getIdentifier() {
        return identifier;
    }

    public void setIdentifier(IdentifierExpression identifier) {
        this.identifier = identifier;
    }

    public String getType() {
        return type;
    }

    @Override
    public void accept(ASTVisitor visitor) throws ASTVisitorException {
        visitor.visit(this);
    }
    
}
