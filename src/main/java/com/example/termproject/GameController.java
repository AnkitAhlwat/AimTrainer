package com.example.termproject;

import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.scene.ImageCursor;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;
import java.util.Random;

public class GameController {
    private final double MAX_HEIGHT = 800;;
    private final double MAX_WIDTH = 1200;
    private int totalClicks = 0;

    private String musicFile = "src/main/resources/gunShotComp.mp3";

    private final Random randomCircleGenerator = new Random();
    private int Score = 0;
    @FXML
    private Label scoreLabel;
    @FXML
    private Label timeLabel;
    @FXML
    private Circle bullsEye;
    @FXML
    private Pane pane;

    @FXML
    private AnchorPane anchorPane;
    @FXML
    private Pane scoreBoard;
    @FXML
    private Label targetsHit;
    @FXML
    private Label targetsMissed;
    @FXML
    private Label accuracy;
    @FXML
    private Button mainMenu;
    @FXML
    private Button tryAgain;
    @FXML
    private Label scoreBoardText;

    private long startTime;
    private AnimationTimer animationTimer;
    private MediaPlayer mediaPlayer;
    Image logo = new Image("patrick.png");

    Image cursorImage = new Image("scope.png");


    @FXML
    private void initialize() {
        anchorPane.setCursor(new ImageCursor(cursorImage));
        timeLabel.setText("5");
        startTime = System.nanoTime();
        animationTimer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                long elapsedTime = (now - startTime) / 1_000_000_000;
                int time = 5 - (int) elapsedTime;
                timeLabel.setText(Integer.toString(time));

                if (time <= 0) {
                    animationTimer.stop();
                    displayScoreBoard();
                }
            }
        };
        animationTimer.start();
    }
    @FXML
    private void changeLocation(){
        playSound();
        Score++;
        scoreLabel.setText(""+Score);
        bullsEye.setFill(new ImagePattern(logo));
        bullsEye.setCenterX(randomCircleGenerator.nextDouble(getXLowerBound(),getXUpperBound()));
        bullsEye.setCenterY(randomCircleGenerator.nextDouble(getYLowerBound(),getYUpperBound()));
    }
    private void playSound(){
        Media sound = new Media(new File(musicFile).toURI().toString());
        mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.play();
    }
    private double getYUpperBound(){
        return MAX_HEIGHT-(bullsEye.getRadius()*2);
    }
    private double getYLowerBound(){
        return bullsEye.getRadius() + 100;
    }
    private double getXUpperBound(){
        return MAX_WIDTH -bullsEye.getRadius();
    }
    private double getXLowerBound(){
        return bullsEye.getRadius();
    }

    @FXML
    private void incrementCounter() {
        totalClicks++;
    }
    @FXML
    private void displayScoreBoard(){
        scoreBoard.setVisible(true);
        targetsHit.setText(""+Score);
        targetsMissed.setText(""+(totalClicks - Score));
        accuracy.setText(""+ (Score * 100 / totalClicks) + "%");
        scoreBoardText.setText("Game Over!");
        mainMenu.setVisible(true);
        tryAgain.setVisible(true);
    }

}