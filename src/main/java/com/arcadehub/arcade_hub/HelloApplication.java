package com.arcadehub.arcade_hub;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("sign_up.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 500);
        stage.setTitle("ArcadeHub | Create Account");
        stage.setScene(scene);
//        adding the icon to the stage here.
        stage.getIcons().add(new Image("C:\\Users\\DELL\\IdeaProjects\\Arcade_Hub\\src\\main\\resources\\com\\arcadehub\\arcade_hub_imgs\\iconfile.png"));
        stage.setResizable(false);
        stage.show();
    }
    public static void main(String[] args) {
        launch();
    }
}