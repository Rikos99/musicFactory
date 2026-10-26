module musicFactory {
    requires transitive javafx.controls;
    requires javafx.fxml;
    requires javafx.base;
    requires javafx.graphics;
    requires java.desktop;
    requires annotations;
    // requires com.fasterxml.jackson.databind;
    opens musicFactory to javafx.fxml;
    exports musicFactory;
}