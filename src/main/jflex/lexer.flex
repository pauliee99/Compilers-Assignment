/**
 *  This code is part of the lab exercises for the Compilers course
 *  at Harokopio University of Athens, Dept. of Informatics and Telematics.
 */

import static java.lang.System.out;
import java_cup.runtime.Symbol;

%%

%class Lexer
%unicode
%public
%final
%integer
%line
%column
%cup

%eofval{
    return createSymbol(sym.EOF);
%eofval}

%{
    private StringBuffer sb = new StringBuffer();

    private Symbol createSymbol(int type) {
        return new Symbol(type, yyline+1, yycolumn+1);
    }

    private Symbol createSymbol(int type, Object value) {
        return new Symbol(type, yyline+1, yycolumn+1, value);
    }
%}

LineTerminator = \r|\n|\r\n
WhiteSpace     = {LineTerminator} | [ \t\f] 
Comment        = "/*" [^*] ~"*/" | "/*" "*"+ "/"

Identifier     = [:jletter:] [:jletterdigit:]*
IntegerLiteral = 0 | [1-9][0-9]*
CharacterLiteral = [a-zA-Z0-9_]
StringLiteral = {CharacterLiteral}*
BooleanLiteral   = (\btrue\b)|(\bfalse\b)

Exponent       = [eE][\+\-]?[0-9]+
Float1         = [0-9]+ \. [0-9]+ {Exponent}?
Float2         = \. [0-9]+ {Exponent}?
Float3         = [0-9]+ \. {Exponent}?
Float4         = [0-9]+ {Exponent}
FloatLiteral   = {Float1} | {Float2} | {Float3} | {Float4}

%state STRING
%state CHARACTER

%%

<YYINITIAL> {
    /* reserved keywords */
    "print"                        { return createSymbol(sym.PRINT); }
    "do"                           { return createSymbol(sym.DO); }
    "while"                        { return createSymbol(sym.WHILE); }
    "if"                           { return createSymbol(sym.IF); }
    "else"                         { return createSymbol(sym.ELSE); }
    "void"                         { return createSymbol(sym.VOID); }
    "return"                       { return createSymbol(sym.RETURN); }
    "break"                        { return createSymbol(sym.BREAK); }
    "continue"                     { return createSymbol(sym.CONTINUE); }
    "struct"                       { return createSymbol(sym.STRUCT); }
    "bool"                         { return createSymbol(sym.BOOLEAN_LITERAL); }
    "float"                        { return createSymbol(sym.DOUBLE_LITERAL); }
    "int"                          { return createSymbol(sym.INTEGER_LITERAL); }
    "char"                         { return createSymbol(sym.CHARACTER_LITERAL); } // afto pezi na min xriazete
    "String"                       { return createSymbol(sym.STRING_LITERAL); } // afto pezi na min xriazete

    /* identifiers */ 
    {Identifier}                   { return createSymbol(sym.IDENTIFIER, yytext()); }

    {IntegerLiteral}               { return createSymbol(sym.INTEGER_LITERAL, Integer.valueOf(yytext())); }
    {FloatLiteral}                 { return createSymbol(sym.DOUBLE_LITERAL, Double.valueOf(yytext())); }
    {CharacterLiteral}             { return createSymbol(sym.CHARACTER_LITERAL, Character.valueOf(yytext())); }
    {StringLiteral}                { return createSymbol(sym.STRING_LITERAL, String.valueOf(yytext())); }
    {BooleanLiteral}               { return createSymbol(sym.BOOLEAN_LITERAL, Boolean.valueOf(yytext())); }

    \"                             { sb.setLength(0); yybegin(STRING); }
    \'                             { sb.setLength(0); yybegin(CHARACTER); }

    /* operators */
    "="                            { return createSymbol(sym.EQ); }
    "+"                            { return createSymbol(sym.PLUS); }
    "-"                            { return createSymbol(sym.MINUS); }
    "*"                            { return createSymbol(sym.TIMES); }
    "/"                            { return createSymbol(sym.DIVISION); }
    "%"                            { return createSymbol(sym.MODULUS); }
    "("                            { return createSymbol(sym.LPAREN); }
    ")"                            { return createSymbol(sym.RPAREN); }
    ";"                            { return createSymbol(sym.SEMICOLON); }
    "<"                            { return createSymbol(sym.LT); }
    ">"                            { return createSymbol(sym.GT); }
    "<="                           { return createSymbol(sym.LE); }
    ">="                           { return createSymbol(sym.GE); }
    "=="                           { return createSymbol(sym.EQEQ); }
    "!="                           { return createSymbol(sym.NEQ); }
    "{"                            { return createSymbol(sym.LCURLY); }
    "}"                            { return createSymbol(sym.RCURLY); }
    "["                            { return createSymbol(sym.LEFT_SQUARE); }
    "]"                            { return createSymbol(sym.RIGHT_SQUARE); }
    "&&"                           { return createSymbol(sym.LAND); }
    "||"                           { return createSymbol(sym.LOR); }
    "!"                            { return createSymbol(sym.LNOT); }
    "."                            { return createSymbol(sym.DOT); }
    ","                            { return createSymbol(sym.COMMA); }

    /* comments */
    {Comment}                      { /* ignore */ }

    /* whitespace */
    {WhiteSpace}                   { /* ignore */ }
}

<CHARACTER> {
    \'                             { yybegin(YYINITIAL); sb.toString(); 
                                        if (sb.length() > 1 ){
                                            throw new RuntimeException((yyline+1) + ":" + (yycolumn+1) + ":  Only one character is allowed in '', Did you mean to use \" instead? ");} else{
                                                out.println("SINGLE CHARACTER:" + sb.toString());
                                            } 
                                   }
    [^\n\t\0\'\\]+                 { sb.append(yytext()); }
    \\t                            { sb.append('\t'); }
    \\n                            { sb.append('\n'); }
    \\0                            { sb.append('\0'); }
    \\\'                           { sb.append('\''); }
    \\                             { sb.append('\\'); }
}

<STRING> {
    \"                             { yybegin(YYINITIAL);
                                     return createSymbol(sym.STRING_LITERAL, sb.toString());
                                   }

    [^\n\r\"\\]+                   { sb.append(yytext()); }
    \\t                            { sb.append('\t'); }
    \\n                            { sb.append('\n'); }

    \\r                            { sb.append('\r'); }
    \\\"                           { sb.append('\"'); }
    \\                             { sb.append('\\'); }
}

/* error fallback */
[^]                                { throw new RuntimeException((yyline+1) + ":" + (yycolumn+1) + ": illegal character <"+ yytext()+">"); }
