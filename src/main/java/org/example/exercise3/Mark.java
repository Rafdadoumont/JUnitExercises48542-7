package org.example.exercise3;

public class Mark {
    private double grade;

    private int numStudent;

    public Mark(double grade, int numStudent) {
        this.grade = grade;
        this.numStudent = numStudent;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public int getNumStudent() {
        return numStudent;
    }

    public void setNumStudent(int numStudent) {
        this.numStudent = numStudent;
    }
}
