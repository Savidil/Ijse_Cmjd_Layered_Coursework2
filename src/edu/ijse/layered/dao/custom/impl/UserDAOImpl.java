/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.layered.dao.custom.impl;

/**
 *
 * @author ASUS
 */

import edu.ijse.layered.dao.custom.UserDAO;
import edu.ijse.layered.entity.User;
import edu.ijse.layered.lib.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class UserDAOImpl implements UserDAO {

    @Override
    public boolean save(User user) throws Exception {
        Connection connection = DatabaseConnection.getInstance().getConnection();
        String sql = "INSERT INTO users (user_id, username, password, role, email) VALUES (?, ?, ?, ?, ?)";
        
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1, user.getUserId());
        pstm.setString(2, user.getUsername());
        pstm.setString(3, user.getPassword());
        pstm.setString(4, user.getRole());
        pstm.setString(5, user.getEmail());
        
        return pstm.executeUpdate() > 0;
    }

    @Override
    public boolean update(User user) throws Exception {
        Connection connection = DatabaseConnection.getInstance().getConnection();
        String sql = "UPDATE users SET username=?, password=?, role=?, email=? WHERE user_id=?";
        
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1, user.getUsername());
        pstm.setString(2, user.getPassword());
        pstm.setString(3, user.getRole());
        pstm.setString(4, user.getEmail());
        pstm.setString(5, user.getUserId());
        
        return pstm.executeUpdate() > 0;
    }

    @Override
    public boolean delete(String userId) throws Exception {
        Connection connection = DatabaseConnection.getInstance().getConnection();
        String sql = "DELETE FROM users WHERE user_id=?";
        
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1, userId);
        
        return pstm.executeUpdate() > 0;
    }

    @Override
    public User find(String userId) throws Exception {
        Connection connection = DatabaseConnection.getInstance().getConnection();
        String sql = "SELECT * FROM users WHERE user_id=?";
        
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1, userId);
        
        ResultSet rst = pstm.executeQuery();
        if (rst.next()) {
            return new User(
                rst.getString("user_id"),
                rst.getString("username"),
                rst.getString("password"),
                rst.getString("role"),
                rst.getString("email"),
                rst.getString("created_date")
            );
        }
        return null;
    }

    @Override
    public ArrayList<User> getAll() throws Exception {
        Connection connection = DatabaseConnection.getInstance().getConnection();
        String sql = "SELECT * FROM users";
        
        PreparedStatement pstm = connection.prepareStatement(sql);
        ResultSet rst = pstm.executeQuery();
        
        ArrayList<User> users = new ArrayList<>();
        while (rst.next()) {
            users.add(new User(
                rst.getString("user_id"),
                rst.getString("username"),
                rst.getString("password"),
                rst.getString("role"),
                rst.getString("email"),
                rst.getString("created_date")
            ));
        }
        return users;
    }

    @Override
    public User findByUsername(String username) throws Exception {
        Connection connection = DatabaseConnection.getInstance().getConnection();
        String sql = "SELECT * FROM users WHERE username=?";
        
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1, username);
        
        ResultSet rst = pstm.executeQuery();
        if (rst.next()) {
            return new User(
                rst.getString("user_id"),
                rst.getString("username"),
                rst.getString("password"),
                rst.getString("role"),
                rst.getString("email"),
                rst.getString("created_date")
            );
        }
        return null;
    }

    @Override
    public boolean checkPassword(String username, String password) throws Exception {
        Connection connection = DatabaseConnection.getInstance().getConnection();
        String sql = "SELECT * FROM users WHERE username=? AND password=?";
        
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1, username);
        pstm.setString(2, password);
        
        ResultSet rst = pstm.executeQuery();
        return rst.next();
    }
}