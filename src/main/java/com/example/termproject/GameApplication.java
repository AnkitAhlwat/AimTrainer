package com.example.termproject;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

/**
 * The main Game application.
 */
public class GameApplication extends Application {

    /**
     * The Media player.
     */
    static MediaPlayer mediaPlayerMM;
    /**
     * The constant stage.
     */
    public static Stage stage = null;
    /**
     * The constant scene.
     */
    public static Scene scene = null;

    @Override
    public void init() throws Exception {
        InitPreloader init = new InitPreloader();
        init.checkFunctions();
    }
    @Override
    public void start(Stage stage) throws IOException {
        GameApplication.stage = stage;
        playMusic();
        FXMLLoader fxmlLoadermm = new FXMLLoader(GameApplication.class.getResource("MainMenu.fxml"));
        Scene mainmenuscene = new Scene(fxmlLoadermm.load(), 320, 600);
        stage.setScene(mainmenuscene);
        stage.show();

    }
    private void playMusic() {
        String musicFile = "src/main/resources/mainMenu.mp3";
        Media sound = new Media(new File(musicFile).toURI().toString());
        mediaPlayerMM = new MediaPlayer(sound);
        mediaPlayerMM.play();
        mediaPlayerMM.setCycleCount(5);
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        System.setProperty("javafx.preloader", LauncherPreloader.class.getName());
        launch(args);
    }
}
