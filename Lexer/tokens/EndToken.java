package Lexer.tokens;

public class EndToken extends Tokens {

    public EndToken(String str){
        super("$");
        this.setState(10);
    }
}
