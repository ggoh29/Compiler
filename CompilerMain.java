import Parser.Parser;
import lexer.Lexer;
import lexer.tokens.Symbols;
import lexer.tokens.Tokens;

import java.util.ArrayList;
import java.util.Scanner;


public class CompilerMain {

    public static float pipe(char[] array) throws Exception {
        int length = array.length;
        Lexer lex = new Lexer(array, length);
        Parser ps = new Parser();
        ArrayList<Tokens> tokensList = lex.tokenise();
        Symbols s = ps.parse(tokensList, length);
        return Symbols.evaluate(s);
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String inputStr = sc.nextLine();
        float result = pipe(inputStr.toCharArray());
        System.out.println(result);
    }
}