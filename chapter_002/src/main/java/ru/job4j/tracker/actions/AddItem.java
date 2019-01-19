package ru.job4j.tracker.actions;

import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;
import ru.job4j.tracker.input.Input;

public class AddItem implements UserAction {
    private int key;
    private String info;

    public AddItem(int key, String info) {
        this.key = key;
        this.info = info;
    }

    @Override
    public int key() {
        return this.key;
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("------------ Adding new item --------------");
        String taskName = input.ask("Enter item name: ");
        String taskDesc = input.ask("Enter item description: ");
        Item item = new Item(taskName, taskDesc);
        tracker.add(item);
        System.out.println("\nAdded item: " + item.toString());
    }

    @Override
    public String info() {
        return this.info;
    }
}
