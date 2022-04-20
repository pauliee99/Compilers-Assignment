package ast;

public class BreakStatement extends ASTNode {

    public BreakStatement() {
        
    }

    @Override
    public void accept(ASTVisitor visitor) throws ASTVisitorException {
        visitor.visit(this);
        
    }
    
}
