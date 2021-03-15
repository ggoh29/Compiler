package Lexer.tokens;

public class Number extends Tokens {

    float num;

    public Number(String str){
        super(str);
        num = Float.parseFloat(str);
    }

}
