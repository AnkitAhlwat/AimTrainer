package com.example.termproject;

import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.ImageCursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.shape.Rectangle;
import javafx.stage.Screen;

import java.io.File;
import java.io.IOException;
import java.util.Objects;
import java.util.Random;

import static com.example.termproject.GameApplication.stage;

/**
 * The Game controller.
 */
public class GameController {
    /**
     * The default size for cross-hair.
     */
    public static int size = 60;
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
    @FXML
    private Rectangle darkenBackground;

    private long startTime;
    private AnimationTimer animationTimer;
    private MediaPlayer mediaPlayer;
    private Image logo;

    private Image cursorImage = new Image("scope.png");


    @FXML
    private void initialize() {
        if (!Objects.equals(MainMenu.selectedMap, "spongebobhouse")){
            logo = new Image("target.png");
        }else {
            logo = new Image("patrick.png");
        }
        bullsEye.setRadius(size);
        setScore(0);
        setTotalClicks(0);
        scoreBoard.setVisible(false);
        darkenBackground.setVisible(false);
        bullsEye.setFill(new ImagePattern(logo));
        bullsEye.setCenterX(randomCircleGenerator.nextDouble(getXLowerBound(),getXUpperBound()));
        bullsEye.setCenterY(randomCircleGenerator.nextDouble(getYLowerBound(),getYUpperBound()));
        anchorPane.setCursor(new ImageCursor(cursorImage));
        timeLabel.setText("20");
        startTime = System.nanoTime();
        animationTimer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                long elapsedTime = (now - startTime) / 1_000_000_000;
                int time = 20 - (int) elapsedTime;
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
        if (Score == 5){
            playFiveStreakSound();
        } else if (Score == 12){
            playTwelveStreakSound();
        }else if (Score == 25){
            playTwentyStreakSound();
        }
        scoreLabel.setText(""+Score);
        bullsEye.setCenterX(randomCircleGenerator.nextDouble(getXLowerBound(),getXUpperBound()));
        bullsEye.setCenterY(randomCircleGenerator.nextDouble(getYLowerBound(),getYUpperBound()));
    }


    private void playSound(){
        Media sound = new Media(new File(musicFile).toURI().toString());
        mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.play();
    }
    private void playFiveStreakSound() {
        Media sound = new Media(new File("src/main/resources/missile.mp3").toURI().toString());
        mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.play();
    }
    private void playTwelveStreakSound() {
        Media sound = new Media(new File("src/main/resources/ac130.mp3").toURI().toString());
        mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.play();
    }
    private void playTwentyStreakSound() {
        Media sound = new Media(new File("src/main/resources/nuke.mp3").toURI().toString());
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
        darkenBackground.setVisible(true);
        targetsHit.setText(""+Score);
        targetsMissed.setText(""+(totalClicks - Score));
        accuracy.setText(""+ (Score * 100 / totalClicks) + "%");
        setScoreBoardText();
        mainMenu.setVisible(true);
        tryAgain.setVisible(true);
    }

    /**
     * Reset Game and score.
     */
    public void tryAgain() {
        initialize();
    }

    /**
     * Switch to main menu.
     *
     * @throws IOException the io exception
     */
    public void switchToMainMenu() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
        Scene scene = new Scene(root, 320, 600);
        Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
        stage.setX(0);
        stage.setY(0);
        double stageWidth = 320;
        double stageHeight = 600;
        stage.setX(screenBounds.getMinX() + (screenBounds.getWidth() - stageWidth) / 2);
        stage.setY(screenBounds.getMinY() + (screenBounds.getHeight() - stageHeight) / 2);
        stage.setScene(scene);
        stage.show();
    }
    private void setScoreBoardText() {
        if (Score == 0) {
            scoreBoardText.setText("Sucks to suck.");
        } else if (Score < 5) {
            Media sound = new Media(new File("src/main/resources/whatiseventhat.mp3").toURI().toString());
            mediaPlayer = new MediaPlayer(sound);
            mediaPlayer.play();
            scoreBoardText.setText("Wow, you're pretty bad.");
        } else if (Score < 12) {
            scoreBoardText.setText("Not bad, kid.");
        } else if (Score > 12) {
            scoreBoardText.setText("'Good Job' - Armani China");
            Media sound = new Media(new File("src/main/resources/success.mp3").toURI().toString());
            mediaPlayer = new MediaPlayer(sound);
            mediaPlayer.play();
        }
    }
    private int getScore() {
        return Score;
    }

    /**
     * Sets score.
     *
     * @param score the score
     */
    public void setScore(int score) {
        Score = score;
    }

    /**
     * Sets total clicks.
     *
     * @param totalClicks the total clicks
     */
    public void setTotalClicks(int totalClicks) {
        this.totalClicks = totalClicks;
    }
}