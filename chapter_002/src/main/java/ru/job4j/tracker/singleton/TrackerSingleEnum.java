package ru.job4j.tracker.singleton;

import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;

public enum TrackerSingleEnum {
    INSTANCE;

    private static final Tracker TRACKER = new Tracker();

    /**
     * Добавление заявок
     * @param item
     * @return item
     */
    public Item add(Item item) {
        return TRACKER.add(item);
    }

    /**
     * Редактирование заявок
     * @param id
     * @param item
     * @return true or false
     */
    public boolean replace(String id, Item item) {
        return TRACKER.replace(id, item);
    }

    /**
     * Удаление заявок
     * @param id
     * @return true or false
     */
    public boolean delete(String id) {
        return TRACKER.delete(id);
    }

    /**
     * Получение списка всех заявок
     * @return all items
     */
    public Item[] findAll() {
        return TRACKER.findAll();
    }

    /**
     * Получение списка по имени
     * @param key
     * @return items by name
     */
    public Item[] findByName(String key) {
        return TRACKER.findByName(key);
    }

    /**
     * Получение заявки по id
     * @param id
     * @return items by id
     */
    public Item findById(String id) {
        return TRACKER.findById(id);
    }
}
