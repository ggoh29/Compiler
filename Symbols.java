public class Symbols {

    private Symbols left;
    private Symbols right;
    private Symbols middle;
    private Symbols operator;
    private Symbols parent;
    private int state;

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

    public void setParent(Symbols parent) {
        this.parent = parent;
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

    public Symbols getParent() {
        return parent;
    }

    public Symbols getOperator() {
        return operator;
    }

    public int getState(){
        return this.state;
    }

}
