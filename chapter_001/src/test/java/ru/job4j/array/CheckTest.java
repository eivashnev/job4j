package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class CheckTest {

    @Test
    public void whenDataMonoByTrueThenTrueOdd() {
        Check check = new Check();
        boolean[] input = new boolean[] {true, true, true};
        boolean result = check.mono(input);
        assertThat(result, is(true));
    }

    @Test
    public void whenDataNotMonoByTrueThenFalseOdd() {
        Check check = new Check();
        boolean[] input = new boolean[] {true, true, false};
        boolean result = check.mono(input);
        assertThat(result, is(false));
    }

    @Test
    public void whenDataMonoByTrueThenTrueEven() {
        Check check = new Check();
        boolean[] input = new boolean[] {false, false, false, false};
        boolean result = check.mono(input);
        assertThat(result, is(true));
    }

    @Test
    public void whenDataNotMonoByTrueThenFalseEven() {
        Check check = new Check();
        boolean[] input = new boolean[] {false, false, false, true};
        boolean result = check.mono(input);
        assertThat(result, is(false));
    }
}