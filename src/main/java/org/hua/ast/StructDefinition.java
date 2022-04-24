package org.hua.ast;

import java.util.List;

public class StructDefinition extends ASTNode {

    private IdentifierExpression identifier;
    private List<VariableDefinition> variableDefinition;

    public StructDefinition(IdentifierExpression identifier, List<VariableDefinition> variableDefinition) {
        this.setIdentifier(identifier);
        this.setVariableDefinition(variableDefinition);
    }

    public List<VariableDefinition> getVariableDefinition() {
        return variableDefinition;
    }

    public void setVariableDefinition(List<VariableDefinition> variableDefinition) {
        this.variableDefinition = variableDefinition;
    }

    public IdentifierExpression getIdentifier() {
        return identifier;
    }

    public void setIdentifier(IdentifierExpression identifier) {
        this.identifier = identifier;
    }

    @Override
    public void accept(ASTVisitor visitor) throws ASTVisitorException {
        visitor.visit(this);
        
    }
    
}
