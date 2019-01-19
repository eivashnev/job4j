package ru.job4j.tracker.actions;

import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;
import ru.job4j.tracker.input.Input;

public class FindItemById implements UserAction {
    private int key;
    private String info;

    public FindItemById(int key, String info) {
        this.key = key;
        this.info = info;
    }

    @Override
    public int key() {
        return this.key;
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("------------ Find item by id --------------");
        String itemId = input.ask("Enter item ID to find: ");
        Item foundItem = tracker.findById(itemId);
        if (foundItem != null) {
            System.out.println("\nItem found: " + foundItem);
        } else {
            System.out.println("\nItem not found!");
        }
    }

    @Override
    public String info() {
        return this.info;
    }
}
