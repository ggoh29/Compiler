package Test;
import Pipe.Pipeline;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Test;

public class CompilerTest {

    private Pipeline pipe = new Pipeline();

    public boolean roughlyEqual(float a, float b){
        return (Math.abs(b - a) < Math.pow(10, -5));
    }

    @Test
    public void testAddition() throws Exception {

        String inputStr = "2 + 2";

        float result = Pipeline.pipe(inputStr);

        boolean roughlyEqual = roughlyEqual(result, 4f);

        assertTrue(roughlyEqual);
    }


    @Test
    public void testSubtraction() throws Exception {

        String inputStr = "5 - 3";

        float result = Pipeline.pipe(inputStr);

        boolean roughlyEqual = roughlyEqual(result, 2f);

        assertTrue(roughlyEqual);
    }

    @Test
    public void testMultiplication() throws Exception {

        String inputStr = "5 *-3";

        float result = Pipeline.pipe(inputStr);

        boolean roughlyEqual = roughlyEqual(result, -15f);

        assertTrue(roughlyEqual);
    }

    @Test
    public void testDivision() throws Exception {

        String inputStr = "-6 /(3)";

        float result = Pipeline.pipe(inputStr);

        boolean roughlyEqual = roughlyEqual(result, -2f);

        assertTrue(roughlyEqual);
    }

    @Test
    public void testLog() throws Exception {

        String inputStr = "log5";

        float result = Pipeline.pipe(inputStr);

        boolean roughlyEqual = roughlyEqual(result, 1.6094379f);

        assertTrue(roughlyEqual);
    }


    @Test
    public void testSin() throws Exception {

        String inputStr = "sin0.5";

        float result = Pipeline.pipe(inputStr);

        boolean roughlyEqual = roughlyEqual(result, 0.47942f);

        assertTrue(roughlyEqual);
    }

    @Test
    public void mutipleOperators1() throws Exception {

        String inputStr = "cossin0.5 - 2 ^3 ^-2";

        float result = Pipeline.pipe(inputStr);

        System.out.println(result);

        boolean roughlyEqual = roughlyEqual(result, -0.192799f);

        assertTrue(roughlyEqual);
    }
}
