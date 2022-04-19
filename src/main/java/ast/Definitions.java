package ast;

public class Definitions extends ASTNode {

    private StructDefinition structDefinition;
    private FunctionDefinition functionDefinition;;
    private VariableDefinition variableDefinition;

    public Definitions(StructDefinition structDefinition, FunctionDefinition functionDefinition,
            VariableDefinition variableDefinition) {
        this.setStructDefinition(structDefinition);
        this.setFunctionDefinition(functionDefinition);
        this.setVariableDefinition(variableDefinition);
    }

    

    public VariableDefinition getVariableDefinition() {
        return variableDefinition;
    }



    public void setVariableDefinition(VariableDefinition variableDefinition) {
        this.variableDefinition = variableDefinition;
    }



    public FunctionDefinition getFunctionDefinition() {
        return functionDefinition;
    }



    public void setFunctionDefinition(FunctionDefinition functionDefinition) {
        this.functionDefinition = functionDefinition;
    }



    public StructDefinition getStructDefinition() {
        return structDefinition;
    }



    public void setStructDefinition(StructDefinition structDefinition) {
        this.structDefinition = structDefinition;
    }



    @Override
    public void accept(ASTVisitor visitor) throws ASTVisitorException {
        visitor.visit(this);
        
    }
    
}
