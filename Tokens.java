public class Tokens extends Symbols{

    private int state;
    private String str;
    private int type;

    public Tokens(int state, int type){
        this.state = state;
        this.str = "";
        this.type = type;
    }

    public Number getNumber(){return new Number(state, 1);}

    public Operator getOperator(){return new Operator(state, 2);}

    public Operator getOperator(int type){return new Operator(state, type);}

    public Trig getTrig(){return new Trig(state, 3);}

    public int getState(){
        return this.state;
    }

    public void setState(int state){
        this.state = state;
    }

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
