package lexer.tokens;

public class Symbols {

    private Symbols left;
    private Symbols right;
    private Symbols middle;
    private Symbols operator;
    private Symbols parent;
    private int state;

    public static float evaluate(Symbols t){
        if (t instanceof lexer.tokens.Number){
            return ((lexer.tokens.Number) t).getf();
        } else {
            int state = t.getState();
            switch (state){
                case 0:
                    return evaluate(t.getMiddle());
                case 1:
                    return ((Tokens)t.getOperator()).operate(evaluate(t.getLeft()), 0.f);
                case 2:
                    return ((Tokens)t.getOperator()).operate(.0f, evaluate(t.getRight()));
                case 3:
                    return ((Tokens)t.getOperator()).operate(evaluate(t.getLeft()), evaluate(t.getRight()));
            }
        }
        return 0.f;
    }

    public void setState(int state){
        this.state = state;
    }

    public void setLeft(Symbols left) {
        this.left = left;
    }

    public void setRight(Symbols right) {
        this.right = right;
    }

    public void setMiddle(Symbols middle) {
        this.middle = middle;
    }

    public void setOperator(Symbols operator) {
        this.operator = operator;
    }

    public Symbols getLeft() {
        return left;
    }

    public Symbols getRight() {
        return  right;
    }

    public Symbols getMiddle() {
        return  middle;
    }

    public Symbols getOperator() {
        return operator;
    }

    public int getState(){
        return this.state;
    }

}
