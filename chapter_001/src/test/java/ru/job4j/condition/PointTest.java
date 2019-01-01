package ru.job4j.condition;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.number.IsCloseTo.closeTo;

public class PointTest {
    @Test
    public void whenTwoPointsThenDistance() {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(2, 0);
        double result = p1.distanceTo(p2);
        assertThat(result, closeTo(2, 0.1));
    }
}
