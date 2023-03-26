package com.pachete;

import java.util.ArrayList;

public class Parent extends User implements Observer{

    private ArrayList<Notification> notes;

    public Parent(String firstName, String lastName) {
        super(firstName, lastName);
        notes = new ArrayList<>();
    }

    public void update(Notification notification) {
        notes.add(notification);
    }

    public String toString() {
        return  "Parent{" + " notes = "
                + notes + "} " + super.toString();


    }
}
