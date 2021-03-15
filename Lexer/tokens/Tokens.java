package Lexer.tokens;

import Lexer.Trig;

public class Tokens extends Symbols {

    private String str;
    private int type;

    public Tokens(String str){
        this.str = str;
        this.type = 0;
    }

    public float operate(float a, float b){return .0f;}

    public void setType(int type){this.type = type;}

    public int getType(){ return type; }

}
