package edu.ijse.layered.dao.custom.impl;

import edu.ijse.layered.dao.custom.StudentDAO;
import edu.ijse.layered.entity.Student;
import edu.ijse.layered.lib.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class StudentDAOImpl implements StudentDAO {

    @Override
    public boolean save(Student student) throws Exception {
        Connection connection = DatabaseConnection.getInstance().getConnection();
        String sql = "INSERT INTO students (student_id, first_name, last_name, email, phone, address, course_id, registration_date) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1, student.getStudentId());
        pstm.setString(2, student.getFirstName());
        pstm.setString(3, student.getLastName());
        pstm.setString(4, student.getEmail());
        pstm.setString(5, student.getPhone());
        pstm.setString(6, student.getAddress());
        pstm.setString(7, student.getCourseId());
        pstm.setString(8, student.getRegistrationDate());
        
        return pstm.executeUpdate() > 0;
    }

    @Override
    public boolean update(Student student) throws Exception {
        Connection connection = DatabaseConnection.getInstance().getConnection();
        String sql = "UPDATE students SET first_name=?, last_name=?, email=?, phone=?, address=?, course_id=?, registration_date=? WHERE student_id=?";
        
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1, student.getFirstName());
        pstm.setString(2, student.getLastName());
        pstm.setString(3, student.getEmail());
        pstm.setString(4, student.getPhone());
        pstm.setString(5, student.getAddress());
        pstm.setString(6, student.getCourseId());
        pstm.setString(7, student.getRegistrationDate());
        pstm.setString(8, student.getStudentId());
        
        return pstm.executeUpdate() > 0;
    }

    @Override
    public boolean delete(String studentId) throws Exception {
        Connection connection = DatabaseConnection.getInstance().getConnection();
        String sql = "DELETE FROM students WHERE student_id=?";
        
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1, studentId);
        
        return pstm.executeUpdate() > 0;
    }

    @Override
    public Student find(String studentId) throws Exception {
        Connection connection = DatabaseConnection.getInstance().getConnection();
        String sql = "SELECT * FROM students WHERE student_id=?";
        
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1, studentId);
        
        ResultSet rst = pstm.executeQuery();
        if (rst.next()) {
            return new Student(
                rst.getString("student_id"),
                rst.getString("first_name"),
                rst.getString("last_name"),
                rst.getString("email"),
                rst.getString("phone"),
                rst.getString("address"),
                rst.getString("course_id"),
                rst.getString("registration_date")
            );
        }
        return null;
    }

    @Override
    public ArrayList<Student> getAll() throws Exception {
        Connection connection = DatabaseConnection.getInstance().getConnection();
        String sql = "SELECT * FROM students";
        
        PreparedStatement pstm = connection.prepareStatement(sql);
        ResultSet rst = pstm.executeQuery();
        
        ArrayList<Student> students = new ArrayList<>();
        while (rst.next()) {
            students.add(new Student(
                rst.getString("student_id"),
                rst.getString("first_name"),
                rst.getString("last_name"),
                rst.getString("email"),
                rst.getString("phone"),
                rst.getString("address"),
                rst.getString("course_id"),
                rst.getString("registration_date")
            ));
        }
        return students;
    }
}