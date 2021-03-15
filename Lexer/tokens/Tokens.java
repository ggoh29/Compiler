package Lexer.tokens;

import Linearizer.Instructions;

public class Tokens extends Symbols {

    private String str;
    private int type;

    public Tokens(String str){
        this.str = str;
        this.type = 0;
    }

    public Instructions operate(){System.err.println("Tokens class should not be constructed."); return null;}

    public void setType(int type){this.type = type;}

    public int getType(){ return type; }

}
