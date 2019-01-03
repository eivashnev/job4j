package ru.job4j.array;

/**
 * Matrix check.
 *
 * @author - Evgeny Ivashnev (zheniog@yandex.ru)
 */
public class MatrixCheck {
    /**
     * Method to check if matrix is mono
     *
     * @param data
     * @return true or false
     */
    public boolean mono(boolean[][] data) {
        boolean result = true;
        for (int i = 0; i < data.length - 1; i++) {
            if (data[i][i] != data[i + 1 ][i + 1]
            || data[data.length - 1 - i][data.length - 1 - i] != data[data.length - 2 - i][data.length - 2 - i]) {
                return false;
            }
        }
        return result;
    }
}
