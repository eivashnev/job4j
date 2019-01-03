package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class BubbleSortTest {
    @Test
    public void whenSortArrayWithTenElementsThenSortedArray() {
        int[] array     = new int[] {9, 1, 2, 5, 6, 3, 0, 4, 8, 7};
        int[] expected  = new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] result = new BubbleSort().sort(array);
        assertThat(result, is(expected));
    }
}