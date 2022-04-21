package ast;

public class VariableDefinition extends ASTNode {

    private Specifiers typeSpecifier;
    private IdentifierExpression identifier;
    private IntegerLiteralExpression integerLiteral;

    public VariableDefinition(Specifiers typeSpecifier, IdentifierExpression identifier,
            IntegerLiteralExpression integerLiteral) {
        this.setTypeSpecifier(typeSpecifier);
        this.setIdentifier(identifier);
        this.setIntegerLiteral(integerLiteral);
    }

    public VariableDefinition(Specifiers typeSpecifier, IdentifierExpression identifier) {
        this.setTypeSpecifier(typeSpecifier);
        this.setIdentifier(identifier);
    }

    public IntegerLiteralExpression getIntegerLiteral() {
        return integerLiteral;
    }

    public void setIntegerLiteral(IntegerLiteralExpression integerLiteral) {
        this.integerLiteral = integerLiteral;
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
