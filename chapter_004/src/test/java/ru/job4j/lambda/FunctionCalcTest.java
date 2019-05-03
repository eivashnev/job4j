package ru.job4j.lambda;

import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.closeTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class FunctionCalcTest {
    @Test
    public void whenLinearFunctionThenLinearResults() {
        FunctionCalc functionCalc = new FunctionCalc();
        List<Double> result = functionCalc.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenSquareFunctionThenSquareResults() {
        FunctionCalc functionCalc = new FunctionCalc();
        List<Double> result = functionCalc.diapason(1, 4, x -> x * x + 1);
        List<Double> expected = Arrays.asList(2D, 5D, 10D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenLogFunctionThenLogResults() {
        FunctionCalc functionCalc = new FunctionCalc();
        List<Double> result = functionCalc.diapason(2, 5, x -> Math.log(x) + 1);
        List<Double> expected = Arrays.asList(1.7, 2.1, 2.4);
        for (int i = 0; i < result.size(); i++) {
            assertThat(result.get(i), closeTo(expected.get(i), 0.1));
        }
    }
}
