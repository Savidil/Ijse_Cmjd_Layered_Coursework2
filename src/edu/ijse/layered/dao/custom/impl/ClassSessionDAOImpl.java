package edu.ijse.layered.dao.custom.impl;

import edu.ijse.layered.dao.custom.ClassSessionDAO;
import edu.ijse.layered.entity.ClassSession;
import edu.ijse.layered.lib.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ClassSessionDAOImpl implements ClassSessionDAO {

    @Override
    public boolean save(ClassSession session) throws Exception {
        Connection connection = DatabaseConnection.getInstance().getConnection();
        String sql = "INSERT INTO class_sessions (session_id, subject_id, lecturer_id, session_date, start_time, end_time, topic, status) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1, session.getSessionId());
        pstm.setString(2, session.getSubjectId());
        pstm.setString(3, session.getLecturerId());
        pstm.setString(4, session.getSessionDate());
        pstm.setString(5, session.getStartTime());
        pstm.setString(6, session.getEndTime());
        pstm.setString(7, session.getTopic());
        pstm.setString(8, session.getStatus());
        
        return pstm.executeUpdate() > 0;
    }

    @Override
    public boolean update(ClassSession session) throws Exception {
        Connection connection = DatabaseConnection.getInstance().getConnection();
        String sql = "UPDATE class_sessions SET subject_id=?, lecturer_id=?, session_date=?, start_time=?, end_time=?, topic=?, status=? WHERE session_id=?";
        
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1, session.getSubjectId());
        pstm.setString(2, session.getLecturerId());
        pstm.setString(3, session.getSessionDate());
        pstm.setString(4, session.getStartTime());
        pstm.setString(5, session.getEndTime());
        pstm.setString(6, session.getTopic());
        pstm.setString(7, session.getStatus());
        pstm.setString(8, session.getSessionId());
        
        return pstm.executeUpdate() > 0;
    }

    @Override
    public boolean delete(String sessionId) throws Exception {
        Connection connection = DatabaseConnection.getInstance().getConnection();
        String sql = "DELETE FROM class_sessions WHERE session_id=?";
        
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1, sessionId);
        
        return pstm.executeUpdate() > 0;
    }

    @Override
    public ClassSession find(String sessionId) throws Exception {
        Connection connection = DatabaseConnection.getInstance().getConnection();
        String sql = "SELECT * FROM class_sessions WHERE session_id=?";
        
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1, sessionId);
        
        ResultSet rst = pstm.executeQuery();
        if (rst.next()) {
            return new ClassSession(
                rst.getString("session_id"),
                rst.getString("subject_id"),
                rst.getString("lecturer_id"),
                rst.getString("session_date"),
                rst.getString("start_time"),
                rst.getString("end_time"),
                rst.getString("topic"),
                rst.getString("status")
            );
        }
        return null;
    }

    @Override
    public ArrayList<ClassSession> getAll() throws Exception {
        Connection connection = DatabaseConnection.getInstance().getConnection();
        String sql = "SELECT * FROM class_sessions";
        
        PreparedStatement pstm = connection.prepareStatement(sql);
        ResultSet rst = pstm.executeQuery();
        
        ArrayList<ClassSession> sessions = new ArrayList<>();
        while (rst.next()) {
            sessions.add(new ClassSession(
                rst.getString("session_id"),
                rst.getString("subject_id"),
                rst.getString("lecturer_id"),
                rst.getString("session_date"),
                rst.getString("start_time"),
                rst.getString("end_time"),
                rst.getString("topic"),
                rst.getString("status")
            ));
        }
        return sessions;
    }
}