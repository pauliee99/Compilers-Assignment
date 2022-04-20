package ast;

public class ContinueStatement extends ASTNode {

    public ContinueStatement() {

    }

    @Override
    public void accept(ASTVisitor visitor) throws ASTVisitorException {
        visitor.visit(this);
        
    }
    
}
