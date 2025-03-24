module org.example.ahmad_project {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.ahmad_project to javafx.fxml;
    exports org.example.ahmad_project;
}