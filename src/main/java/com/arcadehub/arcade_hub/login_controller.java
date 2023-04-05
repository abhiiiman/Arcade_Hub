package com.arcadehub.arcade_hub;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.*;
import java.util.Objects;
import java.util.Optional;

public class login_controller {
    @FXML
    private TextField usernametext;

    @FXML
    private TextField passtext;

    @FXML
    private Button loginButton;

    @FXML
    private Label callsignup;

    public static String usernamevalue;
    @FXML
    public void getText(ActionEvent event) {
        usernamevalue = usernametext.getText();
        String passwordvalue = passtext.getText();
        System.out.println("username: " + usernamevalue);
        System.out.println("password: " + passwordvalue);

        Alert alert;
        if (!Objects.equals(usernamevalue, "") && !Objects.equals(passwordvalue, "")) {
            try {
                // Load the JDBC driver
                Class.forName("com.mysql.cj.jdbc.Driver");

                // Establish a connection to the database
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/arcadehub", "root", "root");

                // Defining the SQL statement with  parameters
                String sql = "SELECT password FROM users WHERE username = ?;";

                // Create a PreparedStatement object
                PreparedStatement pstmt = conn.prepareStatement(sql);

                // Set the parameter value to send it to the placeholder to check.
                pstmt.setString(1, usernamevalue);

                // Execute the SQL statement
                ResultSet rs = pstmt.executeQuery();

                // Process the result
//                Alert alert;
                if (rs.next()) {
                    String password = rs.getString("password");
                    System.out.println("User Found: " + usernamevalue);
                    if (Objects.equals(password, passwordvalue)) {
                        System.out.println("Password matched, Login completed!");
                        alert = new Alert(Alert.AlertType.CONFIRMATION);
                        alert.setTitle("ArcadeHub");
                        alert.setHeaderText("Login Successful");
                        alert.setContentText("Proceed to Menu Page");
                        Optional<ButtonType> result = alert.showAndWait();
                        if (result.isPresent() && result.get() == ButtonType.OK) {
                            try {
                                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("menu.fxml"));
                                Parent root = fxmlLoader.load();
                                Scene scene = new Scene(root, 800, 500);
                                Stage stage = new Stage();
                                stage.setScene(scene);
                                stage.setTitle("ArcadeHub | GameMenu");
                                //        adding the icon to the stage here.
                                stage.getIcons().add(new Image("C:\\Users\\DELL\\IdeaProjects\\Arcade_Hub\\src\\main\\resources\\com\\arcadehub\\arcade_hub_imgs\\iconfile.png"));
                                stage.setResizable(false);
                                stage.show();

                                // Close the parent window
                                ((Node) (event.getSource())).getScene().getWindow().hide();

                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    } else {
                        alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("ArcadeHub");
                        alert.setHeaderText("Password Error");
                        alert.setContentText("Password doesn't matched, Try Again!");
                        alert.showAndWait();
                    }
                } else {
                    System.out.println("No user found with that username.");
                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("ArcadeHub");
                    alert.setHeaderText("Invalid Credentials");
                    alert.setContentText("No user found with that username.");
                    alert.showAndWait();
                }

                // Close the resources
                rs.close();
                pstmt.close();
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else{
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ArcadeHub");
            alert.setHeaderText("Credential Error");
            alert.setContentText("Please fill your credentials properly first !");
            alert.showAndWait();
        }
    }

    @FXML
    public void onCreateButtonEntered(MouseEvent event) {
        loginButton.setStyle("-fx-background-color: yellow; -fx-text-fill: black; -fx-background-radius: 10px");
    }

    @FXML
    public void onCreateButtonExited(MouseEvent event) {
        loginButton.setStyle("-fx-background-color: linear-gradient(to right, #00cc00, #00ff00); -fx-text-fill: black; -fx-background-radius: 10px");
    }

    @FXML
    public void oncallsignupEntered(MouseEvent event){
        callsignup.setStyle("-fx-underline: true;");
    }

    @FXML
    public void oncallsignupExited(MouseEvent event){
        callsignup.setStyle("-fx-underline: false;");
    }

    @FXML
    public void setCallsignup(MouseEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("sign_up.fxml"));
            Parent root = fxmlLoader.load();
            Scene scene = new Scene(root, 800, 500);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("ArcadeHub | Create Account");
            //        adding the icon to the stage here.
            stage.getIcons().add(new Image("C:\\Users\\DELL\\IdeaProjects\\Arcade_Hub\\src\\main\\resources\\com\\arcadehub\\arcade_hub_imgs\\iconfile.png"));
            stage.setResizable(false);
            stage.show();

            // Close the parent window
            ((Node)(event.getSource())).getScene().getWindow().hide();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}