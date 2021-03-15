package lexer.tokens;

public class EndToken extends Tokens {

    public EndToken(){
        super(0);
        super.append('$');
    }
}
