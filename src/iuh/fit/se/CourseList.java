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
 * @created: 23-August-2024 1:54 PM
 */

public class CourseList {
    private Course[] courses;
    private int count = 0;

    public boolean addCourse(Course c) {
        // check if course is null
        if (c == null)
            return false;
        // check if course is already existed
        if (isExists(c)) //
            return false;
        // check if the array is full
        if (count == courses.length)
            return false;

        // add course to the array
        courses[count++] = c;
        return true;
    }

    private boolean isExists(Course c) {
        for (int i = 0; i < count; i++) {
            if (courses[i].getCourseId().equalsIgnoreCase(c.getCourseId()))
                return true;
        }
        return false;
    }

    public boolean removeCourse(String id) {
        for (int i = 0; i < count; i++) {
            if (courses[i].getCourseId().equalsIgnoreCase(id)) {
                for (int j = i; j < count - 1; j++) {
                    courses[j] = courses[j + 1];
                }
                count--;
                return true;
            }
        }
        return false;
    }

    public Course findCourse(String id) {
        for (int i = 0; i < count; i++) {
            if (courses[i].getCourseId().equalsIgnoreCase(id))
                return courses[i];
        }
        return null;
    }

    public Course findCourseByTitle(String title) {
        for (int i = 0; i < count; i++) {
            if (courses[i].getTitle().equalsIgnoreCase(title))
                return courses[i];
        }
        return null;
    }

    public Course findCourseByDepartment(String department) {
        for (int i = 0; i < count; i++) {
            if (courses[i].getDepartment().equalsIgnoreCase(department))
                return courses[i];
        }
        return null;
    }

    public Course sortCourseByTitle() {
        for (int i = 0; i < count - 1; i++) {
            for (int j = i + 1; j < count; j++) {
                if (courses[i].getTitle().compareToIgnoreCase(courses[j].getTitle()) > 0) {
                    Course temp = courses[i];
                    courses[i] = courses[j];
                    courses[j] = temp;
                }
            }
        }
        return null;
    }

    public Course findCourseMaxCredit() {
        int max = courses[0].getCredit();
        for (int i = 1; i < count; i++) {
            if (courses[i].getCredit() > max)
                max = courses[i].getCredit();
        }
        for (int i = 0; i < count; i++) {
            if (courses[i].getCredit() == max)
                return courses[i];
        }
        return null;
    }

    public String findDepartmentMaxCourses() {
        int max = 0;
        String department = "";
        for (int i = 0; i < count; i++) {
            int countDepartment = 0;
            for (int j = 0; j < count; j++) {
                if (courses[i].getDepartment().equalsIgnoreCase(courses[j].getDepartment()))
                    countDepartment++;
            }
            if (countDepartment > max) {
                max = countDepartment;
                department = courses[i].getDepartment();
            }
        }
        return department;
    }

    public CourseList(int n) {
        if (n <= 0)
            throw new IllegalArgumentException("Length of the array must be greater than 0");

        this.courses = new Course[n];
    }

    public Course[] getCourses() {
        return courses;
    }
}
