package com.example.termproject;

import javafx.application.Platform;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class InitPreloader implements Initializable {

    public Label loadlabel;
    public static Label loadlabell;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadlabell = loadlabel;
    }

    public String checkFunctions() throws InterruptedException {

        final String[] message = {""};
        Thread t1 = new Thread(() -> {
            message[0] = "Compiling Shaders...";
            Platform.runLater(() -> loadlabell.setText(message[0]));
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread t2 = new Thread(() -> {
            message[0] = "Loading Environment...";
            Platform.runLater(() -> loadlabell.setText(message[0]));
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread t3 = new Thread(() -> {
            message[0] = "Setting Targets...";
            Platform.runLater(() -> loadlabell.setText(message[0]));
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread t4 = new Thread(() -> {
            message[0] = "Calling Mike Pence...";
            Platform.runLater(() -> loadlabell.setText(message[0]));
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        t1.start();
        t1.join();
        t2.start();
        t2.join();
        t3.start();
        t3.join();
        t4.start();
        t4.join();

        return message[0];
    }


}
