package ru.job4j.streams.school;

public class Student {
    public int score;
    public String name;
    public String surname;

    public Student(int score) {
        this.score = score;
    }

    public Student(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
