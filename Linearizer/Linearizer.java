package Linearizer;

import Lexer.tokens.Number;
import Lexer.tokens.Symbols;
import Lexer.tokens.Tokens;

import java.util.ArrayList;
import java.util.LinkedList;

public class Linearizer {

    public static LinkedList<Instructions> instructionList;

    public Linearizer(Symbols s){
        this.instructionList = new LinkedList<Instructions>();
        evaluate(s);

    }

    public void evaluate(Symbols t){
        if (t instanceof Lexer.tokens.Number){
            Instructions i = ((Number) t).operate();
            Linearizer.instructionList.push(i);
        } else {
            int state = t.getState();
            switch (state){
                case 0:
                    evaluate(t.getMiddle());
                    break;
                case 1:
                    Instructions i = ((Tokens) t.getOperator()).operate();
                    Linearizer.instructionList.push(i);
                    evaluate(t.getLeft());
                    break;
                case 2:
                    Instructions j = ((Tokens) t.getOperator()).operate();
                    Linearizer.instructionList.push(j);
                    evaluate(t.getRight());
                    break;
                case 3:
                    Instructions k = ((Tokens) t.getOperator()).operate();
                    Linearizer.instructionList.push(k);
                    evaluate(t.getLeft());
                    evaluate(t.getRight());
                    break;
            }
        }
    }

    public float compute(){
        LinkedList <Float> stack = new LinkedList<>();
        while (! Linearizer.instructionList.isEmpty()){
            System.out.println(stack);
            Instructions i = Linearizer.instructionList.pop();
            i.execute(stack);
        }
        if (stack.size() == 1){
            return stack.pop();
        }
        return 0;
    }
}
