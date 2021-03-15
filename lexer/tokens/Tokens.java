package lexer.tokens;

import lexer.Trig;

public class Tokens extends Symbols {

    private String str;
    private int type;

    public Tokens(int type){
        this.str = "";
        this.type = type;
    }

    public float operate(float a, float b){return .0f;}

    public Number newNumber(){return new Number(0);}

    public Trig newTrig(int type){return new Trig(type);}

    public Operator newOperator(){return new Operator(1);}

    public Log newLog(){return new Log(0);}

    public void append(char c){
        str = str + c;
    }

    public int getType(){
        return type;
    }

    public String getStr(){
        return str;
    }
}
