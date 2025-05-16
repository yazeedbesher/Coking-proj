package com.example.cooking_proj;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication {

    public static void main(String[] args) {

   Customer customer = new Customer(1221,"yazeed","talfeet","0595638731");
   customer.create_order();


    }
}