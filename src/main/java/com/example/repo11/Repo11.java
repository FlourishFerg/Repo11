package com.example.repo11;

import java.util.HashMap;

public class Repo11 {

    // Enum for course status
    enum CourseStatus {
        ACTIVE, INACTIVE
    }

    // Enum for user roles
    enum UserRole {
        STUDENT, INSTRUCTOR
    }

    // Class representing a course
    class Course {
        private String courseId;
        private String title;
        private String instructor;
        private List<String> lectures;
        private List<String> quizzes;
        private CourseStatus status;

        public Course(String courseId, String title, String instructor) {
            this.courseId = courseId;
            this.title = title;
            this.instructor = instructor;
            this.lectures = new ArrayList<>();
            this.quizzes = new ArrayList<>();
            this.status = CourseStatus.ACTIVE;
        }

        // Getters and setters
    }

    // Class representing a user
    class User {
        private String username;
        private String password;
        private UserRole role;
        private List<String> enrolledCourses;

        public User(String username, String password, UserRole role) {
            this.username = username;
            this.password = password;
            this.role = role;
            this.enrolledCourses = new ArrayList<>();
        }

        // Getters and setters
    }

    // Class representing the Learning Management System
    public class LearningManagementSystem {
        private Map<String, Course> courses;
        private Map<String, User> users;

        public LearningManagementSystem() {
            this.courses = new HashMap<>();
            this.users = new HashMap<>();
        }

        public void addCourse(String courseId, String title, String instructor) {
            courses.put(courseId, new Course(courseId, title, instructor));
        }

        public void addUser(String username, String password, UserRole role) {
            users.put(username, new User(username, password, role));
        }

        public void enrollUserInCourse(String username, String courseId) {
            User user = users.get(username);
            Course course = courses.get(courseId);
            if (user != null && course != null) {
                user.enrolledCourses.add(courseId);
                System.out.println("Enrollment successful for user: " + username + " in course: " + courseId);
            } else {
                System.out.println("User or course not found.");
            }
        }

        // Other methods for content delivery, progress tracking, grading, etc.

        public static void main(String[] args) {
            LearningManagementSystem lms = new LearningManagementSystem();
            lms.addCourse("CSE101", "Introduction to Computer Science", "John Doe");
            lms.addCourse("MATH201", "Calculus I", "Alice Smith");

            lms.addUser("student1", "password1", UserRole.STUDENT);
            lms.addUser("instructor1", "password2", UserRole.INSTRUCTOR);

            lms.enrollUserInCourse("student1", "CSE101");
            lms.enrollUserInCourse("student1", "MATH201");

            // Example usage:
            User student1 = lms.users.get("student1");
            if (student1 != null) {
                System.out.println("Enrolled courses for student1:");
                for (String courseId : student1.enrolledCourses) {
                    Course course = lms.courses.get(courseId);
                    if (course != null) {
                        System.out.println(course.getTitle());
                    }
                }
            }
        }
    }

}
