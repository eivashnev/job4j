package ru.job4j.loop;

/**
 * Factorial.
 *
 * @author Evgeny Ivashnev (zheniog@yandex.ru)
 */
public class Factorial {

    /**
     * Method to find the factorial of a number.
     *
     * @param n - number
     * @return f - factorial
     */
    int calc(int n) {
        int f = 1;
        for (int i = 1; i <= n; i++) {
            f *= i;
        }
        return f;
    }
}
