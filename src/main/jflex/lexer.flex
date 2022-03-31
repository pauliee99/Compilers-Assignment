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
CharacterLiteral = [a-zA-Z0-9_]
StringLiteral = {CharacterLiteral}*
BooleanLiteral   = (\btrue\b)|(\bfalse\b)


Exponent = [eE] [\+\-]?[0-9]+
Float1 = [0-9]+ \. [0-9]+ {Exponent}?
Float2 = \. [0-9]+ {Exponent}?
Float3 = [0-9]+ \. {Exponent}?
Float4 = [0-9]+ {Exponent}
FloatLiteral = {Float1} | {Float2} | {Float3} | {Float4}}

%state STRING
%state CHARACTER

%%

<YYINITIAL> {
    /* reserved keywords */
    "while"                        { out.println("WHILE"); }
    "if"                           { out.println("IF"); }
    "else"                         { out.println("ELSE"); }
    "void"                         { out.println("VOID"); }
    "return"                       { out.println("RETURN"); }
    "break"                        { out.println("BREAK"); }
    "continue"                     { out.println("CONTINUE"); }
    "struct"                       { out.println("STRUCT"); }
    "bool"                         { out.println("BOOL"); }
    "float"                        { out.println("FLOAT"); }
    "int"                          { out.println("INT"); }
    "char"                         { out.println("CHAR"); }


    /* identifiers */ 
    {Identifier}                   { out.println("id:" + yytext()); }

    /* literals */
    {IntegerLiteral}               { out.println("INTEGER:" + yytext()); }
    {FloatLiteral}                 { out.println("FLOAT:" + yytext()); }
    {CharacterLiteral}             { out.println("CHARACTER:" + yytext()); }
    {StringLiteral}                { out.println("STRING:" + yytext()); }
    {BooleanLiteral}               { out.println("BOOLEAN" + yytext()); }

    \"                             { sb.setLength(0); yybegin(STRING); }
    \'                             { sb.setLength(0); yybegin(CHARACTER); }

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
    ">"                            { out.println("GREATER_THAN"); }
    "<="                           { out.println("LESS_EQUAL"); }
    ">="                           { out.println("GREATER_THAN"); }
    "=="                           { out.println("EQUAL_EQUAL"); }
    "!="                           { out.println("NOT_EQUAL"); }
    "{"                            { out.println("LEFT_CURLY"); }
    "}"                            { out.println("RIGHT_CURLY"); }
    "["                            { out.println("RIGHT_SQUARE"); }
    "]"                            { out.println("LEFT_SQUARE"); }
    "&&"                           { out.println("AND"); }
    "||"                           { out.println("OR"); }
    "!"                            { out.println("NOT"); }
    "."                            { out.println("DOT"); }
    ","                            { out.println("COMMA"); }

    /* comments */
    {Comment}                      { /* ignore */ }

    /* whitespace */
    {WhiteSpace}                   { /* ignore */ }
}

<CHARACTER> {
    \'                             { yybegin(YYINITIAL); sb.toString(); 
                                        if (sb.length() > 1 ){
                                            throw new RuntimeException((yyline+1) + ":" + (yycolumn+1) + ":  Only one character is allowed in '', Did you mean to use "" instead? ");} else{
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
                                     out.println("STRING:" + sb.toString()); 
                                   }
    [^\n\t\"\\]+                   { sb.append(yytext()); }
    \\t                            { sb.append('\t'); }
    \\n                            { sb.append('\n'); }
    \\\"                           { sb.append('\"'); }
    \\                             { sb.append('\\'); }
}

/* error fallback */
[^]                                { throw new RuntimeException((yyline+1) + ":" + (yycolumn+1) + ": illegal character <"+ yytext()+">"); }