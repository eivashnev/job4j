package ru.job4j.oop;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ProfessionTest {
    @Test
    public void whenCreateTeacherThenGetNameAndProfession() {
        String name = "Alena";
        String profession = "Teacher";
        Teacher teacher = new Teacher(name);
        assertThat(teacher.getProfession(), is(profession));
        assertThat(teacher.getName(), is(name));
    }

    @Test
    public void whenCreateDoctorThenGetNameAndProfession() {
        String name = "Eduard";
        String profession = "Doctor";
        Doctor doctor = new Doctor(name);
        assertThat(doctor.getProfession(), is(profession));
        assertThat(doctor.getName(), is(name));
    }

    @Test
    public void whenCreateEngineerThenGetNameAndProfession() {
        String name = "Vasya";
        String profession = "Engineer";
        Engineer engineer = new Engineer(name);
        assertThat(engineer.getProfession(), is(profession));
        assertThat(engineer.getName(), is(name));
    }
}
