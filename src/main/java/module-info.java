module com.example.man {
    requires javafx.controls;
    requires javafx.fxml;

    requires java.sql;
    requires com.jfoenix;


    opens com.example.man to javafx.fxml;
    exports com.example.man;
}