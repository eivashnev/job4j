package ru.job4j.oop;

public class Teacher extends Profession {
    private String profession = "Teacher";

    public Teacher(String name) {
        this.setProfession(profession);
        this.setName(name);
    }

    public Skill teach(Student student) {
        return null;
    }
}
