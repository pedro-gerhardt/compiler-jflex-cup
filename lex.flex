import java_cup.runtime.*;

%%

%class Lexer

%line
%column

%cup

%{
    private Symbol symbol(int type) {
        return new Symbol(type, yyline, yycolumn);
    }

    private Symbol symbol(int type, Object value) {
        return new Symbol(type, yyline, yycolumn, value);
    }
%}

/* SYMBOLS AND IDENTIFIER */
NEWLINE=\r|\n|\r\n
NONNEWLINE_WHITE_SPACE_CHAR=[\ \t\b\012]
ALPHA = [A-Za-z]
DIGIT = -?[0-9]+
ID = {ALPHA}({ALPHA}|{DIGIT})*

%%

/* RWORDS */

"class"            { return symbol(sym.CLASS); }
"int"              { return symbol(sym.INT); }
"bool"             { return symbol(sym.BOOL); }
"void"             { return symbol(sym.VOID); }
"True"             { return symbol(sym.TRUE); }
"False"            { return symbol(sym.FALSE); }
"and"              { return symbol(sym.AND); }
"or"               { return symbol(sym.OR); }
"not"              { return symbol(sym.NOT); }
"if"               { return symbol(sym.IF); }
"else"             { return symbol(sym.ELSE); }
"return"           { return symbol(sym.RETURN); }
"while"            { return symbol(sym.WHILE); }
"main"             { return symbol(sym.MAIN); }

/* OPERATORS */

"="                { return symbol(sym.EQ); }
"=="               { return symbol(sym.EQEQ); }
"!="               { return symbol(sym.NOTEQ); }
">"                { return symbol(sym.GT); }
"<"                { return symbol(sym.LT); }
"+"                { return symbol(sym.PLUS); }
"*"                { return symbol(sym.TIMES); }

/* PUNTUACTION */

","                { return symbol(sym.COMMA); }
";"                { return symbol(sym.SEMI); }
"("                { return symbol(sym.LPAREN); }
")"                { return symbol(sym.RPAREN); }
"{"                { return symbol(sym.LCURLY); }
"}"                { return symbol(sym.RCURLY); }

{ID}                                         { return symbol(sym.IDENT, new String(yytext())); }
{DIGIT}+                                     { return symbol(sym.NUM, new String(yytext())); }

{NEWLINE}                                     { }
{NONNEWLINE_WHITE_SPACE_CHAR}+                { }
