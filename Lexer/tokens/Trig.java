package Lexer.tokens;

import Lexer.tokens.Tokens;

public class Trig extends Tokens {

    public Trig(String str, int type){
        super(str);
        this.setType(type);
        this.setState(7);
    }

    @Override
    public float operate(float a, float b){
        switch (this.getType()){
            case 0:
                return (float) Math.sin(b);
            case 1:
                return (float) Math.cos(b);
            case 2:
                return (float) Math.tan(b);
        }
        System.err.println("Unsupported trig");
        return 0;
    }
}
