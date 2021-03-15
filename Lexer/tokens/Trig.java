package Lexer.tokens;

import Lexer.tokens.Tokens;
import Linearizer.Instructions;

public class Trig extends Tokens {

    public Trig(String str, int type){
        super(str);
        this.setType(type);
        this.setState(7);
    }

    @Override
    public Instructions operate(){
        switch (this.getType()){
            case 0:
                return new Instructions.Sin();
            case 1:
                return new Instructions.Cos();
            case 2:
                return new Instructions.Tan();
        }
        System.err.println("Unsupported trig");
        return new Instructions();
    }
}
