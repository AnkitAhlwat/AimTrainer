package com.example.termproject;

import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;

import java.util.Random;

public class GameController {
    private final double MAX_HEIGHT = 800;;
    private final double MAX_WIDTH = 1200;

    private final Random randomCircleGenerator = new Random();
    private int Score = 0;
    @FXML
    private Label scoreLabel;
    @FXML
    private Label timeLabel;
    @FXML
    private BorderPane gameWindow;
    @FXML
    private Circle bullsEye;
    @FXML
    private Pane pane;
    @FXML
    private Button button;
    private long startTime;
    private AnimationTimer animationTimer;
    Image logo = new Image("bullseye.png");
    @FXML
    private void changeLocation(){
        Score++;
        scoreLabel.setText(""+Score);
        bullsEye.setFill(new ImagePattern(logo));
        bullsEye.setCenterX(randomCircleGenerator.nextDouble(getXLowerBound(),getXUpperBound()));
        bullsEye.setCenterY(randomCircleGenerator.nextDouble(getYLowerBound(),getYUpperBound()));
    }
    @FXML
    private void initialize() {
        timeLabel.setText("60");

        startTime = System.nanoTime();
        animationTimer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                long elapsedTime = (now - startTime) / 1_000_000_000;
                int time = 60 - (int) elapsedTime;

                timeLabel.setText(Integer.toString(time));

                if (time <= 0) {
                    animationTimer.stop();
                }
            }
        };
        animationTimer.start();
    }
    private double getYUpperBound(){
        return MAX_HEIGHT-(bullsEye.getRadius()*2);
    }
    private double getYLowerBound(){
        return bullsEye.getRadius() + 50;
    }
    private double getXUpperBound(){
        return MAX_WIDTH -bullsEye.getRadius();
    }
    private double getXLowerBound(){
        return bullsEye.getRadius();
    }
}