module com.AMRB {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens com.AMRB to javafx.fxml;
    exports com.AMRB;
}