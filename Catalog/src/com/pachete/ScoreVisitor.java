package com.pachete;

import java.util.ArrayList;
import java.util.HashMap;

public class ScoreVisitor implements Visitor{

    private HashMap<Teacher, ArrayList<Pair<Student, String, Double>>> examScores = new HashMap<>();
    private HashMap<Assistant, ArrayList<Pair<Student, String, Double>>> partialScores;

    public ScoreVisitor(HashMap<Teacher, ArrayList<Pair<Student, String, Double>>> examScores, HashMap<Assistant,
            ArrayList<Pair<Student, String, Double>>> partialScores) {
        this.examScores = examScores;
        this.partialScores = partialScores;
    }

    public void visit(Teacher teacher) {
        ArrayList<Pair<Student, String, Double>> pair = examScores.get(teacher);
        for (Pair<Student, String, Double> pereche : pair) {
            Course course = Catalog.getInstance().getCourse(pereche.getValue1());
            int found = 0;
            for (Grade grade : course.grades) {
                if (grade.getStudent() == pereche.getKey()) {
                    found = 1;
                    grade.setExamScore(pereche.getValue2());
                }
            }
            if (found == 0) {
                Grade note = new Grade(course.name, pereche.getKey());
                note.setExamScore(pereche.getValue2());
                course.grades.add(note);
            }
        }
    }

    public void visit(Assistant assistant) {
        ArrayList<Pair<Student, String, Double>> pair = partialScores.get(assistant);
        for(Pair<Student, String, Double> pereche : pair) {
            Course course = Catalog.getInstance().getCourse(pereche.getValue1());
            int found = 0;
            for (Grade grade : course.grades) {
                if(grade.getStudent() == pereche.getKey()) {
                    found = 1;
                    grade.setPartialScore(pereche.getValue2());
                }
            }
            if( found == 0) {
                Grade note = new Grade(course.name, pereche.getKey());
                note.setPartialScore(pereche.getValue2());
                course.grades.add(note);
            }
        }
    }
}
