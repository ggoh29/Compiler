package Lexer.tokens;

import java.util.stream.IntStream;

public class Operator extends Tokens {

    private static char[] operatorList = {'+','-','*','/','^','(',')'};

    public Operator(String str){
        super(str);
        int j = findIndex(str);
        this.setType(j);
        setState(0);
    }

    public int findIndex(String t){
        char t_c = t.charAt(0);
        for (int i = 0; i < 7; i ++){
            if (t_c == Operator.operatorList[i]){
                return i;
            }
        }
        return -1;
    }

    @Override
    public float operate(float a, float b) {
        switch (this.getType()) {
            case 0:
                return a + b;
            case 1:
                return a - b;
            case 2:
                return a * b;
            case 3:
                return a / b;
            case 4:
                return (float) Math.pow(a, b);
        }
        return .0f;
    }

}
