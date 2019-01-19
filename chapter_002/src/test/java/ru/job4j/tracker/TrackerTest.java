package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TrackerTest {
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "testDescription");
        tracker.add(item);
        assertThat(tracker.findAll()[0], is(item));
    }

    @Test
    public void whenItemFoundByName() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("test1", "testDescription");
        Item item2 = new Item("test2", "testDescription");
        Item item3 = new Item("test3", "testDescription");
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        assertThat(tracker.findByName("test3")[0], is(item3));
    }

    @Test
    public void whenItemFoundById() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("test1", "testDescription");
        Item item2 = new Item("test2", "testDescription");
        tracker.add(item1);
        tracker.add(item2);
        assertThat(tracker.findById(item1.getId()), is(item1));
    }

    @Test
    public void whenDeleteItemDeleted() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("test1", "testDescription");
        Item item2 = new Item("test2", "testDescription");
        Item item3 = new Item("test3", "testDescription");
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        tracker.delete(item3.getId());
        Item[] expected = new Item[] {item1, item2};
        assertThat(tracker.findAll(), is(expected));
    }

    @Test
    public void whenReplaceNameThenReturnNewName() {
        Tracker tracker = new Tracker();
        Item previous = new Item("test1", "testDescription");
        // Добавляем заявку в трекер. Теперь в объект проинициализирован id.
        tracker.add(previous);
        // Создаем новую заявку.
        Item next = new Item("test2", "testDescription2");
        // Проставляем старый id из previous, который был сгенерирован выше.
        next.setId(previous.getId());
        // Обновляем заявку в трекере.
        tracker.replace(previous.getId(), next);
        // Проверяем, что заявка с таким id имеет новые имя test2.
        assertThat(tracker.findById(previous.getId()).getName(), is("test2"));
    }


}
