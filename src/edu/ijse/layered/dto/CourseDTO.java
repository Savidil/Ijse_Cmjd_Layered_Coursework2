/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.layered.dto;

/**
 *
 * @author ASUS
 */
public class CourseDTO {
    private String courseId;
    private String courseName;
    private String courseDuration;
    private double courseFee;
    private String status;

    public CourseDTO() {}

    public CourseDTO(String courseId, String courseName, String courseDuration, double courseFee, String status) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.courseDuration = courseDuration;
        this.courseFee = courseFee;
        this.status = status;
    }

    // Getters and Setters
    public String getCourseId() { return courseId; }
    public void setCourseId(String courseId) { this.courseId = courseId; }

    public String getCourseName() { return courseName; }
    public void setCourseName(String courseName) { this.courseName = courseName; }

    public String getCourseDuration() { return courseDuration; }
    public void setCourseDuration(String courseDuration) { this.courseDuration = courseDuration; }

    public double getCourseFee() { return courseFee; }
    public void setCourseFee(double courseFee) { this.courseFee = courseFee; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
