package com.arcadehub.arcade_hub;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.effect.Bloom;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
//import static javafx.application.Application;

import java.io.IOException;

public class snake_controller {
    @FXML
    public ImageView go_back;
    private final Bloom bloom = new Bloom();
    @FXML
    public ImageView singleMode;
    @FXML
    public ImageView multiMode;
    @FXML
    public ImageView historyMode;
    @FXML
    public Label usernameID;
    @FXML
    public SnakeApp snakeGame;

    @FXML
    public void initialize() {
        // Set the bloom effect parameters
        bloom.setThreshold(0.3);
        // Add a mouse event handler to the back image button
        go_back.setOnMouseEntered(event -> {
            // Set the bloom effect to the button
            go_back.setEffect(bloom);
        });
        singleMode.setOnMouseEntered(event -> {
            // Set the bloom effect to the button
//            singleMode.setEffect(bloom);
            singleMode.setImage(new Image("C:\\Users\\DELL\\IdeaProjects\\Arcade_Hub\\src\\main\\resources\\com\\arcadehub\\arcade_hub_imgs\\singleButtonHover.png"));
        });
        multiMode.setOnMouseEntered(event -> {
            // Set the bloom effect to the button
//            multiMode.setEffect(bloom);
            multiMode.setImage(new Image("C:\\Users\\DELL\\IdeaProjects\\Arcade_Hub\\src\\main\\resources\\com\\arcadehub\\arcade_hub_imgs\\multiButtonHover.png"));
        });
        historyMode.setOnMouseEntered(event -> {
            // Set the bloom effect to the button
//            historyMode.setEffect(bloom);
            historyMode.setImage(new Image("C:\\Users\\DELL\\IdeaProjects\\Arcade_Hub\\src\\main\\resources\\com\\arcadehub\\arcade_hub_imgs\\gameHistoryHover.png"));
        });

        // Add on mouse exit all events.
        go_back.setOnMouseExited(event -> {
            // Remove the effect from the button
            go_back.setEffect(null);
        });
        singleMode.setOnMouseExited(event -> {
            // Remove the effect from the button
            singleMode.setEffect(null);
            singleMode.setImage(new Image("C:\\Users\\DELL\\IdeaProjects\\Arcade_Hub\\src\\main\\resources\\com\\arcadehub\\arcade_hub_imgs\\singleButton.png"));
        });
        multiMode.setOnMouseExited(event -> {
            // Remove the effect from the button
            multiMode.setEffect(null);
            multiMode.setImage(new Image("C:\\Users\\DELL\\IdeaProjects\\Arcade_Hub\\src\\main\\resources\\com\\arcadehub\\arcade_hub_imgs\\multiButton.png"));
        });
        historyMode.setOnMouseExited(event -> {
            // Remove the effect from the button
            historyMode.setEffect(null);
            historyMode.setImage(new Image("C:\\Users\\DELL\\IdeaProjects\\Arcade_Hub\\src\\main\\resources\\com\\arcadehub\\arcade_hub_imgs\\gameHistory.png"));
        });

        usernameID.setText(login_controller.usernamevalue);
        usernameID.setOnMouseEntered(event -> {
            usernameID.setEffect(bloom);
        });
        usernameID.setOnMouseExited(event -> {
            usernameID.setEffect(bloom);
        });
    }

    public void call_back(MouseEvent event) {
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

    public void call_single(MouseEvent event) {
        System.out.println("single Mode is called !");
    }

    public void call_multi(MouseEvent event) {
        System.out.println("Multiplayer Mode is called !");
    }

    public void call_history(MouseEvent event) {
        System.out.println("Game History is called !");
    }
}
