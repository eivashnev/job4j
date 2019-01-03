package ru.job4j.array;

/**
 * Find loop.
 *
 * @author - Evgeny Ivashnev (zheniog@yandex.ru)
 */
public class FindLoop {
    /**
     * Method to find element in array
     *
     * @param data
     * @param el
     * @return index
     */
    public int indexOf(int[] data, int el) {
        int rst = -1; // если элемента нет в массиве, то возвращаем -1.
        for (int index = 0; index < data.length; index++) {
            if (data[index] == el) {
                rst = index;
                break;
            }
        }
        return rst;
    }
}
