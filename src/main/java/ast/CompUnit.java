package ast;

import java.util.ArrayList;
import java.util.List;

public class CompUnit extends ASTNode {

    private Definitions definitions;

    

    public CompUnit(Definitions definitions) {
        this.setDefinitions(definitions);
    }



    public Definitions getDefinitions() {
        return definitions;
    }



    public void setDefinitions(Definitions definitions) {
        this.definitions = definitions;
    }



    @Override
    public void accept(ASTVisitor visitor) throws ASTVisitorException {
        visitor.visit(this);
    }

}
