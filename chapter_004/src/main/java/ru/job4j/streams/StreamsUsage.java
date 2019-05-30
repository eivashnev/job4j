package ru.job4j.streams;

import ru.job4j.streams.school.Student;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsUsage {
    public static class Task {
        private final String name;
        private final long spent;

        public Task(String name, long spent) {
            this.name = name;
            this.spent = spent;
        }

        @Override
        public String toString() {
            return "Task{name='" + name + '\'' + ", spent=" + spent + '}';
        }
    }

    public Map<String, Student> getStudentsMapFromList(List<Student> students) {
        Map<String, Student> studentMap;
        studentMap = students.stream().distinct().collect(Collectors.toMap(
                e -> e.getSurname(),
                e -> e
        ));
        return studentMap;
    }

    public List<Integer> getNumbersListFromMatrix(Integer[][] matrix) {
        List<Integer> integers;
        integers = Stream.of(matrix).flatMap(e -> Stream.of(e)).collect(Collectors.toList());
        return integers;
    }

    public static void main(String[] args) {
        List<Task> tasks = Arrays.asList(
                new Task("Bug #1", 100),
                new Task("Task #2", 100),
                new Task("Bug #3", 100)
        );

        //Filtering
        List<Task> bugs = tasks.stream().filter(
                task -> task.name.contains("Bug")
        ).collect(Collectors.toList());
        bugs.forEach(System.out::println);

        //Mapping(преобразование)
        List<String> names = tasks.stream().map(
                task -> task.name
        ).collect(Collectors.toList());
        names.forEach(System.out::println);

        //Reducing(упрощение)
        long total = tasks.stream().map(
                task -> task.spent
        ).reduce(0L, Long::sum);
        System.out.println("Total: " + total);
        /* Same as below
        long total = 0L;
        for (Task task : tasks) {
           total += task.spent;
        }
        */
    }
}
