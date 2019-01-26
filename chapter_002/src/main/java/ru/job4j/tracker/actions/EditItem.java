package ru.job4j.tracker.actions;

import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;
import ru.job4j.tracker.input.Input;

public class EditItem extends BaseAction {

    public EditItem(int key, String info) {
        super(key, info);
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("------------ Editing item --------------");
        String itemId = input.ask("Enter item ID to change: ");
        String itemName = input.ask("Enter new item name: ");
        String itemDesc = input.ask("Enter new item description: ");
        Item newItem = new Item(itemName, itemDesc);

        if (tracker.replace(itemId, newItem)) {
            newItem.setId(itemId);
            System.out.println("\nItem edited! ID: " + itemId);
        } else {
            System.out.println("\nItem not found! Please check entered ID: " + itemId);
        }
    }
}
