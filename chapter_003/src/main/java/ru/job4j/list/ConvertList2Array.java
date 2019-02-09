package ru.job4j.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ConvertList2Array {
    public int[][] toArray(List<Integer> list, int rows) {
        int cells = (int) Math.ceil(list.size() / (float) rows);
        int[][] array = new int[rows][cells];
        Iterator<Integer> iterator = list.iterator();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cells; j++) {
                if (iterator.hasNext()) {
                    array[i][j] = iterator.next();
                } else {
                    array[i][j] = 0;
                }
            }
        }

        return array;
    }

    public List<Integer> convert(List<int[]> list) {
        List<Integer> intList = new ArrayList<>();
        for (int[] array : list) {
            for (int i : array) {
                intList.add(i);
            }
        }
        return intList;
    }
}