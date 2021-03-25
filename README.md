# Compiler

main function is in CompilerMain

The compiler is split into three parts, the lexer, the parser and the linearizer. A pipeline is used to join all 3 components.

The language is defined as such

S -> A

A -> A + B | A - B | B

B -> B * C | B / C | C

C -> C ^ D | D

D -> trig D | log D | E

E -> num  | ( A ) | - E


This compiler can do addition, subtraction, multiplication, division, power, trigonometry and logarithms.

Lexer uses a DFA approach to toxenise.

The parse table is an LALR(1) parser based on the grammar above.

Linearizer is used to linearize instructions such that the fit the format of a stack based architecture.
