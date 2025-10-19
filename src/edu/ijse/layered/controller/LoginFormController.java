package edu.ijse.layered.controller;

import edu.ijse.layered.dto.UserDTO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginFormController {

    @FXML
    private TextField txtUsername;

    @FXML
    private PasswordField txtPassword;
    
    private LoginController loginController = new LoginController();

    @FXML
    void btnClearOnAction(ActionEvent event) {
        txtUsername.clear();
        txtPassword.clear();
    }

    @FXML
    void btnLoginOnAction(ActionEvent event) {
        try {
            String username = txtUsername.getText();
            String password = txtPassword.getText();
            
            if (username.isEmpty() || password.isEmpty()) {
                showAlert(Alert.AlertType.ERROR, "Error", "Please enter both username and password");
                return;
            }
            
            UserDTO user = loginController.authenticate(username, password);
            if (user != null) {
                showAlert(Alert.AlertType.INFORMATION, "Success", "Login successful!");
                
                // Redirect based on user role
                if ("ADMIN".equals(user.getRole())) {
                    loadDashboard("AdminDashboardForm.fxml", "Admin Dashboard");
                } else if ("LECTURER".equals(user.getRole())) {
                    loadDashboard("LecturerDashboardForm.fxml", "Lecturer Dashboard");
                }
                
                // Close login window
                ((Stage) txtUsername.getScene().getWindow()).close();
            } else {
                showAlert(Alert.AlertType.ERROR, "Error", "Invalid username or password");
            }
        } catch (Exception e) {
            showAlert(Alert.AlertType.ERROR, "Error", "Login failed: " + e.getMessage());
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
    
    private void loadDashboard(String fxmlFile, String title) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/edu/ijse/layered/view/" + fxmlFile));
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle(title);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}