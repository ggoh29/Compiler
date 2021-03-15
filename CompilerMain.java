import Pipe.Pipeline;

import java.util.Scanner;


public class CompilerMain {

    public static void main(String[] args) throws Exception {
//        Scanner sc = new Scanner(System.in);
//        String inputStr = sc.nextLine();
        String inputStr = "cossin0.5 - 2 ^3 ^-2";
        Pipeline p = new Pipeline();
        float result = p.pipe(inputStr);
        System.out.println(result);
    }
}