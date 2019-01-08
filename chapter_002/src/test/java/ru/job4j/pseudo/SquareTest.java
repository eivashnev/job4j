package ru.job4j.pseudo;

import org.junit.Test;

import java.util.StringJoiner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SquareTest {

    @Test
    public void drawSquare() {
        Shape square = new Square();
        String result = square.draw();
        String expected = new StringJoiner(System.lineSeparator(), "", "")
                .add("+ + + +")
                .add("+     +")
                .add("+     +")
                .add("+ + + +").toString();
        assertThat(result, is(expected));
    }
}