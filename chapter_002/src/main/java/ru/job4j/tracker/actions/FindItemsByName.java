package ru.job4j.tracker.actions;

import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;
import ru.job4j.tracker.input.Input;

public class FindItemsByName extends BaseAction {

    public FindItemsByName(int key, String info) {
        super(key, info);
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
}
