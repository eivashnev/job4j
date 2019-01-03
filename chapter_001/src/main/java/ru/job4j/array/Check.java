package ru.job4j.array;

/**
 * Check.
 *
 * @author - Evgeny Ivashnev (zheniog@yandex.ru)
 */
public class Check {
    /**
     * Method to check that all elements of array are true or false
     *
     * @param data
     * @return true - if all elements are same (true or false)
     * @return false - if elements are not same
     */
    public boolean mono(boolean[] data) {
        boolean result = true;
        for (int i = 0; i < data.length - 1; i++) {
            if (data[i] != data[i + 1]) {
                return false;
            }
        }
        return result;
    }
}
