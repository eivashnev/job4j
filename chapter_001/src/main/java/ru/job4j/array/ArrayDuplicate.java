package ru.job4j.array;

import java.util.Arrays;

/**
 * Program to remove duplicates from array
 *
 * @author - Evgeny Ivashnev (zheniog@yandex.ru)
 */
public class ArrayDuplicate {

    /**
     * Method removes duplicates from array
     * @param array
     * @return array w/o duplicates
     */
    public String[] remove(String[] array) {
        int last = array.length - 1;
        int dups = 0;

        for (int i = 0; i <= last; i++) {
            for (int j = i + 1; j <= last; j++) {
                if (array[i].equals(array[j])) {
                    array[j] = array[last];
                    dups++;
                    last--;
                    j--;
                }
            }
        }
        return Arrays.copyOf(array, array.length - dups);
    }

}
