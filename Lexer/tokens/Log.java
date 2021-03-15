package Lexer.tokens;

public class Log extends Tokens {

    public Log(String str){
        super(str);
        this.setState(8);
    }

    @Override
    public float operate(float a, float b){
        return (float) Math.log(b);

    }
}
