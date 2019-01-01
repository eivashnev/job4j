package ru.job4j.max;

/**
 * Program to find max value.
 *
 * @author Evgeny Ivashnev (zheniog@yandex.ru)
 */
public class Max {
    /**
     * Method finds max from two values.
     *
     * @param first
     * @param second
     * @return max
     */
    public int max(int first, int second) {
        return first > second ? first : second;
    }

    /**
     * Method finds max from three values.
     *
     * @param first
     * @param second
     * @param third
     * @return max
     */
    public int max(int first, int second, int third) {
        return this.max(this.max(first, second), third);
    }
}
