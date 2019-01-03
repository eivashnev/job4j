package ru.job4j.array;

/**
 * Array of squares
 *
 * @author - Evgeny Ivashnev (zheniog@yandex.ru)
 */
public class Square {
    /**
     * Method to fill array with squares
     *
     * @param bound
     * @return array with squares
     */
    public int[] calculate(int bound) {
        int[] rst = new int[bound];
        // заполнить массив через цикл элементами от 1 до bound возведенными в квадрат
        for(int i = 1; i <= rst.length; i++) {
            rst[i-1] = i * i;
        }
        return rst;
    }
}
