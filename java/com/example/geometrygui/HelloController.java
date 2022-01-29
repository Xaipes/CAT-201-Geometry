package com.example.geometrygui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
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
    @FXML
    private ImageView imgSuccess;

//    public ImageView getImgSuccess() {
//        return imgSuccess;
//    }

    int points;

    // SUBMITTING THE POINTS
    public void submit(ActionEvent event){

        try {
            points = Integer.parseInt(enterPoints.getText());

            if(points >= 6 || points <= 2){
                validateMSG.setText("Please enter number between 3-5");
            }else if(points == 3){
                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("coord3-view.fxml"));

                Stage window = (Stage)confirmPoint.getScene().getWindow();
                window.setScene(new Scene(fxmlLoader.load(), 600, 550));
            }else if(points == 4){
                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("coord4-view.fxml"));

                Stage window = (Stage)confirmPoint.getScene().getWindow();
                window.setScene(new Scene(fxmlLoader.load(), 600, 650));
            }else if(points == 5){
                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("coord5-view.fxml"));

                Stage window = (Stage)confirmPoint.getScene().getWindow();
                window.setScene(new Scene(fxmlLoader.load(), 600, 800));
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

    //HOMEPAGE START BUTTON
    public void handlestartbtn() throws Exception {

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("points-view.fxml"));

        Stage window = (Stage)startButton.getScene().getWindow();
        window.setScene(new Scene(fxmlLoader.load(), 600, 400));

    }

    //HOMEPAGE RULE BUTTON
    public void handlerulebtn() throws Exception {

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("rule-view.fxml"));

        Stage window = (Stage)ruleButton.getScene().getWindow();
        window.setScene(new Scene(fxmlLoader.load(), 600, 400));

    }

    //RULE PAGE BACK BUTTON
    public void handlebckbtn() throws Exception {

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));

        Stage window = (Stage)backButton.getScene().getWindow();
        window.setScene(new Scene(fxmlLoader.load(), 600, 400));
    }

    //INSERT COORDINATES
    public void enterCoordx(ActionEvent actionEvent) {
        //Validation
        //There is a label with #errorMSG
    }

    public void enterCoordy(ActionEvent actionEvent) {
        //Validation
        //There is a label with #errorMSG
    }

    public ImageView getImgSuccess(MouseEvent mouseEvent) {
        return imgSuccess;
    }
}