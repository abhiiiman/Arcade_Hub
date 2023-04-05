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
import java.util.Objects;
import java.util.Optional;
import java.sql.*;

public class sign_up_controller {
    //functions for sign up page here.
    @FXML
    private TextField usernametext;

    @FXML
    private TextField cretepasstext;

    @FXML
    private TextField confirmpasstext;

    @FXML
    private Button createButton;

    @FXML
    private Label callLogin;

    @FXML
    public void getText(ActionEvent event) {
        String usernamevalue = usernametext.getText();
        String createpassvalue = cretepasstext.getText();
        String confirmpassvalue = confirmpasstext.getText();
        System.out.println("username: " + usernamevalue);
        System.out.println("created password: " + createpassvalue);
        System.out.println("confirmed password: " + confirmpassvalue);

//        jdbc code here.
        Alert alert;
        if (!Objects.equals(usernamevalue, "") && !Objects.equals(createpassvalue, "") && !Objects.equals(confirmpassvalue, "")) {
            try {
                // Load the JDBC driver
                Class.forName("com.mysql.cj.jdbc.Driver");

                // Establishing a connection to the database
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/arcadehub", "root", "root");

                // Check if the username already exists in the users table
                String username = usernamevalue;
                String checkSql = "SELECT COUNT(*) FROM users WHERE username = ?";
                PreparedStatement checkStmt = conn.prepareStatement(checkSql);
                checkStmt.setString(1, username);
                ResultSet rs = checkStmt.executeQuery();
                rs.next();
                int count = rs.getInt(1);
                rs.close();
                checkStmt.close();

//                Alert alert;
                if (count > 0) {
                    System.out.println("username already exists in the users table, registration stopped!");
                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("ArcadeHub");
                    alert.setHeaderText("User already exists");
                    alert.setContentText("Username already exists, Try Login!");
                    alert.showAndWait();
                } else {
                    // Defining the SQL statement with parameters
                    System.out.println("New User found, registration begins.");
                    String insertSql = "INSERT INTO users (username, password) VALUES (?, ?)";

                    // Creating a PreparedStatement object
                    PreparedStatement insertStmt = conn.prepareStatement(insertSql);

                    // Setting the parameter values
                    insertStmt.setString(1, username);
                    insertStmt.setString(2, confirmpassvalue);

                    Stage stage = null;
                    if (Objects.equals(createpassvalue, confirmpassvalue)) {

                        // Executing the insert query
                        int rows = insertStmt.executeUpdate();
                        System.out.println(rows + " rows inserted.");

                        alert = new Alert(Alert.AlertType.CONFIRMATION);
                        alert.setTitle("ArcadeHub");
                        alert.setHeaderText("Registration Completed");
                        alert.setContentText("Proceed to Login Now");

                        Optional<ButtonType> result = alert.showAndWait();
                        if (result.isPresent() && result.get() == ButtonType.OK) {
                            try {
                                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("login.fxml"));
                                Parent root = fxmlLoader.load();
                                Scene scene = new Scene(root, 800, 500);
                                stage = new Stage();
                                stage.setScene(scene);
                                stage.setTitle("ArcadeHub | Login Account");
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

                    // Closing the resources
                    insertStmt.close();
                }

                // Closing the connection
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
        createButton.setStyle("-fx-background-color: yellow; -fx-text-fill: black; -fx-background-radius: 10px");
    }

    @FXML
    public void onCreateButtonExited(MouseEvent event) {
        createButton.setStyle("-fx-background-color: linear-gradient(to right, #00cc00, #00ff00); -fx-text-fill: black; -fx-background-radius: 10px");
    }

    @FXML
    public void oncallLoginEntered(MouseEvent event){
        callLogin.setStyle("-fx-underline: true;");
    }

    @FXML
    public void oncallLoginExited(MouseEvent event){
        callLogin.setStyle("-fx-underline: false;");
    }

    @FXML
    public void setCallLogin(MouseEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("login.fxml"));
            Parent root = fxmlLoader.load();
            Scene scene = new Scene(root, 800, 500);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("ArcadeHub | Login Account");
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