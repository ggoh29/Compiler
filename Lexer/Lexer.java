package Lexer;

import Lexer.states.LexerStates;
import Lexer.tokens.EndToken;
import Lexer.tokens.Tokens;

import java.util.ArrayList;

public class Lexer {

    private char[] charArray;
    private int length;

    public Lexer(char[] charArray, int length){
        this.charArray = charArray;
        this.length = length;
    }

    public ArrayList<Tokens> tokenise(){
        LexerStates state = new LexerStates.State00("");
        ArrayList<Tokens> tokenList = new ArrayList<Tokens>();
        state.setup(tokenList);

        for (int i = 0; i < length; i++) {
            char cur = charArray[i];
            state.slideWindow(cur);
            state = state.getNext();
        }
        state.getNext().accept();
        tokenList = state.getTokenList();
        tokenList.add(new EndToken("$"));
        return tokenList;

    }

}
