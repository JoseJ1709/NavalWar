module com.example.navalwar {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires net.synedra.validatorfx;

    opens com.example.navalwar to javafx.fxml;
    exports com.example.navalwar;
}