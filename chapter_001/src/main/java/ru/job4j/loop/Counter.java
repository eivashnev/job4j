package ru.job4j.loop;

/**
 * Counter.
 *
 * @author Evgeny Ivashnev (zheniog@yandex.ru)
 */
public class Counter {

    /**
     * Method to find a sum of even numbers in selected diapason
     *
     * @param start
     * @param finish
     * @return sum
     */
    public int add(int start, int finish) {
        int sum = 0;

        for (int i = start; i <= finish; i++) {
            if ((i % 2) == 0) {
                sum += i;
            }
        }
        return sum;
    }
}
