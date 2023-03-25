package com.ramesh.java8.lambda;

import java.util.Arrays;
import java.util.List;

public class DifferentWaysListIterateProgram {
    public static void main(String[] args) {
        List<String> courses = Arrays.asList("C", "C++", "J2EE", "Hibernate", "Python");

        courses.stream().forEach(c -> printCourse(c));
        courses.stream().forEach(DifferentWaysListIterateProgram::printCourse);
        courses.forEach(c -> printCourse(c));
        courses.forEach(DifferentWaysListIterateProgram::printCourse);
    }

    private static void printCourse(String c) {
        System.out.println("Course name: " + c);
    }
}
