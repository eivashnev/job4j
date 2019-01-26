package ru.job4j.tracker.actions;

import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;
import ru.job4j.tracker.input.Input;

public class ShowItems extends BaseAction {

    public ShowItems(int key, String info) {
        super(key, info);
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("------------ All items --------------");
        for (Item item : tracker.findAll()) {
            System.out.println(item.toString());
        }
    }
}
