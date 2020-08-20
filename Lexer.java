import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class Lexer {

    private char[] charArray;
    public ArrayList<Tokens> tokenList;
    private int length;

    public Lexer(char[] charArray, int length){
        this.charArray = charArray;
        this.length = length;
        tokenList = new ArrayList<Tokens>();
    }

    public ArrayList<Tokens> getTokenList(){
        return tokenList;
    }

    public void throwException(String message) throws Exception {
        throw new Exception(message);
    }

    public boolean isNumber(char c, Tokens token) throws Exception {
        String cs = String.valueOf(c).toLowerCase();
        switch (token.getState()){
            case 0:
                if (cs.matches("[0-9]|\\.|-")){
                    if (cs.equals(".")){
                        token.setState(5);
                    }
                    else{
                        token.setState(1);
                    }
                    return true;
                }
                break;
            case 1:
                if (cs.matches("[0-9]|\\.|e")){
                    if (cs.equals(".")){
                        token.setState(2);
                    }
                    else if (cs.equals("e")){
                        token.setState(3);
                    }
                    return true;
                }
                break;
            case 2:
                if (cs.matches("[0-9]|e")){
                    if (cs.equals("e")){
                        token.setState(3);
                    }
                    return true;
                }
                break;
            case 3:
                if (cs.matches("[1-9]|\\+|-")){
                    token.setState(4);
                    return true;
                }
                break;
            case 4:
                return cs.matches("[0-9]");
            case 5:
                if (cs.matches("[1-9]")){
                    token.setState(2);
                    return true;
                }
                break;
        }
        if (cs.matches("\\.|e")){
            throwException("Format of number is wrong");
        }
        return false;
    }

    public boolean isOperator(char c, Tokens token){
        String cs = String.valueOf(c).toLowerCase();
        return (cs.matches("\\(|\\)|\\*|\\+|-|!"));
    }

    public boolean isTrig(char c, Tokens token) throws Exception {
        char cs = Character.toLowerCase(c);
        switch (token.getState()){
            case 0:
                if (cs == 'c'){
                    token.setState(1);
                    return true;
                }
                break;
            case 1:
            case 4:
                if (cs == 'o'){
                    token.setState(2);
                    return true;
                } else {
                    throwException("Format of trig is wrong");
                }
                break;
            case 2:
                if (cs == 's') {
                    token.setState(3);
                    return true;
                }
                else {
                    throwException("Format of trig is wrong");
                }
                break;
            case 3:
                if (cs == 'c'){
                    token.setState(4);
                    return true;
                }
        }
        return false;
    }

    public boolean isWhitespace(char c, Tokens token){
        String cs = String.valueOf(c);
        return cs.equals(" ");
    }



    public void tokenise() throws Exception {
        Tokens token = new Tokens(0,0);
        System.out.println("Evaluating " +  new String(charArray));
        for (int i = 0; i < length; i ++){
            char cur = charArray[i];
            switch (token.getType()){
                case 0:
                    if (isNumber(cur, token)){
                        token = token.getNumber();
                    }
                    else if (isOperator(cur, token)){
                        token = token.getOperator();
                    }
                    else if (isTrig(cur, token)){
                        token = token.getTrig();
                    }
                    else if (!isWhitespace(cur,token)){
                        throwException("Invalid character detected");
                    }
                    break;
                case 1:
                    if (!isNumber(cur, token)){
                        tokenList.add(token);
                        token = new Tokens(0,0);
                        if (isOperator(cur, token)){
                            int closePara = cur == ')' || cur == '!' ? 5 : 2;
                            token = token.getOperator(closePara);
                        }
                        else if (isTrig(cur, token)) {
                            token = token.getTrig();
                        }
                        else {
                            if (isWhitespace(cur,token)){
                                token = new Tokens(0,4);
                            } else {
                                throwException("Invalid character detected");
                            }
                        }
                    }
                    break;
                case 2:
                    tokenList.add(token);
                    token = new Tokens(0,0);
                    if (isNumber(cur, token)){
                        token = token.getNumber();
                    }
                    else if (isTrig(cur, token)) {
                        token = token.getTrig();
                    }
                    else if (isOperator(cur, token)) {
                        int closePara = cur == ')' || cur == '!' ? 5 : 2;
                        token = token.getOperator(closePara);
                    }
                    else {
                        if (isWhitespace(cur,token)){
                            token = new Tokens(0,0);
                        } else {
                            throwException("Invalid character detected");
                        }
                    }
                    break;
                case 3:
                    if (isTrig(cur, token)){
                        if (token.getState() == 4){
                            tokenList.add(token);
                            token = token.getTrig();
                        }
                    }
                    else if (isOperator(cur, token)) {
                        tokenList.add(token);
                        token = token.getOperator();
                    }
                    else if (isNumber(cur, token)){
                        tokenList.add(token);
                        token = token.getNumber();
                    }
                    else {
                        if (isWhitespace(cur,token)){
                            tokenList.add(token);
                            token = new Tokens(0,0);
                        } else {
                            throwException("Invalid character detected");
                        }
                    }
                    break;
                case 4:
                    if (isOperator(cur, token)){
                        token = token.getOperator();
                    }
                    else if (isNumber(cur, token)){
                        token = token.getNumber();
                    }
                    else if (isTrig(cur, token)){
                        token = token.getTrig();
                    }
                    else if (!isWhitespace(cur,token)){
                        throwException("Invalid character detected");
                    }
                    break;
                case 5:
                    tokenList.add(token);
                    if (isOperator(cur, token)){
                        int closePara = cur == ')' || cur == '!' ? 5 : 2;
                        token = token.getOperator(closePara);
                    }
                    else if (isNumber(cur, token)){
                        token = token.getNumber();
                    }
                    else if (isTrig(cur, token)){
                        token = token.getTrig();
                    }
                    else if (isWhitespace(cur,token)){
                        token = new Tokens(0,4);
                    }
                    else {
                        throwException("Invalid character detected");
                    }
                    break;
            }
            token.append(cur);
        }
        if (token.getType() != 0 && token.getType() != 4){
            tokenList.add(token);
        }
        tokenList.add(new EndToken());
    }
}
