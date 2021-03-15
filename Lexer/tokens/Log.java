package Lexer.tokens;

import Linearizer.Instructions;

public class Log extends Tokens {

    public Log(String str){
        super(str);
        this.setState(8);
    }

    @Override
    public Instructions operate(){
        return new Instructions.Log();

    }
}
