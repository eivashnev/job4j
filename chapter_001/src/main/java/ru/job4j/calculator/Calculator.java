package ru.job4j.calculator;

/**
 * Calculator program.
 *
 * @author Evgeny Ivashnev (zheniog@yandex.ru)
 */
public class Calculator {
    private double result;

    /**
     * Add operation.
     *
     * @param first
     * @param second
     */
    public void add(double first, double second) {
        this.result = first + second;
    }

    /**
     * Subtract operation.
     *
     * @param first
     * @param second
     */
    public void subtract(double first, double second) {
        this.result = second - first;
    }

    /**
     * Multiply operation.
     *
     * @param first
     * @param second
     */
    public void multiply(double first, double second) {
        this.result = first * second;
    }

    /**
     * Divide operation.
     *
     * @param first
     * @param second
     */
    public void divide(double first, double second) {
        this.result = first / second;
    }

    /**
     * Method returns last operation result.
     *
     * @return result
     */
    public double getResult() {
        return this.result;
    }
}
