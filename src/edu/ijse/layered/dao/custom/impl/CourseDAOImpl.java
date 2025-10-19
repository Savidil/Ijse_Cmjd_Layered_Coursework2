/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package edu.ijse.layered.dao.custom.impl;

import edu.ijse.layered.dao.custom.CourseDAO;
import edu.ijse.layered.entity.Course;
import edu.ijse.layered.lib.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class CourseDAOImpl implements CourseDAO {

    @Override
    public boolean save(Course course) throws Exception {
        Connection connection = DatabaseConnection.getInstance().getConnection();
        String sql = "INSERT INTO courses (course_id, course_name, course_duration, course_fee, status) VALUES (?, ?, ?, ?, ?)";
        
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1, course.getCourseId());
        pstm.setString(2, course.getCourseName());
        pstm.setString(3, course.getCourseDuration());
        pstm.setDouble(4, course.getCourseFee());
        pstm.setString(5, course.getStatus());
        
        return pstm.executeUpdate() > 0;
    }

    @Override
    public boolean update(Course course) throws Exception {
        Connection connection = DatabaseConnection.getInstance().getConnection();
        String sql = "UPDATE courses SET course_name=?, course_duration=?, course_fee=?, status=? WHERE course_id=?";
        
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1, course.getCourseName());
        pstm.setString(2, course.getCourseDuration());
        pstm.setDouble(3, course.getCourseFee());
        pstm.setString(4, course.getStatus());
        pstm.setString(5, course.getCourseId());
        
        return pstm.executeUpdate() > 0;
    }

    @Override
    public boolean delete(String courseId) throws Exception {
        Connection connection = DatabaseConnection.getInstance().getConnection();
        String sql = "DELETE FROM courses WHERE course_id=?";
        
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1, courseId);
        
        return pstm.executeUpdate() > 0;
    }

    @Override
    public Course find(String courseId) throws Exception {
        Connection connection = DatabaseConnection.getInstance().getConnection();
        String sql = "SELECT * FROM courses WHERE course_id=?";
        
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1, courseId);
        
        ResultSet rst = pstm.executeQuery();
        if (rst.next()) {
            return new Course(
                rst.getString("course_id"),
                rst.getString("course_name"),
                rst.getString("course_duration"),
                rst.getDouble("course_fee"),
                rst.getString("status")
            );
        }
        return null;
    }

    @Override
    public ArrayList<Course> getAll() throws Exception {
        Connection connection = DatabaseConnection.getInstance().getConnection();
        String sql = "SELECT * FROM courses";
        
        PreparedStatement pstm = connection.prepareStatement(sql);
        ResultSet rst = pstm.executeQuery();
        
        ArrayList<Course> courses = new ArrayList<>();
        while (rst.next()) {
            courses.add(new Course(
                rst.getString("course_id"),
                rst.getString("course_name"),
                rst.getString("course_duration"),
                rst.getDouble("course_fee"),
                rst.getString("status")
            ));
        }
        return courses;
    }
}
