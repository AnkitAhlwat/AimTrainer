package com.example.termproject;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class GameController {
    private final double MAX_LENGTH = 600;
    private final double MAX_WIDTH = 800;

    @FXML
    private BorderPane gameWindow;
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