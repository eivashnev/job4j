package ru.job4j.tracker.singleton;

import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;

public class TrackerSingleSFFEL {
    private static final TrackerSingleSFFEL INSTANCE = new TrackerSingleSFFEL();
    private final Tracker tracker;

    private TrackerSingleSFFEL() {
        this.tracker = new Tracker();
    }

    public static TrackerSingleSFFEL getInstance() {
        return INSTANCE;
    }

    /**
     * Добавление заявок
     * @param item
     * @return item
     */
    public Item add(Item item) {
        return tracker.add(item);
    }

    /**
     * Редактирование заявок
     * @param id
     * @param item
     * @return true or false
     */
    public boolean replace(String id, Item item) {
        return tracker.replace(id, item);
    }

    /**
     * Удаление заявок
     * @param id
     * @return true or false
     */
    public boolean delete(String id) {
        return tracker.delete(id);
    }

    /**
     * Получение списка всех заявок
     * @return all items
     */
    public Item[] findAll() {
        return tracker.findAll();
    }

    /**
     * Получение списка по имени
     * @param key
     * @return items by name
     */
    public Item[] findByName(String key) {
        return tracker.findByName(key);
    }

    /**
     * Получение заявки по id
     * @param id
     * @return items by id
     */
    public Item findById(String id) {
        return tracker.findById(id);
    }
}
