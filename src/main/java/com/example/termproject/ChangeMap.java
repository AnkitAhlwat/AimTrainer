package com.example.termproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import java.io.IOException;
import static com.example.termproject.GameApplication.stage;

public class ChangeMap {

    @FXML
    private Button backButton;

    @FXML
    private BorderPane nuketown;
    
    @FXML
    private BorderPane terminal;
    
    @FXML
    private BorderPane spongebobhouse;
    
    @FXML
    private BorderPane afghan;

    @FXML
    private AnchorPane anchorPane;

    public String selectedMap;


    @FXML
    void handleBackButton(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoadermm = new FXMLLoader(GameApplication.class.getResource("MainMenu.fxml"));
        Scene mainmenuscene = new Scene(fxmlLoadermm.load(), 320, 600);
        stage.setScene(mainmenuscene);
        stage.show();
    }
    @FXML
    public void setBorder(){
        nuketown.setStyle("-fx-border-color: white; -fx-border-width: 2");
    }

    @FXML
    public void clearBorder(){
        for(Node node : anchorPane.getChildren()){
            if(node instanceof BorderPane) {
                node.setStyle("-fx-border-width: 0");
            }
        }
    }

    @FXML
    private void handleBorderPaneClicked(MouseEvent event) {
        BorderPane clickedBorderPane = (BorderPane) event.getSource();
        selectedMap = clickedBorderPane.getId();
        MainMenu.selectedMap = selectedMap;
        clearBorder();
        clickedBorderPane.setStyle("-fx-border-color: white; -fx-border-width: 2");
    }


}

