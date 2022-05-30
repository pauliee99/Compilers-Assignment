package org.hua.ast;

public class VariableDefinitionStatement extends Statement {

    private VariableDefinition variableDefinition;

    

    public VariableDefinitionStatement(VariableDefinition variableDefinition) {
        this.setVariableDefinition(variableDefinition);
    }



    public VariableDefinition getVariableDefinition() {
        return variableDefinition;
    }



    public void setVariableDefinition(VariableDefinition variableDefinition) {
        this.variableDefinition = variableDefinition;
    }



    @Override
    public void accept(ASTVisitor visitor) throws ASTVisitorException {
        visitor.visit(this);
        
    }
    
}
