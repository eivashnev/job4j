package ru.job4j.tracker;

import org.junit.Test;
import ru.job4j.tracker.singleton.TrackerSingleEnum;
import ru.job4j.tracker.singleton.TrackerSinglePSFCLL;
import ru.job4j.tracker.singleton.TrackerSingleSFFEL;
import ru.job4j.tracker.singleton.TrackerSingleSFLL;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class TrackerSingleTest {

    @Test
    public void whenTrackerSingleEnum() {
        TrackerSingleEnum tracker = TrackerSingleEnum.INSTANCE;
        Item item = new Item("test", "desc");
        tracker.add(item);
        TrackerSingleEnum tracker2 = TrackerSingleEnum.INSTANCE;
        assertThat(tracker2, is(tracker));
    }

    @Test
    public void whenTrackerSinglePSFCLL() {
        TrackerSinglePSFCLL tracker = TrackerSinglePSFCLL.getInstance();
        Item item = new Item("test", "desc");
        tracker.add(item);
        TrackerSinglePSFCLL tracker2 = TrackerSinglePSFCLL.getInstance();
        assertThat(tracker2, is(tracker));
    }

    @Test
    public void whenTrackerSingleSFFEL() {
        TrackerSingleSFFEL tracker = TrackerSingleSFFEL.getInstance();
        Item item = new Item("test", "desc");
        tracker.add(item);
        TrackerSingleSFFEL tracker2 = TrackerSingleSFFEL.getInstance();
        assertThat(tracker2, is(tracker));
    }

    @Test
    public void whenTrackerSingleSFLL() {
        TrackerSingleSFLL tracker = TrackerSingleSFLL.getInstance();
        Item item = new Item("test", "desc");
        tracker.add(item);
        TrackerSingleSFLL tracker2 = TrackerSingleSFLL.getInstance();
        assertThat(tracker2, is(tracker));
    }

}