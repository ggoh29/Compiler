package lexer.states;

import lexer.Lexer;
import lexer.tokens.Tokens;

import java.util.ArrayList;

public class LexerStates {

    private ArrayList<Tokens> tokenList;

    public void setup(ArrayList<Tokens> tokenList){
        this.tokenList = tokenList;
    }

    public LexerStates transition(char cur, int s, int e){return new LexerStates();};

    public class State_1 extends LexerStates{

        @Override
        public LexerStates transition(char cur, int s, int e){
            return new State00();
        }
    }

    public class State00 extends LexerStates{

        @Override
        public LexerStates transition(char cur, int s, int e){
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
                    return new State01();
                case '-':
                    return new State02();
                case '.':
                    return new State03();
                case '+':
                    return new State06();
                case '*':
                    return new State07();
                case '/':
                    return new State08();
                case '^':
                    return new State09();
                case 'c':
                    return new State10();
                case 't':
                    return new State13();
                case 's':
                    return new State16();
                case 'l':
                    return new State19();
                case '(':
                    return new State22();
                case ')':
                    return new State23();
            }
            return new State_1();
        }
    }

    public class State01 extends LexerStates {

        @Override
        public LexerStates transition(char cur, int s, int e) {
            switch (cur) {
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
                    return this;
                case '.':
                    return new State05();
            }
            return new State_1();
        }
    }

    public class State02 extends LexerStates {

        @Override
        public LexerStates transition(char cur, int s, int e) {
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
                    return new State04();
                case '.':
                    return new State03();
                case ' ':
                    return this;
            }
            return new State_1();
        }
    }

    public class State03 extends LexerStates {

        @Override
        public LexerStates transition(char cur, int s, int e) {
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
                    return new State04();
                case '.':
                    return new State03();
                case ' ':
                    return this;
            }
            return new State_1();
        }
    }


}
