package ru.job4j.tracker.actions;

import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;
import ru.job4j.tracker.input.Input;

public class FindItemById extends BaseAction {

    public FindItemById(int key, String info) {
        super(key, info);
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
}
