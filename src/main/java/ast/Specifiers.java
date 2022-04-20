package ast;

public enum Specifiers {

    INTEGER_SPECIFIER("int"),
    CHARACTER_SPECIFIER("char"),
    DOUBLE_SPECIFIER("double"),
    BOOLEAN_SPECIFIER("bool"),
    VOID("void"),
    STRUCT("struct");    

    private String type;

    private Specifiers(String type) {
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
