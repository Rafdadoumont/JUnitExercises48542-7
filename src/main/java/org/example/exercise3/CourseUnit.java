package org.example.exercise3;

import java.util.ArrayList;
import java.util.List;

public class CourseUnit {
    String name;
    List<Mark> marks;

    int totalStudents;

    public CourseUnit(String name, int totalStudents) {
        this.name = name;
        this.marks = new ArrayList<Mark>();
        this.totalStudents = totalStudents;
    }

    public int getTotalStudents() {
        return totalStudents;
    }

    public List<Mark> getMarks() {
        return marks;
    }

    public void insertMark(Mark mark) {
        marks.add(mark);
    }

    public double searchStudent(int numStudent) {
        for (Mark mark : marks) {
            if (mark.getNumStudent() == numStudent) {
                return mark.getGrade();
            }
        }
        return -1;
    }

    public double averageGrade() {
        double sum = 0;

        for (Mark mark: marks) {
            sum += mark.getGrade();
        }

        return sum / marks.size();
    }

    public boolean isApproved(int numStudent) {
        return 9.5 <= searchStudent(numStudent);
    }
}
