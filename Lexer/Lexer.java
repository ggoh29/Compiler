package Lexer;

import Lexer.states.LexerStates;
import Lexer.tokens.EndToken;
import Lexer.tokens.Tokens;
import Parser.Terminals;

import java.util.ArrayList;

public class Lexer {

    private char[] charArray;
    private int length;

    public Lexer(char[] charArray, int length){
        this.charArray = new char[length + 1];
        this.length = length + 1;
        int i;
        for (i = 0; i < length; i++){
            this.charArray[i] = charArray[i];
        }
        this.charArray[i] = '$';
    }

    public ArrayList<Tokens> tokenise(){
        LexerStates state = new LexerStates.State00("");
        ArrayList<Tokens> tokenList = new ArrayList<Tokens>();
        state.setup(tokenList);
        int[] pointer = {0};

        for (pointer[0] = 0; pointer[0] < length; pointer[0]++){
            int i = pointer[0];
            char cur = charArray[i];
            state.slideWindow(pointer, cur);
            state = state.getNext();
        }
        state.slideWindow(pointer, '$');
        tokenList = state.getTokenList();
        tokenList.add(new EndToken("$"));
        return tokenList;

    }

}
