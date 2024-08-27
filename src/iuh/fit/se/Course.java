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
 * @created: 23-August-2024 1:50 PM
 */

public class Course {
    private String courseId;
    private String title;
    private int credit;
    private String department;

    public Course() {
    }

    public Course(String courseId, String title, int credit, String department) {
        this.setCourseId(courseId);
        this.setTitle(title);
        this.setCredit(credit);
        this.department = department;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        // ID must have at least 3 characters
        //ID must contain only letters or digits
        if (courseId.length() < 3)
            throw new IllegalArgumentException("ID must have at least 3 characters");
        if (!courseId.matches("[a-zA-Z0-9]+"))
            throw new IllegalArgumentException("ID must contain only letters or digits");
        this.courseId = courseId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if (title.isEmpty())
            throw new IllegalArgumentException("Title must not be empty");
        this.title = title;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        if (credit < 0)
            throw new IllegalArgumentException("Credit must be greater than 0");
        this.credit = credit;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return String.format("%-10s%-30s%10d   %-20s", courseId, title, credit, department);
    }
}
