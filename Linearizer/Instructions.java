package Linearizer;

import java.util.LinkedList;

public class Instructions {

    public void execute(LinkedList<Float> list){
        System.err.println("Super Class Instruction should not be called");
    }
    
    public static class Push extends Instructions{
        
        float f;
        
        public Push(float f){
            this.f = f;
        }

        @Override
        public void execute(LinkedList<Float> list){
            list.push(f);
        }
    }

    public static class Add extends Instructions{

        @Override
        public void execute(LinkedList<Float> list){
            float a = list.pop();
            float b = list.pop();
            list.push(a + b);
        }
    }

    public static class Sub extends Instructions{

        @Override
        public void execute(LinkedList<Float> list){
            float a = list.pop();
            float b = list.pop();
            list.push(b - a);
        }
    }

    public static class Mul extends Instructions{

        @Override
        public void execute(LinkedList<Float> list){
            float a = list.pop();
            float b = list.pop();
            list.push(a * b);
        }
    }

    public static class Div extends Instructions{

        @Override
        public void execute(LinkedList<Float> list){
            float a = list.pop();
            float b = list.pop();
            if (b == 0){
                System.err.println("Division by zero error");
            }
            list.push(a / b);
        }
    }
    
    public static class Pow extends Instructions{

        @Override
        public void execute(LinkedList<Float> list){
            float a = list.pop();
            float b = list.pop();
            list.push((float) Math.pow(b, a));
        }
    }
    
    public static class Sin extends Instructions{

        @Override
        public void execute(LinkedList<Float> list){
            float a = list.pop();
            list.push((float) Math.sin(a));
        }
    }

    public static class Cos extends Instructions{

        @Override
        public void execute(LinkedList<Float> list){
            float a = list.pop();
            list.push((float) Math.cos(a));
        }
    }

    public static class Tan extends Instructions{

        @Override
        public void execute(LinkedList<Float> list){
            float a = list.pop();
            list.push((float) Math.tan(a));
        }
    }

    public static class Log extends Instructions{

        @Override
        public void execute(LinkedList<Float> list){
            float a = list.pop();
            list.push((float) Math.log(a));
        }
    }
}
