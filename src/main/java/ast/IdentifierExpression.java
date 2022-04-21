/**
 * This code is part of the lab exercises for the Compilers course at Harokopio
 * University of Athens, Dept. of Informatics and Telematics.
 */
package ast;

import java.util.List;

public class IdentifierExpression extends Expression {

    private String identifier;
    private static Expression expression;
    private List<Expression> expressions;
    
    public IdentifierExpression(String identifier) {
        super(expression);
        this.identifier = identifier;
    }

    public IdentifierExpression(String identifier, Expression expression) {
        super(expression);
        this.identifier = identifier;
        IdentifierExpression.expression = expression;
    }

    public IdentifierExpression(String identifier, List<Expression> expressions) {
        super(expression);
        this.identifier = identifier;
        this.expressions = expressions;
    }

    public List<Expression> getExpressions() {
        return expressions;
    }

    public void setExpressions(List<Expression> expressions) {
        this.expressions = expressions;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    @Override
    public void accept(ASTVisitor visitor) throws ASTVisitorException {
        visitor.visit(this);
    }

}
