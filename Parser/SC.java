package Parser;

import Lexer.tokens.Number;
import Lexer.tokens.Symbols;

import java.util.LinkedList;

public class SC {

    public boolean Change (LinkedList<Symbols> stack, LinkedList<Integer> stack2) throws Exception {return false;}

    public static class R00 extends SC {
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

    public static class R01 extends SC {
        @Override
        public boolean Change (LinkedList<Symbols> stack, LinkedList<Integer> stack2){
            stack2.pop();
            stack2.pop();
            stack2.pop();
            Symbols a = stack.pop();
            Symbols plus = stack.pop();
            Symbols b = stack.pop();
            Terminals aa = new Terminals().makeA();
            aa.setLeft(a);
            aa.setRight(b);
            aa.setOperator(plus);
            aa.setState(3);
            stack.push(aa);
            return false;
        }
    }


    public static class R02 extends SC {
        @Override
        public boolean Change (LinkedList<Symbols> stack, LinkedList<Integer> stack2){
            stack2.pop();
            stack2.pop();
            stack2.pop();
            Symbols a = stack.pop();
            Symbols minus = stack.pop();
            Symbols b = stack.pop();
            Terminals bb = new Terminals().makeB();
            bb.setLeft(a);
            bb.setRight(b);
            bb.setOperator(minus);
            bb.setState(3);
            stack.push(bb);
            return false;
        }
    }


    public static class R03 extends SC {
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


    public static class R04 extends SC {
        @Override
        public boolean Change (LinkedList<Symbols> stack, LinkedList<Integer> stack2){
            stack2.pop();
            stack2.pop();
            stack2.pop();
            Symbols b = stack.pop();
            Symbols minus = stack.pop();
            Symbols c = stack.pop();
            Terminals bb = new Terminals().makeB();
            bb.setLeft(b);
            bb.setRight(c);
            bb.setOperator(minus);
            bb.setState(3);
            stack.push(bb);
            return false;
        }
    }


    public static class R05 extends SC {
        @Override
        public boolean Change (LinkedList<Symbols> stack, LinkedList<Integer> stack2){
            stack2.pop();
            stack2.pop();
            stack2.pop();
            Symbols c = stack.pop();
            Symbols div = stack.pop();
            Symbols b = stack.pop();
            Terminals cc = new Terminals().makeC();
            cc.setLeft(b);
            cc.setRight(c);
            cc.setOperator(div);
            cc.setState(3);
            stack.push(cc);
            return false;
        }
    }


    public static class R06 extends SC {
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


    public static class R07 extends SC {
        @Override
        public boolean Change (LinkedList<Symbols> stack, LinkedList<Integer> stack2){
            stack2.pop();
            stack2.pop();
            stack2.pop();
            Symbols d = stack.pop();
            Symbols p = stack.pop();
            Symbols c = stack.pop();
            Terminals cc = new Terminals().makeC();
            cc.setLeft(c);
            cc.setRight(d);
            cc.setOperator(p);
            cc.setState(3);
            stack.push(cc);
            return false;
        }
    }

    public static class R08 extends SC {
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

    public static class R09 extends SC {
        @Override
        public boolean Change (LinkedList<Symbols> stack, LinkedList<Integer> stack2){
            stack2.pop();
            stack2.pop();
            Symbols d = stack.pop();
            Symbols trig = stack.pop();
            Terminals dd = new Terminals().makeD();
            dd.setOperator(trig);
            dd.setRight(d);
            dd.setState(2);
            stack.push(dd);
            return false;
        }
    }


    public static class R10 extends SC {
        @Override
        public boolean Change(LinkedList<Symbols> stack, LinkedList<Integer> stack2) {
            stack2.pop();
            stack2.pop();
            Symbols d = stack.pop();
            Symbols log = stack.pop();
            Terminals dd = new Terminals().makeD();
            dd.setOperator(log);
            dd.setRight(d);
            dd.setState(2);
            stack.push(dd);
            return false;
        }
    }

    public static class R11 extends SC {
        @Override
        public boolean Change(LinkedList<Symbols> stack, LinkedList<Integer> stack2){
            stack2.pop();
            Symbols e = stack.pop();
            Terminals dd = new Terminals().makeD();
            dd.setMiddle(e);
            dd.setState(0);
            stack.push(dd);
            return false;
        }
    }

    public static class R12 extends SC {
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

    public static class R13 extends SC {
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

    public static class R14 extends SC {
        @Override
        public boolean Change(LinkedList<Symbols> stack, LinkedList<Integer> stack2){
            stack2.pop();
            stack2.pop();
            Symbols e = stack.pop();
            Symbols minus = stack.pop();
            Number t = new Number("0");
            Terminals ee = new Terminals().makeE();
            ee.setLeft(e);
            ee.setRight(t);
            ee.setState(3);
            ee.setOperator(minus);
            stack.push(ee);
            return false;
        }
    }

    public static class Err extends SC {
        @Override
        public boolean Change(LinkedList<Symbols> stack, LinkedList<Integer> stack2) throws Exception {
            throw new Exception("Incorrect sequence of tokens");
        }
    }

    public static class S05 extends SC {
        @Override
        public boolean Change(LinkedList<Symbols> stack, LinkedList<Integer> stack2) {
            stack2.push(5);
            return true;
        }
    }

    public static class S06 extends SC {
        @Override
        public boolean Change(LinkedList<Symbols> stack, LinkedList<Integer> stack2) {
            stack2.push(6);
            return true;
        }
    }

    public static class S08 extends SC {
        @Override
        public boolean Change(LinkedList<Symbols> stack, LinkedList<Integer> stack2) {
            stack2.push(8);
            return true;
        }
    }

    public static class S09 extends SC {
        @Override
        public boolean Change(LinkedList<Symbols> stack, LinkedList<Integer> stack2) {
            stack2.push(9);
            return true;
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

    public static class S13 extends SC {
        @Override
        public boolean Change(LinkedList<Symbols> stack, LinkedList<Integer> stack2) {
            stack2.push(13);
            return true;
        }
    }

    public static class S14 extends SC {
        @Override
        public boolean Change(LinkedList<Symbols> stack, LinkedList<Integer> stack2) {
            stack2.push(14);
            return true;
        }
    }

    public static class S15 extends SC {
        @Override
        public boolean Change(LinkedList<Symbols> stack, LinkedList<Integer> stack2) {
            stack2.push(15);
            return true;
        }
    }

    public static class S25 extends SC {
        @Override
        public boolean Change(LinkedList<Symbols> stack, LinkedList<Integer> stack2) {
            stack2.push(25);
            return true;
        }
    }



}
