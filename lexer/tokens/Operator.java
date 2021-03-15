package lexer.tokens;

import lexer.tokens.Tokens;

import java.util.stream.IntStream;

public class Operator extends Tokens {

    private int operatorType;
    private static char[] operatorList = {'(',')','+','-','*','/','^'};

    public Operator(int type){
        super(type);
    }

    public static int findIndex(char arr[], char t){
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

    @Override
    public float operate(float a, float b) {
        switch (operatorType) {
            case 2:
                float t0 = a + b;
                return t0;
            case 3:
                return a - b;
            case 4:
                return a * b;
            case 5:
                return a / b;
            case 6:
                return (float) Math.pow(a, b);
        }
        return .0f;
    }


    public int getOperatorType(){
        return operatorType;
    }

}
