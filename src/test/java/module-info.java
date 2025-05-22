open module com.example.cooking_proj.test {
    requires com.example.cooking_proj;
    requires io.cucumber.java;
    requires junit;
    requires java.desktop;
    requires org.junit.jupiter.api;

    exports org.example.ahmad_project;

    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;
    requires io.cucumber.junit;
}