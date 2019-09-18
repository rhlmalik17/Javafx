package sample;

import javafx.fxml.FXML;

import java.awt.*;

public class Controller {
   @FXML
    private TextField nameField = new TextField();
    public void mymethod()
    {
        System.out.println("Hello"+nameField.getText());
    }
}
