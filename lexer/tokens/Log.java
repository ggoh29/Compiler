package lexer.tokens;

import lexer.tokens.Tokens;

public class Log extends Tokens {

    public Log(int type){
        super(type);
    }

    @Override
    public float operate(float a, float b){
        return (float) Math.log(b);
    }
}
