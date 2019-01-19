package ru.job4j.tracker;

import ru.job4j.tracker.input.ConsoleInput;
import ru.job4j.tracker.input.Input;

import java.util.ArrayList;
import java.util.List;

/**
 * Tracker Program.
 *
 * @author - Evgeny Ivashnev (zheniog@yandex.ru)
 */
public class StartUI {
    private static final String EXIT = "0";
    private static final String ADD = "1";
    private static final String SHOW_ALL = "2";
    private static final String EDIT = "3";
    private static final String DELETE = "4";
    private static final String FIND_BY_ID = "5";
    private static final String FIND_BY_NAME = "6";

    Input input;
    Tracker tracker;

    public static boolean exit = false;

    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    public void init() {
        MenuTracker menu = new MenuTracker(this.input, this.tracker);
        menu.fillActions();
        while (!exit) {
            menu.show();
            menu.select(Integer.valueOf(input.ask("select: ")));
        }
    }

    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }

}
