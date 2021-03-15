# Compiler

main function is in CompilerMain

The compiler is split into three parts, the lexer, the parser and the linearizer. A pipeline is used to join all 3 components.

The language is defined as such

0 S -> A

1 A -> A + B

2 A -> A - B

3 A -> B

4 B -> B * C

5 B -> B / C

6 B -> C

7 C -> C ^ D

8 C -> D

9 D -> trig D

0 D -> log D

1 D -> E

2 E -> num

3 E ->( A )

This compiler can do addition, subtraction, multiplication, division, power, trigonometry and logarithms.

Lexer uses a DFA approach to toxenise.

The parse table is an LALR(1) parser based on the grammar above.

Linearizer is used to linearize instructions such that the fit the format of a stack based architecture.
