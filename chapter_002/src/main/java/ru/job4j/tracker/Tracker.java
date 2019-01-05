package ru.job4j.tracker;

import java.util.Arrays;
import java.util.Random;

public class Tracker {
    private Item[] items = new Item[100];
    private static final Random RN = new Random();
    private int position = 0;

    /**
     * Добавление заявок
     *
     * @param item
     * @return item
     */
    public Item add(Item item) {
        item.setId(generateId());
        items[position++] = item;
        return item;
    }

    /**
     * Редактирование заявок
     *
     * @param id
     * @param item
     * @return true or false
     */
    public boolean replace(String id, Item item) {
        boolean result = false;
        for (int i = 0; i != position; i++) {
            if (items[i].getId().equals(id)) {
                items[i] = item;
                result = true;
                break;
            }
        }
        return result;
    }

    /**
     * Удаление заявок
     *
     * @param id
     * @return true or false
     */
    public boolean delete(String id) {
        boolean result = false;
        for (int i = 0; i != position; i++) {
            if (items[i].getId().equals(id)) {
                System.arraycopy(items, i + 1, items, i, position - i);
                position--;
                result = true;
                break;
            }
        }
        return result;
    }

    /**
     * Получение списка всех заявок
     *
     * @return all items
     */
    public Item[] findAll() {
        return Arrays.copyOf(items, position);
    }

    /**
     * Получение списка по имени
     *
     * @param key
     * @return items by name
     */
    public Item[] findByName(String key) {
        Item[] found = new Item[items.length];
        int n = 0;
        for (int i = 0; i != position; i++) {
            if (items[i].getName().equals(key)) {
                found[n++] = items[i];
            }
        }
        return Arrays.copyOf(found, n);
    }

    /**
     * Получение заявки по id
     *
     * @param id
     * @return items by id
     */
    public Item findById(String id) {
        Item result = null;
        for (int i = 0; i != position; i++) {
            if (items[i].getId().equals(id)) {
                result = items[i];
                break;
            }
        }
        return result;
    }

    private String generateId() {
        return RN.nextInt(1000) + "" + System.currentTimeMillis();
    }

}
