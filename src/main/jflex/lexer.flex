/**
 *  This code is part of the lab exercises for the Compilers course
 *  at Harokopio University of Athens, Dept. of Informatics and Telematics.
 */

import static java.lang.System.out;

%%

%class Lexer
%unicode
%public
%final
%integer
%line
%column

%{
    // user custom code 

    StringBuffer sb = new StringBuffer();

%}

LineTerminator = \r|\n|\r\n
WhiteSpace     = {LineTerminator} | [ \t\f] 
Comment        = "/*" [^*] ~"*/" | "/*" "*"+ "/"

Identifier     = [:jletter:] [:jletterdigit:]*
IntegerLiteral = 0 | [1-9][0-9]*

Exponent = [eE] [\+\-]?[0-9]+
Float1 = [0-9]+ \. [0-9]+ {Exponent}?
Float2 = \. [0-9]+ {Exponent}?
Float3 = [0-9]+ \. {Exponent}?
Float4 = [0-9]+ {Exponent}
FloatLiteral = {Float1} | {Float2} | {Float3} | {Float4}}

%state STRING

%%

<YYINITIAL> {
    /* reserved keywords */
    "print"                        { out.println("PRINT"); }

    /* identifiers */ 
    {Identifier}                   { out.println("id:" + yytext()); }

    /* literals */
    {IntegerLiteral}               { out.println("integer:" + yytext()); }
    {FloatLiteral}               { out.println("float:" + yytext()); }
    {CharLiteral}               { out.println("float:" + yytext()); }
    {BoolLiteral}               { out.println("float:" + yytext()); }

    \"                             { sb.setLength(0); yybegin(STRING); }

    /* operators */
    "="                            { out.println("ASSIGN"); }
    "+"                            { out.println("PLUS"); }
    "-"                            { out.println("MINUS"); }
    "*"                            { out.println("MULTIPLY"); }
    "/"                            { out.println("DIVIDE"); }
    "%"                            { out.println("MODULUS"); }
    ";"                            { out.println("SEMICOLON"); }
    "("                            { out.println("RIGHT_PARENTHESIS"); }
    ")"                            { out.println("LEFT_PARENTHESIS"); }
     "<"                            { out.println("LESS_THAN"); }
    ">"                            { out.println("GREATER_THAN") }
    "<="                           { out.println("LESS_EQUAL") }
    ">="                           { out.println("GREATER_THAN") }
    "=="                           { out.println("EQUAL_EQUAL") }
    "!="                           { out.println("NOT_EQUAL") }
    "{"                            { out.println("LEFT_CURLY") }
    "}"                            { out.println("RIGHT_CURLY") }
    "&&"                            { out.println("AND") }
    "||"                            { out.println("OR") }
    "!"                            { out.println("NOT") }
    "."                            { out.println("DOT") }

    /* comments */
    {Comment}                      { /* ignore */ }

    /* whitespace */
    {WhiteSpace}                   { /* ignore */ }
}

<STRING> {
    \"                             { yybegin(YYINITIAL);
                                     out.println("string:" + sb.toString()); 
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
