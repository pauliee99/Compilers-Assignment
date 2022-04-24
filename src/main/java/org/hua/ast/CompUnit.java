package org.hua.ast;

import java.util.List;

public class CompUnit extends ASTNode {

    private List<Definitions> definitions;

    public CompUnit() {
    }

    public CompUnit(List<Definitions> definitions) {
        this.definitions = definitions;
    }

    public List<Definitions> getDefinitions() {
        return definitions;
    }

    public void setDefinitions(List<Definitions> definitions) {
        this.definitions = definitions;
    }

    @Override
    public void accept(ASTVisitor visitor) throws ASTVisitorException {
        visitor.visit(this);
    }

}
