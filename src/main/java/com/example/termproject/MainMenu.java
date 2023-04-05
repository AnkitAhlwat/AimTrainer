package com.example.termproject;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.util.Objects;

import static com.example.termproject.GameApplication.stage;

public class MainMenu extends Application {

    @FXML private Button startButton;
    @FXML private Button difficultyButton;
    @FXML private Button mapButton;
    @FXML private Button exitButton;

    public static String selectedMap = "spongebobhouse";

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
        primaryStage.setTitle("Main Menu");
        primaryStage.setScene(new Scene(root, 320, 600));
        primaryStage.show();
    }

    @FXML
    private void handleStartButtonAction() throws IOException {
        // handle start button action
        FXMLLoader fxmlLoader = new FXMLLoader(GameApplication.class.getResource("game-view-ankit.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1280 , 800);

        Parent root = fxmlLoader.getRoot();
        String backgroundImage = "-fx-background-image: url('" + selectedMap + ".jpg')";
        root.setStyle(backgroundImage);
        scene.setRoot(root);

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
    private void handleMapButtonAction() throws IOException {
        // handle map button action
        FXMLLoader fxmlLoaderMap = new FXMLLoader(GameApplication.class.getResource("ChangeMap.fxml"));
        Scene mapselection = new Scene(fxmlLoaderMap.load(), 1280, 800);
        stage.setScene(mapselection);
        stage.show();
    }

    @FXML
    private void handleExitButtonAction() {
        System.exit(0);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
