package ru.job4j.array;

/**
 * Turn array.
 *
 * @author - Evgeny Ivashnev (zheniog@yandex.ru)
 */
public class Turn {
    /**
     * Method to turn array
     *
     * @param array
     * @return reversed array
     */
    public int[] back(int[] array) {
        int tmp;
        int l = array.length;
        for (int i = 0; i < l/2; i++) {
            tmp = array[i];
            array[i] = array[l - 1 - i];
            array[l - 1 - i] = tmp;
        }
        return array;
    }
}
