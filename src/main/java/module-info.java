module org.carrots.visualsort {
    requires javafx.controls;
    requires javafx.fxml;

    opens org.carrots.visualsort to javafx.controls;
    exports org.carrots.visualsort;
}