package ru.job4j.tracker.actions;

import ru.job4j.tracker.Tracker;
import ru.job4j.tracker.input.Input;

public class DeleteItem  extends BaseAction {

    public DeleteItem(int key, String info) {
        super(key, info);
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
}
