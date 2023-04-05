package com.arcadehub.arcade_hub;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.effect.Bloom;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Optional;

public class menu_controller {
    @FXML
    private ImageView logout;
    @FXML
    private ImageView avatar;
    @FXML
    private AnchorPane frame1;
    @FXML
    private ImageView frameimage1;
    @FXML
    private AnchorPane frame2;
    @FXML
    private ImageView frameimage2;
    @FXML
    private AnchorPane frame3;
    @FXML
    private ImageView frameimage3;
    @FXML
    private Label username;
    private Bloom bloom = new Bloom();

    @FXML
    public void initialize() {
//        set the username.
//        System.out.println(username);
        username.setText(login_controller.usernamevalue);
//        System.out.println(username);

        // Set the bloom effect parameters
        bloom.setThreshold(0.3);

        // Add a mouse event handler to the logout image button
        logout.setOnMouseEntered(event -> {
            // Set the bloom effect to the button
            logout.setEffect(bloom);
        });

        // Add a mouse event handler to the avatar image
        avatar.setOnMouseEntered(event -> {
            // Set the bloom effect to the button
            avatar.setEffect(bloom);
        });

        // Add a mouse event handler to the username text.
        username.setOnMouseEntered(event -> {
            // Set the bloom effect to the button
            username.setEffect(bloom);
        });

        frame1.setOnMouseEntered(event -> {
            // Set the bloom effect to the button
            frame1.setEffect(bloom);
//            frameimage1.setEffect(new Reflection());
        });

        frame2.setOnMouseEntered(event -> {
            // Set the bloom effect to the button
            frame2.setEffect(bloom);
//            frameimage2.setEffect(new Reflection());
        });

        frame3.setOnMouseEntered(event -> {
            // Set the bloom effect to the button
            frame3.setEffect(bloom);
//            frameimage3.setEffect(new Reflection());
        });
//on mouse exit all events.
        logout.setOnMouseExited(event -> {
            // Remove the effect from the button
            logout.setEffect(null);
        });

        avatar.setOnMouseExited(event -> {
            // Remove the effect from the button
            avatar.setEffect(null);
        });

        username.setOnMouseExited(event -> {
            // Remove the effect from the button
            username.setEffect(null);
        });

        frame1.setOnMouseExited(event -> {
            // Remove the effect from the button
            frame1.setEffect(null);
//            frameimage1.setEffect(null);
        });

        frame2.setOnMouseExited(event -> {
            // Remove the effect from the button
            frame2.setEffect(null);
//            frameimage2.setEffect(null);
        });

        frame3.setOnMouseExited(event -> {
            // Remove the effect from the button
            frame3.setEffect(null);
//            frameimage3.setEffect(null);
        });
    }

    Alert alert;
    public void logOut(MouseEvent event) {
        alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("ArcadeHub");
        alert.setHeaderText("Logout Requested");
        alert.setContentText("You're about to Logout now!");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
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
                ((Node) (event.getSource())).getScene().getWindow().hide();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
//        else do nothing stay in the menu page.
    }

    public void call_snake(MouseEvent event) {
        System.out.println("Snake Game is Started...");
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("snake.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 800, 500);
            Stage stage = new Stage();
            stage.setTitle("ArcadeHub | Snake Game");
            stage.setScene(scene);
//        adding the icon to the stage here.
            stage.getIcons().add(new Image("C:\\Users\\DELL\\IdeaProjects\\Arcade_Hub\\src\\main\\resources\\com\\arcadehub\\arcade_hub_imgs\\iconfile.png"));
            stage.setResizable(false);
            stage.show();

            // Close the parent window
            ((Node) (event.getSource())).getScene().getWindow().hide();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
    public void call_tictactoe(MouseEvent event) {
        System.out.println("Tic-Tac-Toe Game is Started...");
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("tictactoe.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 800, 500);
            Stage stage = new Stage();
            stage.setTitle("ArcadeHub | Tic Tac Toe Game");
            stage.setScene(scene);
//        adding the icon to the stage here.
            stage.getIcons().add(new Image("C:\\Users\\DELL\\IdeaProjects\\Arcade_Hub\\src\\main\\resources\\com\\arcadehub\\arcade_hub_imgs\\iconfile.png"));
            stage.setResizable(false);
            stage.show();

            // Close the parent window
            ((Node) (event.getSource())).getScene().getWindow().hide();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public void call_sps(MouseEvent event) {
        System.out.println("Rock Paper Scissor Game is Started...");
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("sps.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 800, 500);
            Stage stage = new Stage();
            stage.setTitle("ArcadeHub | Rock Paper Scissor Game");
            stage.setScene(scene);
//        adding the icon to the stage here.
            stage.getIcons().add(new Image("C:\\Users\\DELL\\IdeaProjects\\Arcade_Hub\\src\\main\\resources\\com\\arcadehub\\arcade_hub_imgs\\iconfile.png"));
            stage.setResizable(false);
            stage.show();

            // Close the parent window
            ((Node) (event.getSource())).getScene().getWindow().hide();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
