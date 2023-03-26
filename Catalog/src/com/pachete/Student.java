package com.pachete;

public class Student extends User{
    public Parent father;
    public Parent mother;

    public Student(String fistName, String lastName) {
        super(fistName,lastName);
    }

    public Parent getFather() {
        return father;
    }

    public String getFatherfirstname() {
        return father.getFirstName();
    }

    public String getFatherlastname() {
        return father.getLastName();
    }

    public String getMotherfirstname() {
        return mother.getFirstName();
    }

    public String getMotherlastname() {
        return mother.getLastName();
    }

    public void setFather(Parent father) {
        this.father = father;
    }

    public Parent getMother() {
        return mother;
    }

    public void setMother(Parent mother) {
        this.mother = mother;
    }
}
