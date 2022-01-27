/**
 *
 */
module com.example.geometry {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;


    opens com.example.geometry to javafx.fxml;
    exports com.example.geometry;
}