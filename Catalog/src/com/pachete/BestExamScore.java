package com.pachete;

import java.util.TreeSet;

public class BestExamScore implements Strategy{

    public Student getBestStudent(TreeSet<Grade> grades) {
        Grade student = grades.first();
        for(Grade grade : grades) {
            if (grade.getExamScore() > student.getExamScore()) {
                student = grade;
            }
        }
        return student.getStudent();
    }
}
