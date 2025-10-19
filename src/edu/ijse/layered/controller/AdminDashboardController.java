package edu.ijse.layered.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;

public class AdminDashboardController {

    @FXML
    private TableView<?> tblCourses;

    @FXML
    private TableView<?> tblStudents;

    @FXML
    private TableView<?> tblLecturers;

    @FXML
    private Button btnLogout;

    @FXML
    void btnAddCourseOnAction(ActionEvent event) {
        showAlert(Alert.AlertType.INFORMATION, "Info", "Add Course functionality to be implemented");
    }

    @FXML
    void btnUpdateCourseOnAction(ActionEvent event) {
        showAlert(Alert.AlertType.INFORMATION, "Info", "Update Course functionality to be implemented");
    }

    @FXML
    void btnDeleteCourseOnAction(ActionEvent event) {
        showAlert(Alert.AlertType.INFORMATION, "Info", "Delete Course functionality to be implemented");
    }

    @FXML
    void btnAddStudentOnAction(ActionEvent event) {
        showAlert(Alert.AlertType.INFORMATION, "Info", "Add Student functionality to be implemented");
    }

    @FXML
    void btnUpdateStudentOnAction(ActionEvent event) {
        showAlert(Alert.AlertType.INFORMATION, "Info", "Update Student functionality to be implemented");
    }

    @FXML
    void btnDeleteStudentOnAction(ActionEvent event) {
        showAlert(Alert.AlertType.INFORMATION, "Info", "Delete Student functionality to be implemented");
    }

    @FXML
    void btnAddLecturerOnAction(ActionEvent event) {
        showAlert(Alert.AlertType.INFORMATION, "Info", "Add Lecturer functionality to be implemented");
    }

    @FXML
    void btnUpdateLecturerOnAction(ActionEvent event) {
        showAlert(Alert.AlertType.INFORMATION, "Info", "Update Lecturer functionality to be implemented");
    }

    @FXML
    void btnDeleteLecturerOnAction(ActionEvent event) {
        showAlert(Alert.AlertType.INFORMATION, "Info", "Delete Lecturer functionality to be implemented");
    }

    @FXML
    void btnLogoutOnAction(ActionEvent event) {
        try {
            // Close current window
            ((Stage) btnLogout.getScene().getWindow()).close();
            
            // Show login window
            Parent root = FXMLLoader.load(getClass().getResource("/view/LoginForm.fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Student Attendance Management System - Login");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}