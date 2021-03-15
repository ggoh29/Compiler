package lexer;

import lexer.tokens.Tokens;

import java.util.ArrayList;

public class Lexer {

    private char[] charArray;
    private int length;

    public Lexer(char[] charArray, int length){
        this.charArray = charArray;
        this.length = length;
    }

    public void throwException(String message) throws Exception {
        throw new Exception(message);
    }

    public ArrayList<Tokens> tokenise() throws Exception {
        Tokens startToken = new Tokens(0);
        int prev_state = 0;
        int state = 0;
        int start = 0;

        ArrayList<Tokens> tokenList = new ArrayList<Tokens>();
        for (int i = 0; i < length; i++) {
            char cur = charArray[i];
            switch (state){
                case 0:
                    start = i;
                    prev_state = state;
                    state = state00(cur);
                case 1:
                    prev_state = state;
                    state = state01(cur);
                case 2:
                    prev_state = state;
                    state = state02(cur);
                case 3:
                    prev_state = state;
                    state = state03(cur);
                case 4:
                    prev_state = state;
                    state = state04(cur);
                case 5:
                    prev_state = state;
                    state = state05(cur);
                case 10:
                    prev_state = state;
                    state = state10(cur);
                case 11:
                    prev_state = state;
                    state = state11(cur);
                case 13:
                    prev_state = state;
                    state = state13(cur);
                case 14:
                    prev_state = state;
                    state = state14(cur);
                case 16:
                    prev_state = state;
                    state = state16(cur);
                case 17:
                    prev_state = state;
                    state = state17(cur);
                case 19:
                    prev_state = state;
                    state = state19(cur);
                case 20:
                    prev_state = state;
                    state = state20(cur);
            }
        }
        return tokenList;
    }

    public int state00(char cur){
        switch (cur){
            case '0':
            case '1':
            case '2':
            case '3':
            case '4':
            case '5':
            case '6':
            case '7':
            case '8':
            case '9':
                return 1;
            case '-':
                return 2;
            case '.':
                return 3;
            case '+':
                return 6;
            case '*':
                return 7;
            case '/':
                return 8;
            case '^':
                return 9;
            case 'c':
                return 10;
            case 't':
                return 13;
            case 's':
                return 16;
            case 'l':
                return 19;
            case '(':
                return 22;
            case ')':
                return 23;
        }
        return -1;
    }

    public int state01(char cur){
        switch (cur){
            case '0':
            case '1':
            case '2':
            case '3':
            case '4':
            case '5':
            case '6':
            case '7':
            case '8':
            case '9':
                return 1;
            case '.':
                return 5;
        }
        return -1;
    }

    public int state02(char cur){
        switch (cur){
            case '0':
            case '1':
            case '2':
            case '3':
            case '4':
            case '5':
            case '6':
            case '7':
            case '8':
            case '9':
                return 4;
            case '.':
                return 3;
            case ' ':
                return 2;
        }
        return -1;
    }

    public int state03(char cur){
        switch (cur){
            case '0':
            case '1':
            case '2':
            case '3':
            case '4':
            case '5':
            case '6':
            case '7':
            case '8':
            case '9':
                return 5;
        }
        return -1;
    }

    public int state04(char cur){
        switch (cur){
            case '0':
            case '1':
            case '2':
            case '3':
            case '4':
            case '5':
            case '6':
            case '7':
            case '8':
            case '9':
                return 4;
            case '.':
                return 5;
        }
        return -1;
    }

    public int state05(char cur){
        switch (cur){
            case '0':
            case '1':
            case '2':
            case '3':
            case '4':
            case '5':
            case '6':
            case '7':
            case '8':
            case '9':
                return 5;
        }
        return -1;
    }

    public int state10 (char cur){
        switch (cur){
            case 'o':
                return 11;
        }
        return -1;
    }

    public int state11(char cur){
        switch (cur){
            case 's':
                return 12;
        }
        return -1;
    }

    public int state13 (char cur){
        switch (cur){
            case 'a':
                return 14;
        }
        return -1;
    }

    public int state14 (char cur){
        switch (cur){
            case 'n':
                return 15;
        }
        return -1;
    }

    public int state16(char cur){
        switch (cur){
            case 'i':
                return 17;
        }
        return -1;
    }

    public int state17(char cur){
        switch (cur){
            case 'n':
                return 18;
        }
        return -1;
    }

    public int state19(char cur){
        switch (cur){
            case 'o':
                return 20;
        }
        return -1;
    }

    public int state20(char cur){
        switch (cur){
            case'g':
                return 21;
        }
        return -1;
    }

    public int stateACC(char cur){
        return -1;
    }


}
