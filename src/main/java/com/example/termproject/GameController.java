package com.example.termproject;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.util.Random;

public class GameController {
    private final double MAX_HEIGHT = 600;;
    private final double MAX_WIDTH = 800;

    private final Random randomCircleGenerator = new Random();
    @FXML
    private BorderPane gameWindow;
    @FXML
    private Circle bullsEye;
    @FXML
    private Pane pane;
    @FXML
    private Button button;

    @FXML
    private void changeLocation(){
        bullsEye.setFill(Color.BLACK);
        bullsEye.setCenterX(randomCircleGenerator.nextDouble(getXLowerBound(),getXUpperBound()));
        bullsEye.setCenterY(randomCircleGenerator.nextDouble(getYLowerBound(),getYUpperBound()));
    }
    private double getYUpperBound(){
        return MAX_HEIGHT-bullsEye.getRadius();
    }
    private double getYLowerBound(){
        return bullsEye.getRadius();
    }
    private double getXUpperBound(){
        return MAX_WIDTH -bullsEye.getRadius();
    }
    private double getXLowerBound(){
        return bullsEye.getRadius();
    }
}