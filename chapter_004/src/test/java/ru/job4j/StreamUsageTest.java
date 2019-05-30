package ru.job4j;

import org.junit.Test;
import ru.job4j.streams.StreamsUsage;
import ru.job4j.streams.school.Student;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class StreamUsageTest {

    @Test
    public void testCreatingMapFromStrudentsList() {
        Student s1 = new Student("Misha", "Ivanov");
        Student s2 = new Student("Tanya", "Petrova");
        Student s3 = new Student("Sasha", "Griboedov");

        List<Student> students = Arrays.asList(s1, s2, s3);
        Map<String, Student> result = new StreamsUsage().getStudentsMapFromList(students);
        assertThat(result.get("Ivanov"), is(s1));
        assertThat(result.get("Petrova"), is(s2));
        assertThat(result.get("Griboedov"), is(s3));
        assertThat(result.size(), is(students.size()));

    }

}
