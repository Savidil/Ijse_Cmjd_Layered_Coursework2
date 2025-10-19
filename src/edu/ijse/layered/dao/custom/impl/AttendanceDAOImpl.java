package edu.ijse.layered.dao.custom.impl;

import edu.ijse.layered.dao.custom.AttendanceDAO;
import edu.ijse.layered.entity.Attendance;
import edu.ijse.layered.lib.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class AttendanceDAOImpl implements AttendanceDAO {

    @Override
    public boolean save(Attendance attendance) throws Exception {
        Connection connection = DatabaseConnection.getInstance().getConnection();
        String sql = "INSERT INTO attendance (attendance_id, session_id, student_id, attendance_status, remarks) VALUES (?, ?, ?, ?, ?)";
        
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1, attendance.getAttendanceId());
        pstm.setString(2, attendance.getSessionId());
        pstm.setString(3, attendance.getStudentId());
        pstm.setString(4, attendance.getAttendanceStatus());
        pstm.setString(5, attendance.getRemarks());
        
        return pstm.executeUpdate() > 0;
    }

    @Override
    public boolean update(Attendance attendance) throws Exception {
        Connection connection = DatabaseConnection.getInstance().getConnection();
        String sql = "UPDATE attendance SET session_id=?, student_id=?, attendance_status=?, remarks=? WHERE attendance_id=?";
        
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1, attendance.getSessionId());
        pstm.setString(2, attendance.getStudentId());
        pstm.setString(3, attendance.getAttendanceStatus());
        pstm.setString(4, attendance.getRemarks());
        pstm.setString(5, attendance.getAttendanceId());
        
        return pstm.executeUpdate() > 0;
    }

    @Override
    public boolean delete(String attendanceId) throws Exception {
        Connection connection = DatabaseConnection.getInstance().getConnection();
        String sql = "DELETE FROM attendance WHERE attendance_id=?";
        
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1, attendanceId);
        
        return pstm.executeUpdate() > 0;
    }

    @Override
    public Attendance find(String attendanceId) throws Exception {
        Connection connection = DatabaseConnection.getInstance().getConnection();
        String sql = "SELECT * FROM attendance WHERE attendance_id=?";
        
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1, attendanceId);
        
        ResultSet rst = pstm.executeQuery();
        if (rst.next()) {
            return new Attendance(
                rst.getString("attendance_id"),
                rst.getString("session_id"),
                rst.getString("student_id"),
                rst.getString("attendance_status"),
                rst.getString("marked_time"),
                rst.getString("remarks")
            );
        }
        return null;
    }

    @Override
    public ArrayList<Attendance> getAll() throws Exception {
        Connection connection = DatabaseConnection.getInstance().getConnection();
        String sql = "SELECT * FROM attendance";
        
        PreparedStatement pstm = connection.prepareStatement(sql);
        ResultSet rst = pstm.executeQuery();
        
        ArrayList<Attendance> attendances = new ArrayList<>();
        while (rst.next()) {
            attendances.add(new Attendance(
                rst.getString("attendance_id"),
                rst.getString("session_id"),
                rst.getString("student_id"),
                rst.getString("attendance_status"),
                rst.getString("marked_time"),
                rst.getString("remarks")
            ));
        }
        return attendances;
    }
}