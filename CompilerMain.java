import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;


public class CompilerMain {

    public static void main(String[] args) throws Exception {
       Scanner sc = new Scanner(System.in);
       String inputStr = sc.nextLine();
        int length = inputStr.length();
        char[] charArray = inputStr.toCharArray();
        Lexer lex = new Lexer(charArray, length);
        lex.tokenise();
        Parser ps = new Parser();
        Symbols s = ps.parse(lex.getTokenList(), length);
        System.out.println("Answer: " + Symbols.evaluate(s));
    }
}
