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
    "bool"                         { return createSymbol(sym.BOOLEAN_LITERAL);     }
    "float"                        { return createSymbol(sym.DOUBLE_LITERAL); }
    "int"                          { return createSymbol(sym.INTEGER_LITERAL); }
    "char"                         { return createSymbol(sym.CHARACTER_LITERAL); }

    /* identifiers */ 
    {Identifier}                   { return createSymbol(sym.IDENTIFIER, yytext()); }

    {IntegerLiteral}               { return createSymbol(sym.INTEGER_LITERAL, Integer.valueOf(yytext())); }
    {FloatLiteral}                 { return createSymbol(sym.DOUBLE_LITERAL, Double.valueOf(yytext())); }

    \"                             { sb.setLength(0); yybegin(STRING); }

    /* operators */
    "="                            { return createSymbol(sym.EQ); }
    "+"                            { return createSymbol(sym.PLUS); }
    "-"                            { return createSymbol(sym.MINUS); }
    "*"                            { return createSymbol(sym.TIMES); }
    "/"                            { return createSymbol(sym.DIVISION); }
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

    /* comments */
    {Comment}                      { /* ignore */ }

    /* whitespace */
    {WhiteSpace}                   { /* ignore */ }
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
