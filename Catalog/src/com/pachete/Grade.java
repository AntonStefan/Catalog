package com.pachete;

public class Grade implements Comparable,Cloneable{
    private Double partialScore, examScore;
    private Student student;
    private String course;

    public Grade(String course, Student student) {
        this.partialScore = 0.0;
        this.examScore = 0.0;
        this.course = course;
        this.student = student;
    }

    public Grade(Student student, String course, Double partialScore, Double examScore) {
        this.student = student;
        this.course = course;
        this.partialScore = partialScore;
        this.examScore = examScore;
    }

    public Student getStudent() {
        return student;
    }

    public String getCourse() {
        return course;
    }

    public void setPartialScore(Double score) {
        partialScore = score;
    }

    public void setExamScore(Double score) {
        examScore = score;
    }

    public Double getExamScore() {
        return examScore;
    }

    public Double getPartialScore() {
        return partialScore;
    }

    public Double getTotal() {
        return partialScore + examScore;
    }


    public int compareTo(Object o) {
        Grade grade;
        grade = (Grade) o;
        if (getTotal() > this.getTotal()) {
            return 1;
        }
        return -1;
    }

    public Object clone()
            throws CloneNotSupportedException
    {
        return (Grade) super.clone();
    }


    public String toString() {
        return " Grade { " + " partial = " + partialScore + " exam = "
                + examScore + ", Student firstname = " + student.getFirstName() + ", Student lastname = "
                + student.getLastName() + ", mother firstname = " + student.getMotherfirstname() +
                ", mother lastname = " + student.getMotherlastname() +", father firstname = " + student.getFatherfirstname() + ", " +
                ", father lastname = " + student.getFatherlastname() + ", course = "
                + course +  ", mother " + student.getMother() + ", father " + student.getFather() + '\'' + "}";
    }
}
