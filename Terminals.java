import java.util.LinkedList;

public class Terminals extends Symbols{

    public int getInt(){
        return -1;
    }

    public Terminals makeS(){
        return new S();
    }

    public Terminals  makeA(){
        return new A();
    }

    public Terminals  makeB(){ return new B(); }

    public Terminals  makeC(){
        return new C();
    }

    public Terminals  makeD(){
        return new D();
    }

    public Terminals  makeE(){ return new E(); }

    public Terminals makeF(){return new F();}

    public class A extends Terminals{
        public A(){}
        public int getInt(){
            return 0;
        }
    }

    public class B extends Terminals{
        public B(){}
        public int getInt(){
            return 1;
        }
    }

    public class C extends Terminals{
        public C(){ }
        public int getInt(){
            return 2;
        }
    }


    public class D extends Terminals{
        public D(){}
        public int getInt(){
            return 3;
        }
    }

    public static class E extends Terminals{
        public E(){}
        public int getInt(){
            return 4;
        }
    }

    public static class F extends Terminals{
        public F(){}
        public int getInt(){return 5;}
    }

    public class S extends Terminals{
        public S(){}
        public int getInt(){
            return -1;
        }
    }

}
