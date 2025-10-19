package edu.ijse.layered.dao.custom.impl;

import edu.ijse.layered.dao.custom.SubjectDAO;
import edu.ijse.layered.entity.Subject;
import edu.ijse.layered.lib.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class SubjectDAOImpl implements SubjectDAO {

    @Override
    public boolean save(Subject subject) throws Exception {
        Connection connection = DatabaseConnection.getInstance().getConnection();
        String sql = "INSERT INTO subjects (subject_id, subject_name, subject_code, credit_hours, course_id) VALUES (?, ?, ?, ?, ?)";
        
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1, subject.getSubjectId());
        pstm.setString(2, subject.getSubjectName());
        pstm.setString(3, subject.getSubjectCode());
        pstm.setInt(4, subject.getCreditHours());
        pstm.setString(5, subject.getCourseId());
        
        return pstm.executeUpdate() > 0;
    }

    @Override
    public boolean update(Subject subject) throws Exception {
        Connection connection = DatabaseConnection.getInstance().getConnection();
        String sql = "UPDATE subjects SET subject_name=?, subject_code=?, credit_hours=?, course_id=? WHERE subject_id=?";
        
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1, subject.getSubjectName());
        pstm.setString(2, subject.getSubjectCode());
        pstm.setInt(3, subject.getCreditHours());
        pstm.setString(4, subject.getCourseId());
        pstm.setString(5, subject.getSubjectId());
        
        return pstm.executeUpdate() > 0;
    }

    @Override
    public boolean delete(String subjectId) throws Exception {
        Connection connection = DatabaseConnection.getInstance().getConnection();
        String sql = "DELETE FROM subjects WHERE subject_id=?";
        
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1, subjectId);
        
        return pstm.executeUpdate() > 0;
    }

    @Override
    public Subject find(String subjectId) throws Exception {
        Connection connection = DatabaseConnection.getInstance().getConnection();
        String sql = "SELECT * FROM subjects WHERE subject_id=?";
        
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1, subjectId);
        
        ResultSet rst = pstm.executeQuery();
        if (rst.next()) {
            return new Subject(
                rst.getString("subject_id"),
                rst.getString("subject_name"),
                rst.getString("subject_code"),
                rst.getInt("credit_hours"),
                rst.getString("course_id")
            );
        }
        return null;
    }

    @Override
    public ArrayList<Subject> getAll() throws Exception {
        Connection connection = DatabaseConnection.getInstance().getConnection();
        String sql = "SELECT * FROM subjects";
        
        PreparedStatement pstm = connection.prepareStatement(sql);
        ResultSet rst = pstm.executeQuery();
        
        ArrayList<Subject> subjects = new ArrayList<>();
        while (rst.next()) {
            subjects.add(new Subject(
                rst.getString("subject_id"),
                rst.getString("subject_name"),
                rst.getString("subject_code"),
                rst.getInt("credit_hours"),
                rst.getString("course_id")
            ));
        }
        return subjects;
    }
}