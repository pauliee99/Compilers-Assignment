package ast;

public class BooleanLiteralExpression extends ASTNode {

    private Boolean literal;

    public BooleanLiteralExpression(Boolean literal) {
        this.setLiteral(literal);
    }

    public Boolean getLiteral() {
        return literal;
    }

    public void setLiteral(Boolean literal) {
        this.literal = literal;
    }

    @Override
    public void accept(ASTVisitor visitor) throws ASTVisitorException {
        visitor.visit(this);
        
    }
    
}
