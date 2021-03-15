package Lexer.states;

import Lexer.Lexer;
import Lexer.tokens.*;
import Lexer.tokens.Number;

// TODO
// Currently does not have correct implementation of subtraction with not space. "5-2" is an error.
import java.util.ArrayList;

public class LexerStates {

    private static ArrayList<Tokens> tokenList = new ArrayList<Tokens>();
    private static LexerStates[] window = {new State00(""), new State00("")};
    protected String str;


    public void setup(ArrayList<Tokens> tokenList){
        LexerStates.tokenList = tokenList;
    }

    public void slideWindow(int[] pointer, char cur){
        LexerStates next = this.transition(pointer, cur);
        LexerStates.window[1] = LexerStates.window[0];
        LexerStates.window[0] = next;
    }
    
    public LexerStates transition(int[] pointer, char cur){
        return new State_1("");
    }

    public void accept(){}

    public ArrayList<Tokens> getTokenList(){
        return LexerStates.tokenList;
    }

    public LexerStates getNext(){
        return LexerStates.window[0];
    }

    public static class State_1 extends LexerStates{

        private State_1(String s){
            this.str = s;
        }

        @Override
        public LexerStates transition(int[] pointer, char cur){
            pointer[0] -= 2;
            LexerStates prev = LexerStates.window[1];
            prev.accept();
            LexerStates.window[0] = new State00("");
            return new State00("");
        }
    }

    public static class State00 extends LexerStates{

        public State00(String s){
            this.str = "";
        }

        @Override
        public LexerStates transition(int[] pointer, char cur){
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
                    return new State01(str + cur);
                case '-':
                    return new State02(str + cur);
                case '.':
                    return new State03(str + cur);
                case '+':
                    return new State06(str + cur);
                case '*':
                    return new State07(str + cur);
                case '/':
                    return new State08(str + cur);
                case '^':
                    return new State09(str + cur);
                case 'c':
                    return new State10(str + cur);
                case 't':
                    return new State13(str + cur);
                case 's':
                    return new State16(str + cur);
                case 'l':
                    return new State19(str + cur);
                case '(':
                    return new State22(str + cur);
                case ')':
                    return new State23(str + cur);
                case ' ':
                    return this;
            }
            return new State_1("" + cur);
        }
    }

    public static class State01 extends LexerStates {

        private State01(String s){
            this.str = s;
        }

        @Override
        public LexerStates transition(int[] pointer, char cur) {
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
                    this.str += cur;
                    return this; 
                case '.':
                    return new State05(this.str + cur);
            }
            return new State_1("" + cur);
        }

        public void accept(){
            LexerStates.tokenList.add(new Number(this.str));
        }
    }

    public static class State02 extends LexerStates {

        private State02(String s){
            this.str = s;
        }

        public void accept(){
            LexerStates.tokenList.add(new Operator(this.str));
        }
    }

    public static class State03 extends LexerStates {

        private State03(String s){
            this.str = s;
        }

        @Override
        public LexerStates transition(int[] pointer, char cur) {
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
                    return new State04(str + cur);
            }
            return new State_1("" + cur);
        }
    }

    public static class State04 extends LexerStates {

        private State04(String s){
            this.str = s;
        }

        @Override
        public LexerStates transition(int[] pointer, char cur) {
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
                    this.str += cur;
                    return this;
                case '.':
                    return new State05(str + cur);
            }
            return new State_1("" + cur);
        }

        public void accept(){
            LexerStates.tokenList.add(new Number(this.str));
        }
    }

    public static class State05 extends LexerStates {

        private State05(String s){
            this.str = s;
        }

        @Override
        public LexerStates transition(int[] pointer, char cur) {
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
                    this.str += cur;
                    return this;
            }
            return new State_1("" + cur);
        }

        public void accept(){
            LexerStates.tokenList.add(new Number(this.str));
        }
    }

    public static class State06 extends LexerStates {

        private State06(String s){
            this.str = s;
        }

        public void accept(){
            LexerStates.tokenList.add(new Operator(this.str));
        }

    }

    public static class State07 extends LexerStates {
        
        private State07(String s){
            this.str = s;
        }

        public void accept(){
            LexerStates.tokenList.add(new Operator(this.str));
        }
        
    }

    public static class State08 extends LexerStates {

        private State08(String s){
            this.str = s;
        }

        public void accept(){
            LexerStates.tokenList.add(new Operator(this.str));
        }

    }

    public static class State09 extends LexerStates {

        private State09(String s){
            this.str = s;
        }

        public void accept(){
            LexerStates.tokenList.add(new Operator(this.str));
        }

    }

    public static class State10 extends LexerStates {

        private State10(String s){
            this.str = s;
        }

        @Override
        public LexerStates transition(int[] pointer, char cur) {
            switch (cur){
                case 'o':
                    return new State11(str + cur);
            }
            return new State_1("" + cur);
        }
    }

    public static class State11 extends LexerStates {

        private State11(String s){
            this.str = s;
        }

        @Override
        public LexerStates transition(int[] pointer, char cur) {
            switch (cur){
                case 's':
                    return new State12(str + cur);
            }
            return new State_1("" + cur);
        }
    }

    public static class State12 extends LexerStates {

        private State12(String s){
            this.str = s;
        }

        public void accept(){
            LexerStates.tokenList.add(new Trig(this.str, 1));
        }

    }

    public static class State13 extends LexerStates {

        private State13(String s){
            this.str = s;
        }

        @Override
        public LexerStates transition(int[] pointer, char cur) {
            switch (cur){
                case 'a':
                    return new State14(str + cur);
            }
            return new State_1("" + cur);
        }
    }

    public static class State14 extends LexerStates {

        private State14(String s){
            this.str = s;
        }

        @Override
        public LexerStates transition(int[] pointer, char cur) {
            switch (cur){
                case 'n':
                    return new State15(str + cur);
            }
            return new State_1("" + cur);
        }
    }

    public static class State15 extends LexerStates {

        private State15(String s){
            this.str = s;
        }

        public void accept(){
            LexerStates.tokenList.add(new Trig(this.str, 2));
        }

    }

    public static class State16 extends LexerStates {

        private State16(String s){
            this.str = s;
        }

        @Override
        public LexerStates transition(int[] pointer, char cur) {
            switch (cur){
                case 'i':
                    return new State17(str + cur);
            }
            return new State_1("" + cur);
        }
    }

    public static class State17 extends LexerStates {

        private State17(String s){
            this.str = s;
        }

        @Override
        public LexerStates transition(int[] pointer, char cur) {
            switch (cur){
                case 'n':
                    return new State18(str + cur);
            }
            return new State_1("" + cur);
        }
    }

    public static class State18 extends LexerStates {

        private State18(String s){
            this.str = s;
        }

        public void accept(){
            LexerStates.tokenList.add(new Trig(this.str, 0));
        }

    }

    public static class State19 extends LexerStates {

        private State19(String s){
            this.str = s;
        }

        @Override
        public LexerStates transition(int[] pointer, char cur) {
            switch (cur){
                case 'o':
                    return new State20(str + cur);
            }
            return new State_1("" + cur);
        }
    }

    public static class State20 extends LexerStates {

        private State20(String s){
            this.str = s;
        }

        @Override
        public LexerStates transition(int[] pointer, char cur) {
            switch (cur){
                case 'g':
                    return new State21(str + cur);
            }
            return new State_1("" + cur);
        }
    }

    public static class State21 extends LexerStates {

        private State21(String s){
            this.str = s;
        }

        public void accept(){
            LexerStates.tokenList.add(new Log(this.str));
        }

    }

    public static class State22 extends LexerStates {

        private State22(String s){
            this.str = s;
        }

        public void accept(){
            LexerStates.tokenList.add(new Operator(this.str));
        }

    }

    public static class State23 extends LexerStates {

        private State23(String s){
            this.str = s;
        }

        public void accept(){
            LexerStates.tokenList.add(new Operator(this.str));
        }

    }

}
