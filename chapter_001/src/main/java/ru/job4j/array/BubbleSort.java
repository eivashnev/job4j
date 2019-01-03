package ru.job4j.array;

/**
 * Bubblesort.
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
        for (int j : array) {
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    int tmp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = tmp;
                }
            }
        }
        return array;
    }
}
