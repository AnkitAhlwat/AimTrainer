package com.example.termproject;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

import static com.example.termproject.GameApplication.stage;

public class MainMenu extends Application {

    @FXML private Button startButton;
    @FXML private Button difficultyButton;
    @FXML private Button mapButton;
    @FXML private Button exitButton;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
        primaryStage.setTitle("Main Menu");
        primaryStage.setScene(new Scene(root, 320, 600));
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.show();
    }

    @FXML
    private void handleStartButtonAction() throws IOException {
        // handle start button action
        FXMLLoader fxmlLoader = new FXMLLoader(GameApplication.class.getResource("game-view-ankit.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1280 , 800);
        Image logo = new Image("bullseye.png");
        stage.getIcons().add(logo);
        stage.setTitle("Aim Trainer");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void handleDifficultyButtonAction() {
        // handle difficulty button action
    }

    @FXML
    private void handleMapButtonAction() {
        // handle map button action
    }

    @FXML
    private void handleExitButtonAction() {
        System.exit(0);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
