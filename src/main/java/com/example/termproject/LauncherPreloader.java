package com.example.termproject;

import javafx.application.Preloader;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * The Launcher preloader.
 */
public class LauncherPreloader extends Preloader {

    private Stage preloaderStage;
    @Override
    public void start(Stage stage) throws Exception {
        this.preloaderStage = stage;
        Parent root = FXMLLoader.load(getClass().getResource("/com/example/termproject/initPreloader.fxml"));
        Scene scene = new Scene(root);
        stage.initStyle(StageStyle.UNDECORATED);
        Image logo = new Image("bullseye.png");
        stage.getIcons().add(logo);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void handleStateChangeNotification(StateChangeNotification info) {
        if(info.getType() == StateChangeNotification.Type.BEFORE_START){
            preloaderStage.hide();
        }
    }
}
