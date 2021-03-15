package Parser;

import Lexer.tokens.Operator;
import Lexer.tokens.Symbols;
import Lexer.tokens.Tokens;

import java.util.ArrayList;
import java.util.LinkedList;

public class Parser {

    private static SC[][] parsetable
            ={{new SC.Err(),new SC.S10(),new SC.Err(),new SC.Err(),new SC.Err(),new SC.S09(),new SC.Err(),new SC.S05(),new SC.S06(),new SC.S08(),new SC.Err()},
              {new SC.S11(),new SC.S12(),new SC.Err(),new SC.Err(),new SC.Err(),new SC.Err(),new SC.Err(),new SC.Err(),new SC.Err(),new SC.Err(),new SC.R00()},
              {new SC.R03(),new SC.R03(),new SC.S13(),new SC.S14(),new SC.Err(),new SC.Err(),new SC.R03(),new SC.Err(),new SC.Err(),new SC.Err(),new SC.R03()},
              {new SC.R06(),new SC.R06(),new SC.R06(),new SC.R06(),new SC.S15(),new SC.Err(),new SC.R06(),new SC.Err(),new SC.Err(),new SC.Err(),new SC.R06()},
              {new SC.R08(),new SC.R08(),new SC.R08(),new SC.R08(),new SC.R08(),new SC.Err(),new SC.R08(),new SC.Err(),new SC.Err(),new SC.Err(),new SC.R08()},
              {new SC.Err(),new SC.S10(),new SC.Err(),new SC.Err(),new SC.Err(),new SC.S09(),new SC.Err(),new SC.S05(),new SC.S06(),new SC.S08(),new SC.Err()},
              {new SC.Err(),new SC.S10(),new SC.Err(),new SC.Err(),new SC.Err(),new SC.S09(),new SC.Err(),new SC.S05(),new SC.S06(),new SC.S08(),new SC.Err()},
              {new SC.R11(),new SC.R11(),new SC.R11(),new SC.R11(),new SC.R11(),new SC.Err(),new SC.R11(),new SC.Err(),new SC.Err(),new SC.Err(),new SC.R11()},
              {new SC.R12(),new SC.R12(),new SC.R12(),new SC.R12(),new SC.R12(),new SC.Err(),new SC.R12(),new SC.Err(),new SC.Err(),new SC.Err(),new SC.R12()},
              {new SC.Err(),new SC.S10(),new SC.Err(),new SC.Err(),new SC.Err(),new SC.S09(),new SC.Err(),new SC.S05(),new SC.S06(),new SC.S08(),new SC.Err()},
              {new SC.Err(),new SC.S10(),new SC.Err(),new SC.Err(),new SC.Err(),new SC.S09(),new SC.Err(),new SC.Err(),new SC.Err(),new SC.S08(),new SC.Err()},
              {new SC.Err(),new SC.S10(),new SC.Err(),new SC.Err(),new SC.Err(),new SC.S09(),new SC.Err(),new SC.S05(),new SC.S06(),new SC.S08(),new SC.Err()},
              {new SC.Err(),new SC.S10(),new SC.Err(),new SC.Err(),new SC.Err(),new SC.S09(),new SC.Err(),new SC.S05(),new SC.S06(),new SC.S08(),new SC.Err()},
              {new SC.Err(),new SC.S10(),new SC.Err(),new SC.Err(),new SC.Err(),new SC.S09(),new SC.Err(),new SC.S05(),new SC.S06(),new SC.S08(),new SC.Err()},
              {new SC.Err(),new SC.S10(),new SC.Err(),new SC.Err(),new SC.Err(),new SC.S09(),new SC.Err(),new SC.S05(),new SC.S06(),new SC.S08(),new SC.Err()},
              {new SC.Err(),new SC.S10(),new SC.Err(),new SC.Err(),new SC.Err(),new SC.S09(),new SC.Err(),new SC.S05(),new SC.S06(),new SC.S08(),new SC.Err()},
              {new SC.R09(),new SC.R09(),new SC.R09(),new SC.R09(),new SC.R09(),new SC.Err(),new SC.R09(),new SC.Err(),new SC.Err(),new SC.Err(),new SC.R09()},
              {new SC.R10(),new SC.R10(),new SC.R10(),new SC.R10(),new SC.R10(),new SC.Err(),new SC.R10(),new SC.Err(),new SC.Err(),new SC.Err(),new SC.R10()},
              {new SC.S11(),new SC.S12(),new SC.Err(),new SC.Err(),new SC.Err(),new SC.Err(),new SC.S25(),new SC.Err(),new SC.Err(),new SC.Err(),new SC.Err()},
              {new SC.R14(),new SC.R14(),new SC.R14(),new SC.R14(),new SC.R14(),new SC.R14(),new SC.R14(),new SC.Err(),new SC.Err(),new SC.Err(),new SC.R14()},
              {new SC.R01(),new SC.R01(),new SC.S13(),new SC.S14(),new SC.Err(),new SC.Err(),new SC.R01(),new SC.Err(),new SC.Err(),new SC.Err(),new SC.R01()},
              {new SC.R02(),new SC.R02(),new SC.S13(),new SC.S14(),new SC.Err(),new SC.Err(),new SC.R02(),new SC.Err(),new SC.Err(),new SC.Err(),new SC.R02()},
              {new SC.R04(),new SC.R04(),new SC.R04(),new SC.R04(),new SC.S15(),new SC.Err(),new SC.R04(),new SC.Err(),new SC.Err(),new SC.Err(),new SC.R04()},
              {new SC.R05(),new SC.R05(),new SC.R05(),new SC.R05(),new SC.S15(),new SC.Err(),new SC.R05(),new SC.Err(),new SC.Err(),new SC.Err(),new SC.R05()},
              {new SC.R07(),new SC.R07(),new SC.R07(),new SC.R07(),new SC.R07(),new SC.Err(),new SC.R07(),new SC.Err(),new SC.Err(),new SC.Err(),new SC.R07()},
              {new SC.R13(),new SC.R13(),new SC.R13(),new SC.R13(),new SC.R13(),new SC.Err(),new SC.R13(),new SC.Err(),new SC.Err(),new SC.Err(),new SC.R13()}};
                


    public static int[][] gotoTable
            = {{ 0, 1, 2, 3, 4, 7},
               { 0, 0, 0, 0, 0, 0},
               { 0, 0, 0, 0, 0, 0},
               { 0, 0, 0, 0, 0, 0},
               { 0, 0, 0, 0, 0, 0},
               { 0, 0, 0, 0,16, 7},
               { 0, 0, 0, 0,17, 7},
               { 0, 0, 0, 0, 0, 0},
               { 0, 0, 0, 0, 0, 0},
               { 0,18, 2, 3, 4, 7},
               { 0, 0, 0, 0, 0, 19},
               { 0, 0,20, 3, 4, 7},
               { 0, 0,21, 3, 4, 7},
               { 0, 0, 0,22, 4, 7},
               { 0, 0, 0,23, 4, 7},
               { 0, 0, 0, 0,24, 7},
               { 0, 0, 0, 0, 0, 0},
               { 0, 0, 0, 0, 0, 0},
               { 0, 0, 0, 0, 0, 0},
               { 0, 0, 0, 0, 0, 0},
               { 0, 0, 0, 0, 0, 0},
               { 0, 0, 0, 0, 0, 0},
               { 0, 0, 0, 0, 0, 0},
               { 0, 0, 0, 0, 0, 0},
               { 0, 0, 0, 0, 0, 0},
               { 0, 0, 0, 0, 0, 0}};

    public static int indexing(Tokens token){
        switch (token.getState()){
            case 0:
                Operator t = (Operator) token;
                return t.getType();
        }
        return token.getState();
    }

    public static int go(int i, int j){
        return gotoTable[i][j];
    }

    public Symbols parse(ArrayList<Tokens> tokenList, int length) throws Exception {
        LinkedList<Integer> stack2 = new LinkedList<Integer>();
        stack2.push(0);
        LinkedList<Symbols> stack = new LinkedList<Symbols>();
        int i = 1;
        Tokens first = tokenList.get(0);
        stack.push(first);
        SC transform = parsetable[0][indexing(first)];
        transform.Change(stack, stack2);
        while (!(stack.peek() instanceof Terminals.S)){
            Symbols next = tokenList.get(i);
            Symbols tempTerm = stack.peek();
            int tempState = stack2.peek();
            if (tempTerm instanceof Terminals) {
                Terminals tTerm = (Terminals) tempTerm;
                int nextState = go(tempState, tTerm.getInt());
                if (nextState != 0) {
                    stack2.push(nextState);
                    continue;
                }
            }
            int index = indexing((Tokens) next);
            transform = parsetable[tempState][index];
            boolean b = transform.Change(stack, stack2);
            if (b) {
                stack.push(tokenList.get(i));
                i++;
            }
        }
        return stack.get(0);
    }
}
