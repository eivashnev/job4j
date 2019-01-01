package ru.job4j.converter;

/**
 * Корвертор валюты.
 */
public class Converter {

    /**
     * Конвертируем рубли в евро.
     * @param value рубли.
     * @return евро.
     */
    public int rubleToEuro(int value) {
        int euroCost = 70;
        return value / euroCost;
    }

    /**
     * Конвертируем евро в рубли.
     * @param value евро.
     * @return рубли.
     */
    public int euroToRuble(int value) {
        int euroCost = 70;
        return value * euroCost;
    }

    /**
     * Конвертируем рубли в доллары.
     * @param value рубли.
     * @return доллары
     */
    public int rubleToDollar(int value) {
        int dollarCost = 60;
        return value / dollarCost;
    }

    /**
     * Конвертируем доллары в рубли.
     * @param value доллары.
     * @return рубли.
     */
    public int dollarToRuble(int value) {
        int dollarCost = 60;
        return value * dollarCost;
    }
}