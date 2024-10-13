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

"class"            { System.out.print(" class "); return symbol(sym.CLASS); }
"int"              { System.out.print(" int "); return symbol(sym.INT); }
"bool"             { System.out.print(" bool "); return symbol(sym.BOOL); }
"void"             { System.out.print(" void "); return symbol(sym.VOID); }
"True"             { System.out.print(" True "); return symbol(sym.TRUE); }
"False"            { System.out.print(" False "); return symbol(sym.FALSE); }
"and"              { System.out.print(" and "); return symbol(sym.AND); }
"or"               { System.out.print(" or "); return symbol(sym.OR); }
"not"              { System.out.print(" not "); return symbol(sym.NOT); }
"if"               { System.out.print(" if "); return symbol(sym.IF); }
"else"             { System.out.print(" else "); return symbol(sym.ELSE); }
"for"              { System.out.print(" for "); return symbol(sym.FOR); }
"while"            { System.out.print(" while "); return symbol(sym.WHILE); }
"return"           { System.out.print(" return "); return symbol(sym.RETURN); }

/* OPERATORS */

"="                { System.out.print(" = "); return symbol(sym.EQ); }
"=="               { System.out.print(" == "); return symbol(sym.EQEQ); }
"!="               { System.out.print(" != "); return symbol(sym.NOTEQ); }
">"                { System.out.print(" > "); return symbol(sym.GT); }
"<"                { System.out.print(" < "); return symbol(sym.LT); }
"+"                { System.out.print(" + "); return symbol(sym.PLUS); }
"-"                { System.out.print(" - "); return symbol(sym.MINUS); }
"*"                { System.out.print(" * "); return symbol(sym.TIMES); }
"/"                { System.out.print(" / "); return symbol(sym.DIVIDE); }

/* PUNTUACTION */

","                { System.out.print(" , "); return symbol(sym.COMMA); }
";"                { System.out.print(" ; "); return symbol(sym.SEMI); }
"("                { System.out.print(" ( "); return symbol(sym.LPAREN); }
")"                { System.out.print(" ) "); return symbol(sym.RPAREN); }
"{"                { System.out.print(" { "); return symbol(sym.LCURLY); }
"}"                { System.out.print(" } "); return symbol(sym.RCURLY); }

{ID}                                         { System.out.print(yytext()); return symbol(sym.IDENT, new String(yytext())); }
{DIGIT}+                                     { System.out.print(yytext()); return symbol(sym.LIT, new String(yytext())); }

{NEWLINE}                                     { }
{NONNEWLINE_WHITE_SPACE_CHAR}+                { }
