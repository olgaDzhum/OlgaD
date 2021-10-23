package Lesson9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
List<Student> students = new ArrayList<>();
students.add(new Student("Olga", Arrays.asList(new Course("Painting"),new Course("Music"),new Course("Economics"))));
        students.add(new Student("Marina", Arrays.asList(new Course("Math"),new Course("Physics"),new Course("Economics"))));
        students.add(new Student("Polina", Arrays.asList(new Course("History"),new Course("Literature"))));
        students.add(new Student("Alexey", Arrays.asList(new Course("Painting"),new Course("Math"),new Course("Economics"),new Course("Geography"))));
        students.add(new Student("Semen", Arrays.asList(new Course("Music"),new Course("Literature"))));
        students.add(new Student("Mark", Arrays.asList(new Course("Physics"))));
        students.add(new Student("Maria", Arrays.asList(new Course("Painting"),new Course("History"),new Course("Literature"),new Course("Arts"))));
        students.add(new Student("Oleg", Arrays.asList(new Course("Music"),new Course("History"),new Course("Literature"),new Course("Arts"))));

        System.out.println("==== задание 1 ====");
        System.out.println();

        System.out.println(students.stream()
        .map(student -> student.getCourses())
        .flatMap(courses -> courses.stream())
        .collect(Collectors.toSet()));
        System.out.println();

        System.out.println("==== задание 2 ====");
        System.out.println();
        System.out.println( students.stream()
                .sorted((s1,s2)-> s2.getCourses().size()- s1.getCourses().size())
                .limit(3)
                .collect(Collectors.toList()));
        System.out.println();


        System.out.println("==== задание 3 ====");
        System.out.println();
Course course= new Course("Painting");
        System.out.println(students.stream()
                .filter(student -> student.getCourses().contains(course))
                .collect(Collectors.toList()));

    }
}
