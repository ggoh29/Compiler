import java.util.LinkedList;

public class SC {

    public boolean Change (LinkedList<Symbols> stack, LinkedList<Integer> stack2) throws Exception {return false;}

    public static class R0 extends SC {
        @Override
        public boolean Change (LinkedList<Symbols> stack, LinkedList<Integer> stack2){
            stack2.pop();
            Symbols t = stack.pop();
            Terminals s = new Terminals().makeS();
            s.setMiddle(t);
            s.setState(0);
            stack.push(s);
            return false;
        }
    }

    public static class R1 extends SC {
        @Override
        public boolean Change (LinkedList<Symbols> stack, LinkedList<Integer> stack2){
            stack2.pop();
            stack2.pop();
            stack2.pop();
            Symbols b = stack.pop();
            Symbols p = stack.pop();
            Symbols a = stack.pop();
            Terminals aa = new Terminals().makeA();
            aa.setLeft(a);
            aa.setRight(b);
            aa.setOperator(p);
            aa.setState(3);
            stack.push(aa);
            return false;
        }
    }

    public static class R2 extends SC {
        @Override
        public boolean Change (LinkedList<Symbols> stack, LinkedList<Integer> stack2){
            stack2.pop();
            Symbols b = stack.pop();
            Terminals aa = new Terminals().makeA();
            aa.setMiddle(b);
            aa.setState(0);
            stack.push(aa);
            return false;
        }
    }

    public static class R3 extends SC {
        @Override
        public boolean Change (LinkedList<Symbols> stack, LinkedList<Integer> stack2){
            stack2.pop();
            stack2.pop();
            stack2.pop();
            Symbols c = stack.pop();
            Symbols m = stack.pop();
            Symbols b = stack.pop();
            Terminals bb = new Terminals().makeB();
            bb.setLeft(b);
            bb.setRight(c);
            bb.setOperator(m);
            bb.setState(3);
            stack.push(bb);
            return false;
        }
    }

    public static class R4 extends SC {
        @Override
        public boolean Change (LinkedList<Symbols> stack, LinkedList<Integer> stack2){
            stack2.pop();
            Symbols c = stack.pop();
            Terminals bb = new Terminals().makeB();
            bb.setMiddle(c);
            bb.setState(0);
            stack.push(bb);
            return false;
        }
    }

    public static class R5 extends SC {
        @Override
        public boolean Change (LinkedList<Symbols> stack, LinkedList<Integer> stack2){
            stack2.pop();
            stack2.pop();
            stack2.pop();
            Symbols d = stack.pop();
            Symbols m = stack.pop();
            Symbols c = stack.pop();
            Terminals cc = new Terminals().makeC();
            cc.setLeft(c);
            cc.setRight(d);
            cc.setOperator(m);
            cc.setState(3);
            stack.push(cc);
            return false;
        }
    }

    public static class R6 extends SC {
        @Override
        public boolean Change (LinkedList<Symbols> stack, LinkedList<Integer> stack2){
            stack2.pop();
            Symbols d = stack.pop();
            Terminals cc = new Terminals().makeC();
            cc.setMiddle(d);
            cc.setState(0);
            stack.push(cc);
            return false;
        }
    }

    public static class R7 extends SC {
        @Override
        public boolean Change (LinkedList<Symbols> stack, LinkedList<Integer> stack2){
            stack2.pop();
            stack2.pop();
            Symbols d = stack.pop();
            Symbols t = stack.pop();
            Terminals dd = new Terminals().makeD();
            dd.setOperator(t);
            dd.setRight(d);
            dd.setState(2);
            stack.push(dd);
            return false;
        }
    }

    public static class R8 extends SC {
        @Override
        public boolean Change (LinkedList<Symbols> stack, LinkedList<Integer> stack2){
            stack2.pop();
            Symbols e = stack.pop();
            Terminals dd = new Terminals().makeD();
            dd.setMiddle(e);
            dd.setState(0);
            stack.push(dd);
            return false;
        }
    }

    public static class R10 extends SC {
        @Override
        public boolean Change(LinkedList<Symbols> stack, LinkedList<Integer> stack2) {
            stack2.pop();
            stack2.pop();
            Symbols f = stack.pop();
            Symbols e = stack.pop();
            Terminals ee = new Terminals.E();
            ee.setOperator(f);
            ee.setLeft(e);
            ee.setState(1);
            stack.push(ee);
            return false;
        }
    }

    public static class R11 extends SC {
        @Override
        public boolean Change(LinkedList<Symbols> stack, LinkedList<Integer> stack2){
            stack2.pop();
            Symbols num = stack.pop();
            Terminals ee = new Terminals().makeE();
            ee.setMiddle(num);
            ee.setState(0);
            stack.push(ee);
            return false;
        }
    }

    public static class R12 extends SC {
        @Override
        public boolean Change(LinkedList<Symbols> stack, LinkedList<Integer> stack2){
            stack2.pop();
            stack2.pop();
            stack2.pop();
            Symbols cp = stack.pop();
            Symbols a = stack.pop();
            Symbols op = stack.pop();
            Terminals ee = new Terminals().makeE();
            ee.setMiddle(a);
            ee.setLeft(cp);
            ee.setRight(op);
            ee.setState(0);
            stack.push(ee);
            return false;
        }
    }

    public static class Er extends SC {
        @Override
        public boolean Change(LinkedList<Symbols> stack, LinkedList<Integer> stack2) throws Exception {
            throw new Exception("Incorrect sequence of tokens");
        }
    }

    public static class S10 extends SC {
        @Override
        public boolean Change(LinkedList<Symbols> stack, LinkedList<Integer> stack2) {
            stack2.push(10);
            return true;
        }
    }

    public static class S11 extends SC {
        @Override
        public boolean Change(LinkedList<Symbols> stack, LinkedList<Integer> stack2) {
            stack2.push(11);
            return true;
        }
    }

    public static class S12 extends SC {
        @Override
        public boolean Change(LinkedList<Symbols> stack, LinkedList<Integer> stack2) {
            stack2.push(12);
            return true;
        }
    }

    public static class S6 extends SC {
        @Override
        public boolean Change(LinkedList<Symbols> stack, LinkedList<Integer> stack2) {
            stack2.push(6);
            return true;
        }
    }

    public static class S7 extends SC {
        @Override
        public boolean Change(LinkedList<Symbols> stack, LinkedList<Integer> stack2) {
            stack2.push(7);
            return true;
        }
    }

    public static class S8 extends SC {
        @Override
        public boolean Change(LinkedList<Symbols> stack, LinkedList<Integer> stack2) {
            stack2.push(8);
            return true;
        }
    }

    public static class S9 extends SC {
        @Override
        public boolean Change(LinkedList<Symbols> stack, LinkedList<Integer> stack2) {
            stack2.push(9);
            return true;
        }
    }

    public static class S17 extends SC {
        @Override
        public boolean Change(LinkedList<Symbols> stack, LinkedList<Integer> stack2) {
            stack2.push(17);
            return true;
        }
    }

    public static class S18 extends SC {
        @Override
        public boolean Change(LinkedList<Symbols> stack, LinkedList<Integer> stack2) {
            stack2.push(18);
            return true;
        }
    }



}
