package ru.job4j.tracker.actions;

import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;
import ru.job4j.tracker.input.Input;

public class ShowItems implements UserAction {
    private int key;
    private String info;

    public ShowItems(int key, String info) {
        this.key = key;
        this.info = info;
    }

    @Override
    public int key() {
        return this.key;
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("------------ All items --------------");
        for (Item item : tracker.findAll()) {
            System.out.println(item.toString());
        }
    }

    @Override
    public String info() {
        return this.info;
    }
}
