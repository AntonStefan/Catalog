package com.pachete;

import java.util.*;
import java.util.HashMap;

public abstract class Course {
    public String name;
    private Teacher titular;
    private Integer PC;
    private ArrayList<Assistant> assistants;
    public TreeSet<Grade> grades;
    private HashMap<String, Group> groups;

    public Strategy strategy;

    private Snapshot backup = new Snapshot();
    public void makeBackup() { // TODO1
        try {
            backup.doClone(grades);
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    public void undo() { // TODO2
        grades = backup.getGrades();
    }

  /*  public void undo() {

        for (Grade g : grades) {
            backup.removeGrades(g);
        }
        for (Grade g : grades) {
            grades.add(g);
        }

    }*/

    //din grades in snapshots si dupa din snapshots in grades
    private static class Snapshot
    {
        TreeSet<Grade> gradesClone = new TreeSet<>();

        public Snapshot() {}
        public TreeSet<Grade> getGrades() { return gradesClone; }
        public void doClone ( TreeSet<Grade> grades) throws CloneNotSupportedException {
            for (Grade grade : grades)
            {
                gradesClone.add((Grade)grade.clone());
            }
        }
    }


    /*public Course(String name, Teacher titular, ArrayList<Assistant> assistants, TreeSet<Grade> grades,
                   Integer PC, HashMap<String, Group> groups, Strategy strategy) {
        this.name = name;
        this.titular = titular;
        this.assistants = assistants;
        this.grades = grades;
        this.PC = PC;
        this.groups = groups;
        this.strategy = strategy;
    }*/


    public Course(CourseBuilder cour) {
        this.name = cour.name;
        this.titular = cour.titular;
        this.assistants = cour.assistants;
        this.groups = cour.groups;
        this.grades = cour.grades;
        this.PC = cour.PC;
        this.strategy = cour.strategy;
    }


    public String toString() {
        return "\n" + "Name of course = " + name  + "\n"+
                " teacher firstname = " + titular.getFirstName() +
                ", teacher lastname = " + titular.getLastName() +
                ", group = " +groups + "\n" +
                ", asistenti = " + assistants + "\n" +
                ", grades = " + grades + "\n" +
                ", puncte credit = " + PC +
                '}';
    }

    static abstract class CourseBuilder {
        public Strategy strategy;
        private String name;
        private Teacher titular;
        private ArrayList<Assistant> assistants;
        public TreeSet<Grade> grades;
        private Integer PC;
        private HashMap<String, Group> groups;


        public CourseBuilder(String name) {
            this.name = name;
            assistants = new ArrayList<>();
            grades = new TreeSet<>();
            PC = 0;
            groups = new HashMap<>();
        }

        public CourseBuilder setTitular(Teacher titular) {
            this.titular = titular;
            return this;
        }
        //(ArrayList<Assistant> assistants)
        public CourseBuilder setAssistants(Assistant assistants) {
            this.assistants.add(assistants);
            return this;
        }
//(TreeSet<Grade> grades)
        public CourseBuilder setGrades(Grade grades) {
            this.grades.add(grades);
            return this;
        }

        public CourseBuilder setPC(Integer PC) {
            this.PC = PC;
            return this;
        }
//(HashMap<String, Group> groups)
        public CourseBuilder setGroups(Group groups) {
            this.groups.put(groups.getID(),groups);
            return this;
        }
        public CourseBuilder strategy(Strategy strategy) {
            this.strategy = strategy;
            return this;
        }
        public abstract Course build();
    }



    public void addAssistant(String ID, Assistant assistant) {
            if (groups.containsKey(ID))
            {
                groups.get(ID).setAssistant(assistant);
                return;
            }
            assistants.add(assistant);
    }
    public void addStudent(String ID, Student student) {
        if(groups.containsKey(ID))
            groups.get(ID).getGroup().add(student);
    }

    public void addGroup(Group group) {
        groups.put(group.getID(), group);
    }

    public void addGroup(String ID, Assistant assistant) {
        groups.put(ID,groups.get(assistant));
        assistants.add(assistant);
    }

    private Comparator<Student> comparator;

    public void addGroup(String ID, Assistant assist, Comparator<Student> comp) {
        groups.put(ID,groups.get(comp));
    }

    public int compare ( Object o1 , Object o2) {
        return ( (Student) o1).getLastName().compareTo(( (Student) o2).getLastName());
    }

    public Grade getGrade(Student student){
        for(Grade grade : grades){
            if(grade.getStudent().equals(student)){
                return grade;
            }
        }
        return null;
    }
    public void addGrade(Grade grade) {
        grades.add(grade);
    }

    public ArrayList<Student> getAllStudents() {
        ArrayList<Student> students = new ArrayList<>();
        for(Grade grade : grades){
            students.add(grade.getStudent());
        }
        return students;
    }

    public HashMap<Student, Grade> getAllStudentGrades() {
        HashMap<Student, Grade> studentGrades = new HashMap<>();
        for(Grade grade : grades){
            studentGrades.put(grade.getStudent(), grade);
        }
        return studentGrades;
    }

    public abstract ArrayList<Student> getGraduatedStudents();


    public Student getBestStudent() {
        return strategy.getBestStudent(grades);
    }

}