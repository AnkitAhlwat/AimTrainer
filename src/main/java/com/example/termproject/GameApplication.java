package com.example.termproject;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class GameApplication extends Application {

    public static Stage stage = null;
    public static Scene scene = null;

    @Override
    public void init() throws Exception {
        InitPreloader init = new InitPreloader();
        init.checkFunctions();
    }
    @Override
    public void start(Stage stage) throws IOException {
        GameApplication.stage = stage;
        FXMLLoader fxmlLoadermm = new FXMLLoader(GameApplication.class.getResource("MainMenu.fxml"));
        Scene mainmenuscene = new Scene(fxmlLoadermm.load(), 320, 600);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(mainmenuscene);
        stage.show();
    }

    public static void main(String[] args) {
        System.setProperty("javafx.preloader", LauncherPreloader.class.getName());
        launch(args);
    }
}
