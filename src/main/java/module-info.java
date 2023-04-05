module com.example.termproject {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;


    opens com.example.termproject to javafx.fxml;
    exports com.example.termproject;
}