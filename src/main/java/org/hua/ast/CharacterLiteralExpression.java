package org.hua.ast;

public class CharacterLiteralExpression extends Expression {

    private Character character;

    public CharacterLiteralExpression(Character character) {
        this.setCharacter(character);
    }

    public Character getCharacter() {
        return character;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }

    @Override
    public void accept(ASTVisitor visitor) throws ASTVisitorException {
        visitor.visit(this);
        
    }
    
}
