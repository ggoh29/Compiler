package lexer;

import lexer.tokens.Tokens;

public class Trig extends Tokens {

    public Trig(int type){
        super(type);
    }

    @Override
    public float operate(float a, float b){
        switch (this.getType()){
            case 3:
                return (float) Math.sin(b);
            case 4:
                return (float) Math.cos(b);
            case 5:
                return (float) Math.tan(b);
        }
        System.err.println("Unsupported trig");
        return 0;
    }
}
