package ast;

public class SpecifierExpression extends Expression {

    private TypeSpecifier typeSpecifier;

    @Override
    public void accept(ASTVisitor visitor) throws ASTVisitorException {
        visitor.visit(this);
        
    }
    
}
