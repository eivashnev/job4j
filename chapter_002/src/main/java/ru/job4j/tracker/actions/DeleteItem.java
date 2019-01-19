package ru.job4j.tracker.actions;

import ru.job4j.tracker.Tracker;
import ru.job4j.tracker.input.Input;

public class DeleteItem implements UserAction {
    private int key;
    private String info;

    public DeleteItem(int key, String info) {
        this.key = key;
        this.info = info;
    }

    @Override
    public int key() {
        return this.key;
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("------------ Deleting item --------------");
        String itemId = input.ask("Enter item ID to delete: ");
        if (tracker.delete(itemId)) {
            System.out.println("\nItem deleted! ID: " + itemId);
        } else {
            System.out.println("\nItem not found! Please check entered ID: " + itemId);
        }
    }

    @Override
    public String info() {
        return this.info;
    }
}
