module com.example.proj_cokking {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.proj_cokking to javafx.fxml;
    exports com.example.proj_cokking;
}