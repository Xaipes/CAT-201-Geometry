package com.example.geometrygui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class HelloController {

    @FXML
    Button ruleButton, backButton,startButton;
    @FXML
    private Label validateMSG;
    @FXML
    private TextField enterPoints;
    @FXML
    private Button confirmPoint;

    int points;

    public void submit(ActionEvent event){

        try {
            points = Integer.parseInt(enterPoints.getText());

            if(points >= 6 || points <=0){
                validateMSG.setText("Please enter number between 0-6");
            }else{
                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("coord-view.fxml"));

                Stage window = (Stage)confirmPoint.getScene().getWindow();
                window.setScene(new Scene(fxmlLoader.load(), 600, 400));
            }
        }
        catch(NumberFormatException e){
            //System.out.print("Enter only number!");
            validateMSG.setText("Enter only number!");
        }
        catch(Exception e) {
            System.out.print(e);
        }
    }

    //Methods
    public void handlestartbtn() throws Exception {

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("points-view.fxml"));

        Stage window = (Stage)startButton.getScene().getWindow();
        window.setScene(new Scene(fxmlLoader.load(), 600, 400));

    }
    public void handlerulebtn() throws Exception {

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("rule-view.fxml"));

        Stage window = (Stage)ruleButton.getScene().getWindow();
        window.setScene(new Scene(fxmlLoader.load(), 600, 400));

    }
    public void handlebckbtn() throws Exception {

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));

        Stage window = (Stage)backButton.getScene().getWindow();
        window.setScene(new Scene(fxmlLoader.load(), 600, 400));
    }
}