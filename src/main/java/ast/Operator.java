/**
 * This code is part of the lab exercises for the Compilers course at Harokopio
 * University of Athens, Dept. of Informatics and Telematics.
 */
package ast;

public enum Operator {

    PLUS("+"),
    MINUS("-"),
    MULTIPLY("*"),
    DIVISION("/"),
    EQUAL("=="),
    NOT_EQUAL("!="),
    LESS("<"),
    LESS_EQ("<="),
    GREATER(">"),
    GREATER_EQ(">="),
    LNOT("!"),
    LOR("||"),
    LAND("&&");

    private String type;

    private Operator(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return type;
    }

}
