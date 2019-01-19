package ru.job4j.tracker.actions;

import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;
import ru.job4j.tracker.input.Input;

public class FindItemsByName implements UserAction {
    private int key;
    private String info;

    public FindItemsByName(int key, String info) {
        this.key = key;
        this.info = info;
    }

    @Override
    public int key() {
        return this.key;
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("------------ Find item by name --------------");
        String itemName = input.ask("Enter item name to find: ");
        System.out.println(String.format("\nItems found by name [<%s>]: ", itemName));
        System.out.println("---------------------------------------------");
        for (Item item : tracker.findByName(itemName)) {
            System.out.println(item.toString());
        }
    }

    @Override
    public String info() {
        return this.info;
    }
}
