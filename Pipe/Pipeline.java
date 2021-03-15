package Pipe;

import Lexer.Lexer;
import Lexer.tokens.Symbols;
import Lexer.tokens.Tokens;
import Linearizer.Linearizer;
import Parser.Parser;

import java.util.ArrayList;

public class Pipeline {

    public static float pipe(String str) throws Exception {
        return compile(str.toCharArray());
    }

    public static float pipe(char[] array) throws Exception {
        return compile(array);
    }

    private static float compile(char[] array) throws Exception {
        int length = array.length;
        Lexer lex = new Lexer(array, length);
        Parser ps = new Parser();
        ArrayList<Tokens> tokensList = lex.tokenise();
        Symbols s = ps.parse(tokensList, length);
        Linearizer lin = new Linearizer(s);
        float ans = lin.compute();
        return ans;
    }
}
