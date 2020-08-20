import java.util.ArrayList;
import java.util.LinkedList;

public class Parser {

    private static SC[][] parsetable
            ={{new SC.S12(),new SC.S11(),new SC.S10(),new SC.Er(),new SC.Er(),new SC.Er(),new SC.Er(),new SC.Er(),new SC.Er()},
            {new SC.Er(),new SC.Er(),new SC.Er(),new SC.Er(),new SC.S6(),new SC.Er(),new SC.Er(),new SC.Er(),new SC.R0()},
            {new SC.Er(),new SC.Er(),new SC.Er(),new SC.R2(),new SC.R2(),new SC.S7(),new SC.Er(),new SC.Er(),new SC.R2()},
            {new SC.Er(),new SC.Er(),new SC.Er(),new SC.R4(),new SC.R4(),new SC.R4(),new SC.S8(),new SC.Er(),new SC.R4()},
            {new SC.Er(),new SC.Er(),new SC.Er(),new SC.R6(),new SC.R6(),new SC.R6(),new SC.R6(),new SC.Er(),new SC.R6()},
            {new SC.Er(),new SC.Er(),new SC.Er(),new SC.R8(),new SC.R8(),new SC.R8(),new SC.R8(),new SC.S9(),new SC.R8()},
            {new SC.S12(),new SC.S11(),new SC.S10(),new SC.Er(),new SC.Er(),new SC.Er(),new SC.Er(),new SC.Er(),new SC.Er()},
            {new SC.S12(),new SC.S11(),new SC.S10(),new SC.Er(),new SC.Er(),new SC.Er(),new SC.Er(),new SC.Er(),new SC.Er()},
            {new SC.S12(),new SC.S11(),new SC.S10(),new SC.Er(),new SC.Er(),new SC.Er(),new SC.Er(),new SC.Er(),new SC.Er()},
            {new SC.Er(),new SC.Er(),new SC.Er(),new SC.R10(),new SC.R10(),new SC.R10(),new SC.R10(),new SC.R10(),new SC.R10()},
            {new SC.S12(),new SC.S11(),new SC.S10(),new SC.Er(),new SC.Er(),new SC.Er(),new SC.Er(),new SC.Er(),new SC.Er()},
            {new SC.S12(),new SC.S11(),new SC.S10(),new SC.Er(),new SC.Er(),new SC.Er(),new SC.Er(),new SC.Er(),new SC.Er()},
            {new SC.Er(),new SC.Er(),new SC.Er(),new SC.R11(),new SC.R11(),new SC.R11(),new SC.R11(),new SC.R11(),new SC.R11()},
            {new SC.Er(),new SC.Er(),new SC.Er(),new SC.R1(),new SC.R1(),new SC.S7(),new SC.Er(),new SC.Er(),new SC.R1()},
            {new SC.Er(),new SC.Er(),new SC.Er(),new SC.R3(),new SC.R3(),new SC.R3(),new SC.S8(),new SC.Er(),new SC.R3()},
            {new SC.Er(),new SC.Er(),new SC.Er(),new SC.R5(),new SC.R5(),new SC.R5(),new SC.R5(),new SC.Er(),new SC.R5()},
            {new SC.Er(),new SC.Er(),new SC.Er(),new SC.S17(),new SC.S18(),new SC.Er(),new SC.Er(),new SC.Er(),new SC.Er()},
            {new SC.Er(),new SC.Er(),new SC.Er(),new SC.R12(),new SC.R12(),new SC.R12(),new SC.R12(),new SC.R12(),new SC.R12()},
            {new SC.S12(),new SC.S11(),new SC.S10(),new SC.Er(),new SC.Er(),new SC.Er(),new SC.Er(),new SC.Er(),new SC.Er()},
            {new SC.Er(),new SC.Er(),new SC.Er(),new SC.R7(),new SC.R7(),new SC.R7(),new SC.R7(),new SC.S9(),new SC.R7()}};

    public static int[][] gotoTable
            = {{1,2,3,4,5},
            {0,0,0,0,0},
            {0,0,0,0,0},
            {0,0,0,0,0},
            {0,0,0,0,0},
            {0,0,0,0,0},
            {0,13,3,4,5},
            {0,0,14,4,5},
            {0,0,0,15,5},
            {0,0,0,0,0},
            {16,2,3,4,5},
            {0,0,0,19,5},
            {0,0,0,0,0},
            {0,0,0,0,0},
            {0,0,0,0,0},
            {0,0,0,0,0},
            {0,0,0,0,0},
            {0,0,0,0,0},
            {0,13,3,4,5},
            {0,0,0,0,0}};

    public static int indexing(Tokens token){
        switch (token.getType()){
            case 1:
                return 0;
            case 2:
            case 5:
                Operator t = (Operator) token;
                return t.getOperatorType() + 2;
            case 3:
                return 1;
            case 0:
                return 8;
        }
        return 0;
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
