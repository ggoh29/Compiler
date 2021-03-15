package Lexer.tokens;

import Linearizer.Instructions;

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
    public Instructions operate() {
        switch (this.getType()) {
            case 0:
                return new Instructions.Add();
            case 1:
                return new Instructions.Sub();
            case 2:
                return new Instructions.Mul();
            case 3:
                return new Instructions.Div();
            case 4:
                return new Instructions.Pow();
        }
        return new Instructions();
    }

}
