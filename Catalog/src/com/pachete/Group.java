package com.pachete;

import com.sun.source.tree.Tree;

import java.util.Comparator;
import java.util.TreeSet;

public class Group extends TreeSet{
    TreeSet<Student> students;
    public String ID;
    public Assistant assistant;

    private Comparator<Student> comparator;

   public Group(String ID, Assistant assistant) {
       this.ID = ID;
       this.assistant =assistant;
   }

   public Group(String ID, Assistant assistant, Comparator<Student> comp) {
       this.ID = ID;
       this.assistant = assistant;
       this.comparator = comp;
   }

    public int compare ( Object o1 , Object o2) {
        return ( (Student) o1).getLastName().compareTo(( (Student) o2).getLastName());
    }

    public String getID() { return ID;}

    public void setID(String ID) { this.ID = ID;}

    public void setAssistant( Assistant assistant) { this.assistant = assistant;}

    public Assistant getAssistant() {
       return assistant;
   }

    public TreeSet<Student> getStudents() {
        return students;
    }

    //(TreeSet<Student> students)

    public void setStudents(TreeSet<Student> students) {
        this.students = students;
    }

    public boolean equals(Object o) {
       if(this == o) {
           return true;
       }
       if(o == null || getClass()!= o.getClass()) {
           return false;
       }
       Group group = (Group) o;
       return this.ID.equals(group.ID);
    }

    public TreeSet<Student> getGroup() {
       return students;
    }

    //

    public void setGroup(TreeSet<Student> students) {this.students = students;}

}
