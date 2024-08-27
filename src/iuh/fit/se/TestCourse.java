/*
 * @(#) $(NAME).java    1.0     8/23/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved.
 */

package iuh.fit.se;

/*
 * @description
 * @author: Tran Tan Dat
 * @version: 1.0
 * @created: 23-August-2024 2:00 PM
 */

import java.util.Scanner;

public class TestCourse {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CourseList cl = new CourseList(10);
        initData(cl);
        int choice;
        do {
            System.out.println("1. Add a new course");
            System.out.println("2. Display all courses");
            System.out.println("3. Remove a course");
            System.out.println("4. Find a course");
            System.out.println("5. Find a course by title");
            System.out.println("6. Find a course by department");
            System.out.println("7. Sort courses by title");
            System.out.println("8. Find a course by max credit");
            System.out.println("9. Find department with most courses");
            System.out.println("10. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    System.out.print("Enter course ID: ");
                    String id = sc.nextLine();
                    System.out.print("Enter title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter credit: ");
                    int credit = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter department: ");
                    String department = sc.nextLine();
                    Course course = new Course(id, title, credit, department);

                    if (cl.addCourse(course))
                        System.out.println("Course added successfully");
                    else
                        System.out.println("Course not added");
                    break;
                case 2:
                    System.out.println(String.format("%-10s%-30s%10s   %-20s", "ID", "Title", "Credit", "Department"));
                    for (Course c : cl.getCourses()) {
                        if (c != null)
                            System.out.println(c);
                    }
                    break;
                case 3:
                    System.out.print("Enter course ID to remove: ");
                    String removeId = sc.nextLine();
                    if (cl.removeCourse(removeId))
                        System.out.println("Course removed successfully");
                    else
                        System.out.println("Course not found");
                    break;
                case 4:
                    System.out.print("Enter course ID to find: ");
                    String findId = sc.nextLine();
                    Course foundCourse = cl.findCourse(findId);
                    if (foundCourse != null)
                        System.out.println(foundCourse);
                    else
                        System.out.println("Course not found");
                    break;
                case 5:
                    System.out.print("Enter course title to find: ");
                    String findTitle = sc.nextLine();
                    Course foundCourseByTitle = cl.findCourseByTitle(findTitle);
                    if (foundCourseByTitle != null)
                        for (Course c : cl.getCourses()) {
                            if (c != null && c.getTitle().equalsIgnoreCase(findTitle))
                                System.out.println(c);
                        }
                    else
                        System.out.println("Course not found");
                    break;
                case 6:
                    System.out.print("Enter course department to find: ");
                    String findDepartment = sc.nextLine();
                    Course foundCourseByDepartment = cl.findCourseByDepartment(findDepartment);
                    if (foundCourseByDepartment != null)
                        for (Course c : cl.getCourses()) {
                            if (c != null && c.getDepartment().equalsIgnoreCase(findDepartment))
                                System.out.println(c);
                        }
                    else
                        System.out.println("Course not found");
                    break;
                    case 7:
                    cl.sortCourseByTitle();
                    break;
                    case 8:
                    Course foundCourseByMaxCredit = cl.findCourseMaxCredit();
                    for (Course c : cl.getCourses()) {
                        if (c != null && c.getCredit() == foundCourseByMaxCredit.getCredit())
                            System.out.println(c);
                    }
                    case 9:
                    String departmentWithMostCourses = cl.findDepartmentMaxCourses();
                    for (Course c : cl.getCourses()) {
                        if (c != null && c.getDepartment().equalsIgnoreCase(departmentWithMostCourses))
                            System.out.println(c);
                    }
            }
        } while (choice != 10);
    }

    private static void initData(CourseList cl) {
        Course c1 = new Course("CS101", "Java Programming", 3, "CS");
        Course c2 = new Course("CS102", "Web Programming", 3, "IS");
        Course c3 = new Course("CS103", "Database Programming", 10, "CS");
        Course c4 = new Course("CS104", "Computer Network", 5, "IS");
        Course c5 = new Course("CS105", "Computer Network", 10, "CS");

        cl.addCourse(c1);
        cl.addCourse(c2);
        cl.addCourse(c3);
        cl.addCourse(c4);
        cl.addCourse(c5);
    }
}
