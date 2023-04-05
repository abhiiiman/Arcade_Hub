module com.arcadehub.arcade_hub {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires mysql.connector.j;
    requires java.desktop;


    opens com.arcadehub.arcade_hub to javafx.fxml;
    exports com.arcadehub.arcade_hub;
}