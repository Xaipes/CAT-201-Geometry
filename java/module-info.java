module com.example.geometrygui {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.geometrygui to javafx.fxml;
    exports com.example.geometrygui;
}