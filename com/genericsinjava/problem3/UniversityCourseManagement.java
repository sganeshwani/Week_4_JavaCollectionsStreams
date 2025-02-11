package com.genericsinjava.problem3;

import java.util.*;

// Abstract Class Representing Course Type
abstract class CourseType {
    private String courseName;
    private String department;

    public CourseType(String courseName, String department) {
        this.courseName = courseName;
        this.department = department;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getDepartment() {
        return department;
    }

    public abstract void evaluate(); // Abstract method for evaluation type
}

// Concrete Course Types
class ExamCourse extends CourseType {
    public ExamCourse(String courseName, String department) {
        super(courseName, department);
    }

    @Override
    public void evaluate() {
        System.out.println(getCourseName() + " is evaluated based on exams.");
    }
}

class AssignmentCourse extends CourseType {
    public AssignmentCourse(String courseName, String department) {
        super(courseName, department);
    }

    @Override
    public void evaluate() {
        System.out.println(getCourseName() + " is evaluated based on assignments.");
    }
}

class ResearchCourse extends CourseType {
    public ResearchCourse(String courseName, String department) {
        super(courseName, department);
    }

    @Override
    public void evaluate() {
        System.out.println(getCourseName() + " is evaluated based on research work.");
    }
}

class Course<T extends CourseType> {
    private List<T> courses = new ArrayList<>();

    public void addCourse(T course) {
        courses.add(course);
    }

    public void listCourses() {
        for (T course : courses) {
            System.out.println("Course: " + course.getCourseName() + " | Department: " + course.getDepartment());
            course.evaluate();
        }
    }
}

// Utility Class to Handle Any Type of Course List Using Wildcards
class CourseUtils {
    public static void displayCourses(List<? extends CourseType> courses) {
        for (CourseType course : courses) {
            System.out.println("Course: " + course.getCourseName() + " | Department: " + course.getDepartment());
            course.evaluate();
        }
    }
}

public class UniversityCourseManagement {
    public static void main(String[] args) {
        // Creating specific course objects
        ExamCourse math101 = new ExamCourse("Math M01", "Mathematics");
        AssignmentCourse cs101 = new AssignmentCourse("CS C01", "Computer Science");
        ResearchCourse bioResearch = new ResearchCourse("Bio Research", "Biology");

        // Generic Course Management for Exam Courses
        Course<ExamCourse> examCourses = new Course<>();
        examCourses.addCourse(math101);
        System.out.println("\nExam Courses:");
        examCourses.listCourses();

        // Generic Course Management for Assignment Courses
        Course<AssignmentCourse> assignmentCourses = new Course<>();
        assignmentCourses.addCourse(cs101);
        System.out.println("\nAssignment Courses:");
        assignmentCourses.listCourses();

        // Managing multiple course types using Wildcards
        List<CourseType> allCourses = new ArrayList<>();
        allCourses.add(math101);
        allCourses.add(cs101);
        allCourses.add(bioResearch);

        System.out.println("\nDisplaying All Courses:");
        CourseUtils.displayCourses(allCourses);
    }
}
