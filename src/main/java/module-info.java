module musicFactory {
    requires transitive javafx.controls;
    requires javafx.fxml;
    requires javafx.base;
    requires java.desktop;
    opens musicFactory to javafx.fxml;
    exports musicFactory;
}