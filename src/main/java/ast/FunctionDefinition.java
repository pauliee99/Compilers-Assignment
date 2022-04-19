package ast;

public class FunctionDefinition extends ASTNode {

    private TypeSpecifier typeSpecifier;
    

    @Override
    public void accept(ASTVisitor visitor) throws ASTVisitorException {
        visitor.visit(this);
        
    }
    
}
