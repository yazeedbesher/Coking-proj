package org.example.ahmad_project;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import javax.swing.*;

public class HelloController {
//    @FXML
//    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {

       // System.out.println("Hello World!");
        JOptionPane.showMessageDialog(null,"Ahmad Project");
       // welcomeText.setText("Welcome to JavaFX Application!");
    }
}