package com.example.termproject;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import static com.example.termproject.GameApplication.stage;

public class ChangeMap {

    @FXML
    private Button backButton;

    @FXML
    private BorderPane nuketown;


    @FXML
    void handleBackButton(ActionEvent event) throws IOException {
        // TODO: Handle back button click
        FXMLLoader fxmlLoadermm = new FXMLLoader(GameApplication.class.getResource("MainMenu.fxml"));
        Scene mainmenuscene = new Scene(fxmlLoadermm.load(), 320, 600);
        stage.setScene(mainmenuscene);
        stage.show();
    }
    @FXML
    public void setBorder(){
        nuketown.setStyle("-fx-border-color: red; -fx-border-width: 2");
    }


}

