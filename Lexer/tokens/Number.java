package Lexer.tokens;

import Linearizer.Instructions;

public class Number extends Tokens {

    float num;

    public Number(String str){
        super(str);
        num = Float.parseFloat(str);
        this.setState(9);
    }

    public float getNum(){
        return num;
    }

    public Instructions operate() {
        return new Instructions.Push(num);
    }

}
