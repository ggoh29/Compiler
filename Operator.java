import java.util.stream.IntStream;

public class Operator extends Tokens{

    private int operatorType;
    private static char[] operatorList = {'(',')','+','-','*','!'};

    public Operator(int state, int type){
        super(state, type);
    }

    public static int findIndex(char arr[], char t)
    {
        int len = arr.length;
        return IntStream.range(0, len)
                .filter(i -> t == arr[i])
                .findFirst() // first occurrence
                .orElse(-1); // No element found
    }

    @Override
    public void append(char c){
        operatorType = findIndex(operatorList, c);
        super.append(c);
    }

    public static float factorial(float a){
        return (a == 1 || a == 0) ? 1 : a * factorial(a - 1);
    }

    @Override
    public float operate(float a, float b){
        switch (operatorType){
            case 2:
                float t = a + b;
                System.out.println(a + " + " + b + " = " +  t);
                return a + b;
            case 3:
                float t1 = a-b;
                System.out.println(a + " - " + b + " = " +  t1);
                return a - b;
            case 4:
                float t2 = a * b;
                System.out.println(a + " * " + b + " = " +  t2);
                return a * b;
            case 5:
                float t4 = factorial((float) Math.floor(Math.abs(a)));
                System.out.println(a + "! = " +  t4);
                return t4;
        }
        return .0f;
    }

    public int getOperatorType(){
        return operatorType;
    }

}
