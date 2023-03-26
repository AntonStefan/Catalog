package com.pachete;

import java.util.ArrayList;
import java.util.TreeSet;
import java.util.HashMap;

class Test {
    public static void main(String[] args) {
        Grade test1;

        HashMap<Student, Grade> grades = new HashMap<Student, Grade>();

        ArrayList<Student> students = new ArrayList<Student>();
        ArrayList<Student> promstudents = new ArrayList<Student>();

        Student stud1 = new Student("Andra", "Matei");
        Student stud2 = new Student("Sebastian ", "Luca");
        Student stud3 = new Student("Cazemira", "Evelina");
        Student stud4 = new Student("Anca", "Circioroaba");
        Student stud5 = new Student("Anton", "Stefan");

        Assistant ass1 = new Assistant("Luca", "Walker");
        Assistant ass2 = new Assistant("Padawin", "Kay");
        Assistant ass3 = new Assistant("Roger", "Frederick");
        Assistant ass4 = new Assistant("Baboon", "Poloski");
        Assistant ass5 = new Assistant("Geani", "Nebunu");
        Assistant ass6 = new Assistant("Ianis", "Hagi");

        Teacher teacher3 = new Teacher("Costache", "Luminita");
        Teacher teacher4 = new Teacher("Ionel", "Ion");

        Parent par1 = new Parent("Hans", "Solo");
        Parent par2 = new Parent("Mikaela", "Solo");
        Parent par3 = new Parent("Michael","Jackson");
        Parent par4 = new Parent("Mary","Jane");
        Parent par5 = new Parent("Bob","Ion");
        Parent par6 = new Parent("Carla","Bubi");
        Parent par7 = new Parent("Ancuta", "Circio");
        Parent par8 = new Parent("Rosoga", "Radu");

        Group group1 = new Group("315CA", ass5);
        Group group2 = new Group("211C", ass6);

        Grade grade1 = new Grade(stud5, "315CA=[]", 4.0, 5.0);


        //testare exerc --------1.2.2--------
        stud1.setMother(par2);
        stud1.setFather(par1);
        stud2.setFather(par3);
        stud2.setMother(par4);
        stud3.setFather(par5);
        stud3.setMother(par6);
        stud4.setFather(par8);
        stud4.setMother(par7);
        stud5.setFather(par8);
        stud5.setMother(par7);


        //testare exerc --------1.2----------
        User mother = UserFactory.createUser("Parent", "Mikaela", "Solo");
        User father = UserFactory.createUser("Parent", "Hans", "Solo");


        //testare exercitiu ---------1.3------- +1.7------------
        Course course1 = new PartialCourse.PartialCourseBuilder("POO")
                .setTitular(teacher3)
                .setAssistants(ass1)
                .setGroups(new Group("321CC", ass1))
                .setGrades(new Grade(stud1, "POO", 1d, 3d))
                .setGrades(new Grade(stud2, "POO", 1d, 3d))
                .setGrades(new Grade(stud3, "POO", 3d, 4d))
                .setGrades(new Grade(stud4, "POO", 2d, 4d))
                .setPC(5).strategy(new BestPartialScore())
                .build();


        // testare exerc --------1.5--------
        course1.addAssistant("321CC=[]", ass2);
        course1.addStudent("321CC=[]", stud5);
        course1.addGroup(group1);
        course1.addGroup("211C=[]", ass6);
        test1 = course1.getGrade(stud4);
        course1.addGrade(grade1);

        students = course1.getAllStudents();
        grades = course1.getAllStudentGrades();
        promstudents = course1.getGraduatedStudents();

        System.out.println("TYPE PARTIALCOURSE");

        System.out.println("\n" + "Toti studentii " + students);
        System.out.println("\n" + "Notele tuturor studentilor " + grades + "\n");
        System.out.println("Graduated students = " + promstudents + "\n");

        System.out.println("Course: " + course1);
        System.out.println("Best Student: " + grades + "\n");



        Course course2 = new FullCourse.FullCourseBuilder("Utilizarea avansata a flautului")
                .setTitular(teacher4)
                .setAssistants(ass3).setAssistants(ass4)
                .setGroups(new Group("341CC", ass3))
                .setGrades(new Grade(stud1, "Utilizarea avansata a flautului", 2d, 3d))
                .setGrades(new Grade(stud2, "Utilizarea avansata a flautului", 1d, 5d))
                .setGrades(new Grade(stud3, "Utilizarea avansata a flautului", 3d, 4d))
                .setGrades(new Grade(stud4, "Utilizarea avansata a flautului", 2d, 4d))
                .setPC(2).strategy(new BestExamScore())
                .build();

        System.out.println("TYPE FULLCOURSE");

        System.out.println("\n" + "Course: " + course2);
        System.out.println("Best Student: " + course2.getBestStudent() + "\n");

        //testare exerc -------1.1----------
        Catalog catalog = Catalog.getInstance();
        catalog.addCourse(course1);
        catalog.addCourse(course2);
        System.out.println("\n" + "Catalog: " + catalog);

        //catalog.removeCourse(course1);
        System.out.println("\n" + "Catalog: " + catalog);

        //Returneaza nota unui student sau null
        System.out.println("\n" + "Nota studentului returnata este   " + test1.getTotal() + "\n");


        //testare exerc ----------1.6-----------------

        catalog.addObserver((Parent) mother);
        catalog.addObserver((Parent) father);
        catalog.notifyObservers(new Grade((Student) stud1, "POO", 2.5d, 3d));
        System.out.println(mother);
        System.out.print(father + "\n" );


        //testare exercitiu --------1.9----------------
        Student z1 = new Student("Marius","Iordache");
       Course course3 = new PartialCourse.PartialCourseBuilder("SDA")
               .setTitular(teacher3)
               .setAssistants(ass1)
               .setGrades(new Grade(stud1, "SDA", 4d, 4d))
                .setGrades(new Grade(stud2, "SDA", 1d, 3d))
               .setGrades(new Grade(stud3, "SDA", 3d, 4d))
               .setPC(3)
               .setGroups(new Group( "***",ass3))
               .build();

       course3.makeBackup();
        System.out.println(course3 + "\n");

       course3.addGrade(new Grade(stud4,"SDA",3d,1d));
       System.out.println(course3);
        course3.undo();
       System.out.println(course3 + "\n");




        //testare exercitiu 1.8  ---- ne putem uita la Andra Matei(stud1) a carei nota din examen s-a schimbat la 3.6
        HashMap<Teacher, ArrayList<Pair<Student, String, Double>>> examScores=new HashMap<>();
        ArrayList<Pair<Student, String, Double>> ar1=new ArrayList<>();
        ar1.add(new Pair<>(stud1,"POO",3.6d));
        ar1.add(new Pair<>(stud2, "POO",4.3d));
        ar1.add(new Pair<>(stud4, "POO", 2d));
        examScores.put(teacher3,ar1);

        HashMap<Assistant, ArrayList<Pair<Student, String, Double>>> partialScores= new HashMap<>();
        ArrayList<Pair<Student, String, Double>> ar2=new ArrayList<>();
        ar2.add(new Pair<>(stud2, "POO",3.6d));
        ar2.add(new Pair<>(stud5,"POO",4d));
        ar2.add(new Pair<>(stud3,"POO",2.5d));
        partialScores.put(ass3,ar2);

        Visitor v=new ScoreVisitor(examScores,partialScores);

        v.visit((Teacher)teacher3);
        System.out.println("Actualizare teacher:" + catalog);

        v.visit((Assistant)ass3);
        System.out.println("Actualizare assistant:" + catalog);

    }

}