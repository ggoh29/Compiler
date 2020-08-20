import java.util.stream.IntStream;

public class Operator extends Tokens{

    private int operatorType;
    private static char[] operatorList = {'(',')','+','-','*','!'};

    public Operator(int state, int type){
        super(state, type);
    }

    public static int findIndex(char arr[], char t)
    {
        int len = arr.length;
        return IntStream.range(0, len)
                .filter(i -> t == arr[i])
                .findFirst() // first occurrence
                .orElse(-1); // No element found
    }

    @Override
    public void append(char c){
        operatorType = findIndex(operatorList, c);
        super.append(c);
    }

    public int getOperatorType(){
        return operatorType;
    }

}
