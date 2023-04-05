package com.example.termproject;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Screen;
import javafx.stage.Stage;
import java.io.IOException;

import static com.example.termproject.GameApplication.stage;

public class MainMenu extends Application {
    private MediaPlayer mediaPlayer;

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

        Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
        stage.setX(0);
        stage.setY(0);
        double stageWidth = 1280;
        double stageHeight = 800;
        stage.setX(screenBounds.getMinX() + (screenBounds.getWidth() - stageWidth) / 2);
        stage.setY(screenBounds.getMinY() + (screenBounds.getHeight() - stageHeight) / 2);

        Image logo = new Image("bullseye.png");
        stage.getIcons().add(logo);
        stage.setTitle("Aim Trainer");
        stage.setScene(scene);
        stage.show();
        GameApplication.mediaPlayerMM.stop();
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

        Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
        stage.setX(0);
        stage.setY(0);
        double stageWidth = 1280;
        double stageHeight = 800;
        stage.setX(screenBounds.getMinX() + (screenBounds.getWidth() - stageWidth) / 2);
        stage.setY(screenBounds.getMinY() + (screenBounds.getHeight() - stageHeight) / 2);

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
