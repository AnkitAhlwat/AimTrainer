package com.example.termproject;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class GameController {
    private final int MAX_LENGTH = 800;
    private final int MAX_WIDTH = 600;
    @FXML
    private Label welcomeText;
    @FXML
    private Circle bullsEye;
    @FXML
    private Pane pane;
    @FXML
    private Button button;

    @FXML
    protected void onHelloButtonClick() {
        button.setVisible(false);
        bullsEye.setVisible(true);
    }
    @FXML
    protected void changeLocation(){
        bullsEye.setFill(Color.BLACK);
        bullsEye.setCenterX(Math.random()*MAX_LENGTH);
        bullsEye.setCenterY(Math.random()*MAX_WIDTH);
    }
}