import java.util.ArrayList;


public class CompilerMain {


    public static void main(String[] args) throws Exception {
//        Scanner sc = new Scanner(System.in);
//        String inputStr = sc.nextLine();
//        int length = inputStr.length();
//        char[] charArray = inputStr.toCharArray();
//        Lexer lex = new Lexer(charArray, length);
//        lex.tokenise();
//        System.out.println(lex.tokenList);
//        for (Tokens t : lex.tokenList){
//            System.out.println(t.getStr());
//        }
        ArrayList<String> stuff = new ArrayList<String>();
        stuff.add("(10! + 10 * 10 - 10) * cos 90 * (80 + 30)!");
        stuff.add("cos 90 * (80 + 30)!");
        stuff.add("-12.0e12 + (10 + 10)--50");
        stuff.add("((10!) * cos 10!)");
        stuff.add("(.54e30! * (cos 84)) - -35e+20 ");
        stuff.add("coscos 60 + (89) * -0123");
        stuff.add("coscos 60!!");
        for (String inputStr : stuff){
            int length = inputStr.length();
            char[] charArray = inputStr.toCharArray();
            Lexer lex = new Lexer(charArray, length);
            lex.tokenise();
            Parser ps = new Parser();
            ps.parse(lex.tokenList, length);
        }
    }
}