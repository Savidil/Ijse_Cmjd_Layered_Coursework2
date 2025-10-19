/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.layered.entity;

/**
 *
 * @author ASUS
 */
public class Attendance {
    private String attendanceId;
    private String sessionId;
    private String studentId;
    private String attendanceStatus;
    private String markedTime;
    private String remarks;

    public Attendance() {}

    public Attendance(String attendanceId, String sessionId, String studentId, String attendanceStatus, String markedTime, String remarks) {
        this.attendanceId = attendanceId;
        this.sessionId = sessionId;
        this.studentId = studentId;
        this.attendanceStatus = attendanceStatus;
        this.markedTime = markedTime;
        this.remarks = remarks;
    }

    // Getters and Setters
    public String getAttendanceId() { return attendanceId; }
    public void setAttendanceId(String attendanceId) { this.attendanceId = attendanceId; }

    public String getSessionId() { return sessionId; }
    public void setSessionId(String sessionId) { this.sessionId = sessionId; }

    public String getStudentId() { return studentId; }
    public void setStudentId(String studentId) { this.studentId = studentId; }

    public String getAttendanceStatus() { return attendanceStatus; }
    public void setAttendanceStatus(String attendanceStatus) { this.attendanceStatus = attendanceStatus; }

    public String getMarkedTime() { return markedTime; }
    public void setMarkedTime(String markedTime) { this.markedTime = markedTime; }

    public String getRemarks() { return remarks; }
    public void setRemarks(String remarks) { this.remarks = remarks; }
}
