package com.pachete;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeSet;

public class PartialCourse extends Course{



    public PartialCourse(CourseBuilder cour) {
        super(cour);
    }

    public ArrayList<Student> getGraduatedStudents() {
        ArrayList<Student> promstudents = new ArrayList<>();
        for (Grade grade : grades) {
            if (grade.getTotal() >= 5)
                promstudents.add(grade.getStudent());
        }
        return promstudents;
    }

    public static class PartialCourseBuilder extends Course.CourseBuilder
    {
        public PartialCourseBuilder(String name) {
            super(name);
        }

        public Course build() {
            return new PartialCourse(this);
        }

    }
}
