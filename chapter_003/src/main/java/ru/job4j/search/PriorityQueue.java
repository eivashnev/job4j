package ru.job4j.search;

import java.util.LinkedList;

public class PriorityQueue {

    public LinkedList<Task> getTasks() {
        return tasks;
    }

    private LinkedList<Task> tasks = new LinkedList<>();

    /**
     * Метод должен вставлять в нужную позицию элемент.
     * Позиция определять по полю приоритет.
     * Для вставик использовать add(int index, E value)
     * @param newTask задача
     */
    public void put(Task newTask) {
        int index = 0;
        int c = 0;
        int priority = newTask.getPriority();
        for (Task task : tasks) {
            c++;
            if (priority >= task.getPriority()) {
                index = c;
            }
        }
        this.tasks.add(index, newTask);
    }

    public Task take() {
        return this.tasks.poll();
    }
}