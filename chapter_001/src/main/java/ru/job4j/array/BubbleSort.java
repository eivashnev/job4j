package ru.job4j.array;

import java.util.Arrays;

/**
 * Bubble sort.
 *
 * @author - Evgeny Ivashnev (zheniog@yandex.ru)
 */
public class BubbleSort {
    /**
     * Bubble sort method
     * @param array
     * @return sorted array
     */
    public int[] sort(int[] array) {
        for( int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                }
            }
        }
        return array;
    }
}
