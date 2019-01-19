package ru.job4j.tracker.actions;

import ru.job4j.tracker.Tracker;
import ru.job4j.tracker.input.Input;

public interface UserAction {
    /**
     * Method returns option's key.
     * @return key
     */
    int key();

    /**
     * Method performs action
     * @param input - Input type
     * @param tracker - Tracker object
     */
    void execute(Input input, Tracker tracker);

    /**
     * Displays action's details
     * @return info
     */
    String info();
}
