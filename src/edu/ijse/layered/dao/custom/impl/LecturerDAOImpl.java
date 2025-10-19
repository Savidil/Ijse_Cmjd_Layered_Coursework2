package edu.ijse.layered.dao.custom.impl;

import edu.ijse.layered.dao.custom.LecturerDAO;
import edu.ijse.layered.entity.Lecturer;
import edu.ijse.layered.lib.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class LecturerDAOImpl implements LecturerDAO {

    @Override
    public boolean save(Lecturer lecturer) throws Exception {
        Connection connection = DatabaseConnection.getInstance().getConnection();
        String sql = "INSERT INTO lecturers (lecturer_id, first_name, last_name, email, phone, specialization, user_id) VALUES (?, ?, ?, ?, ?, ?, ?)";
        
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1, lecturer.getLecturerId());
        pstm.setString(2, lecturer.getFirstName());
        pstm.setString(3, lecturer.getLastName());
        pstm.setString(4, lecturer.getEmail());
        pstm.setString(5, lecturer.getPhone());
        pstm.setString(6, lecturer.getSpecialization());
        pstm.setString(7, lecturer.getUserId());
        
        return pstm.executeUpdate() > 0;
    }

    @Override
    public boolean update(Lecturer lecturer) throws Exception {
        Connection connection = DatabaseConnection.getInstance().getConnection();
        String sql = "UPDATE lecturers SET first_name=?, last_name=?, email=?, phone=?, specialization=?, user_id=? WHERE lecturer_id=?";
        
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1, lecturer.getFirstName());
        pstm.setString(2, lecturer.getLastName());
        pstm.setString(3, lecturer.getEmail());
        pstm.setString(4, lecturer.getPhone());
        pstm.setString(5, lecturer.getSpecialization());
        pstm.setString(6, lecturer.getUserId());
        pstm.setString(7, lecturer.getLecturerId());
        
        return pstm.executeUpdate() > 0;
    }

    @Override
    public boolean delete(String lecturerId) throws Exception {
        Connection connection = DatabaseConnection.getInstance().getConnection();
        String sql = "DELETE FROM lecturers WHERE lecturer_id=?";
        
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1, lecturerId);
        
        return pstm.executeUpdate() > 0;
    }

    @Override
    public Lecturer find(String lecturerId) throws Exception {
        Connection connection = DatabaseConnection.getInstance().getConnection();
        String sql = "SELECT * FROM lecturers WHERE lecturer_id=?";
        
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1, lecturerId);
        
        ResultSet rst = pstm.executeQuery();
        if (rst.next()) {
            return new Lecturer(
                rst.getString("lecturer_id"),
                rst.getString("first_name"),
                rst.getString("last_name"),
                rst.getString("email"),
                rst.getString("phone"),
                rst.getString("specialization"),
                rst.getString("user_id")
            );
        }
        return null;
    }

    @Override
    public ArrayList<Lecturer> getAll() throws Exception {
        Connection connection = DatabaseConnection.getInstance().getConnection();
        String sql = "SELECT * FROM lecturers";
        
        PreparedStatement pstm = connection.prepareStatement(sql);
        ResultSet rst = pstm.executeQuery();
        
        ArrayList<Lecturer> lecturers = new ArrayList<>();
        while (rst.next()) {
            lecturers.add(new Lecturer(
                rst.getString("lecturer_id"),
                rst.getString("first_name"),
                rst.getString("last_name"),
                rst.getString("email"),
                rst.getString("phone"),
                rst.getString("specialization"),
                rst.getString("user_id")
            ));
        }
        return lecturers;
    }
}