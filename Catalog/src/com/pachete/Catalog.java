package com.pachete;

import java.util.ArrayList;
public class Catalog implements Subject{
    public ArrayList<Course> courses;
    public ArrayList<Observer> observers;

    private static Catalog instance = new Catalog();

    private Catalog() {
        courses = new ArrayList<>();
        observers = new ArrayList<>();
    }

    public static Catalog getInstance() {
        return instance;
    }

        public void addCourse(Course course) {courses.add(course);}

        public void removeCourse(Course course) {
            courses.remove(course);
        }


    @Override
    public String toString() {
        return "Catalog are cursurile" + "\n"
                 + courses +
                '}';
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(Grade grade) {
        for (Observer o: observers) {
            if(grade.getStudent().getMother() == o) {

                o.update(new Notification(grade));
            }
            if(grade.getStudent().getFather() == o) {
                o.update(new Notification(grade));
            }
        }
    }
    public Course getCourse(String name) {
        for (Course cours: courses) {
            if(cours.name.equals(name)) {
                return cours;
            }
        }
        return null;
    }
}








