public class Number extends Tokens{

    public Number(int state, int type){
        super(state, type);
    }
    public float getf(){
        String[] split = getStr().split("e|E");
        int size = split.length;
        switch (size){
            case 1:
                return Float.parseFloat(split[0]);
            case 2:
                return (float) (Float.parseFloat(split[0]) * Math.pow(10, Float.parseFloat(split[1])));
        }
        return .0f;
    }

}
