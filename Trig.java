public class Trig extends Tokens {

    public Trig(int state, int type){
        super(state, type);
    }

    @Override
    public float operate(float a, float b){
        System.out.println("cos" + b +  " = " +  Math.cos(b));
        return (float) Math.cos(b);
    }
}
