package ru.job4j.array;


import org.junit.Test;

import static org.hamcrest.collection.IsArrayContainingInAnyOrder.arrayContainingInAnyOrder;
import static org.junit.Assert.assertThat;

public class ArrayDuplicateTest {
    @Test
    public void whenRemoveDuplicatesThenArrayWithoutDuplicate() {
        String[] array = new String[] {"Привет", "Пока", "Пока", "Привет", "Андрей", "Андрей", "Привет"};
        String[] result = new ArrayDuplicate().remove(array);
        String[] expected = new String[] {"Привет", "Пока", "Андрей"};
        assertThat(result, arrayContainingInAnyOrder(expected));
    }
}