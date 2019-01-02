package ru.job4j.loop;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class BoardTest {

    @Test
    public void whenBoard4x4() {
        Board board = new Board();
        String rsl = board.paint(4, 4);
        String ln = System.lineSeparator();
        assertThat(rsl, is(
                String.format("X X %s X X%sX X %s X X%s", ln, ln, ln, ln)
                )
        );
    }
}