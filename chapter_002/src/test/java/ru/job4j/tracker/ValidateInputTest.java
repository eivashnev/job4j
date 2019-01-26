package ru.job4j.tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.job4j.tracker.input.StubInput;
import ru.job4j.tracker.input.ValidateInput;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Tests for ValidateInput.
 *
 * @author - Evgeny Ivashnev (zheniog@yandex.ru)
 */
public class ValidateInputTest {
    private final ByteArrayOutputStream mem = new ByteArrayOutputStream();
    private final PrintStream out = System.out;

    @Before
    public void loadMem() {
        System.setOut(new PrintStream(this.mem));
    }

    @After
    public void loadSys() {
        System.setOut(this.out);
    }

    @Test
    public void whenInvalidInputNotInRange() {
        ValidateInput input = new ValidateInput(
                new StubInput(new String[] {"5", "1"})
        );
        input.ask("Enter", new int[] {1});
        assertThat(
                this.mem.toString(),
                is(
                        String.format("Please select menu option in range.%n")
                )
        );
    }
    @Test
    public void whenInvalidInputNotNumber() {
        ValidateInput input = new ValidateInput(
                new StubInput(new String[] {"invalid", "1"})
        );
        input.ask("Enter", new int[] {1});
        assertThat(
                this.mem.toString(),
                is(
                        String.format("Please input a number.%n")
                )
        );
    }

    @Test
    public void whenValidInput() {
        ValidateInput input = new ValidateInput(
                new StubInput(new String[] {"3"})
        );
        int result = input.ask("Enter", new int[] {0, 1, 2, 3});
        assertThat(
                this.mem.toString(),
                is(
                        String.format("")
                )
        );
        assertThat(result, is(3));
    }
}