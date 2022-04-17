package ast;

public class WhileStatement extends Statement {

    private Expression expression;
    private Statement statement;
    
    public WhileStatement(Expression expression, Statement statement) {
        super();
        this.setExpression(expression);
        this.setStatement(statement);
    }

    public Statement getStatement() {
        return statement;
    }

    public void setStatement(Statement statement) {
        this.statement = statement;
    }

    public Expression getExpression() {
        return expression;
    }

    public void setExpression(Expression expression) {
        this.expression = expression;
    }

    @Override
    public void accept(ASTVisitor visitor) throws ASTVisitorException {
        visitor.visit(this);
    }
}
