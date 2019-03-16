package ru.job4j.comparator;

import java.util.Comparator;

public class ListCompare implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        int result = 0;
        int min = o1.length() < o2.length() ? o1.length() : o2.length();

        for (int i = 0; i < min; i++) {
            result = Character.compare(o1.charAt(i), o2.charAt(i));
            if (result != 0) {
                break;
            }
        }
        return result != 0 ? result : Integer.compare(o1.length(), o2.length());
    }
}
