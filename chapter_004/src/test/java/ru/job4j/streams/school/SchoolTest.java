package ru.job4j.streams.school;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.closeTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SchoolTest {

    private School school = new School();
    Student andrew = new Student(30);
    Student pavel = new Student(40);
    Student olga = new Student(55);
    Student semen = new Student(60);
    Student vika = new Student(75);
    Student tanya = new Student(90);
    private List<Student> students = Arrays.asList(
        andrew, pavel, olga, semen, vika, tanya
    );

    @Test
    public void testClassAStudents() {
        List<Student> aClass = school.collect(students, student -> student.score >= 70);
        List<Student> expected = Arrays.asList(vika, tanya);
        assertThat(aClass, is(expected));
    }

    @Test
    public void testClassBStudents() {
        List<Student> aClass = school.collect(students, student -> (student.score >= 50 && student.score < 70));
        List<Student> expected = Arrays.asList(olga, semen);
        assertThat(aClass, is(expected));
    }

    @Test
    public void testClassVStudents() {
        List<Student> aClass = school.collect(students, student -> student.score < 50);
        List<Student> expected = Arrays.asList(andrew, pavel);
        assertThat(aClass, is(expected));
    }
}
