package ast;

public class ParameterDeclaration extends ASTNode{

    @Override
    public void accept(ASTVisitor visitor) throws ASTVisitorException {
        visitor.visit(this);
        
    }
    
}
