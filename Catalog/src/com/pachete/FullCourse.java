package com.pachete;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeSet;

public class FullCourse extends Course{

  public FullCourse(CourseBuilder cour) {
        super(cour);
    }



    public ArrayList<Student> getGraduatedStudents() {
        ArrayList<Student> promstudents = new ArrayList<>();
        for(Grade grade : grades) {
            if (grade.getExamScore() >= 2 && grade.getPartialScore() >= 3) {
                promstudents.add(grade.getStudent());
            }
        }
        return promstudents;
    }

    public static class FullCourseBuilder extends Course.CourseBuilder
    {
        public FullCourseBuilder(String name) {
            super(name);
        }
        public Course build() {
            return new FullCourse(this);

        }
    }
}
