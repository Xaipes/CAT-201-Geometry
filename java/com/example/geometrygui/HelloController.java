package com.example.geometrygui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    @FXML
    Button ruleButton, backButton,startButton;
    @FXML
    private Label validateMSG;
    @FXML
    private TextField enterPoints;
    @FXML
    private Button confirmPoint, homeButton;
    @FXML
    private ImageView imgSuccess, BckgroundView;
    @FXML
    private ChoiceBox x1,y1,x2,y2,x3,y3,x4,y4,x5,y5,x31,y31,x32,y32,x33,y33;

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


    //Connecting Back to homepage
    public void GoToHome(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));

        Stage window = (Stage)homeButton.getScene().getWindow();
        window.setScene(new Scene(fxmlLoader.load(), 600, 400));
    }

    //Setting ChoiceBox
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

//        x1.getItems().addAll(-10,-9,-8,-7,-6,-5,-4,-3,-2,-1,0,1,2,3,4,5,6,7,8,10);
//        y1.getItems().addAll(-10,-9,-8,-7,-6,-5,-4,-3,-2,-1,0,1,2,3,4,5,6,7,8,10);
//        x2.getItems().addAll(-10,-9,-8,-7,-6,-5,-4,-3,-2,-1,0,1,2,3,4,5,6,7,8,10);
//        y2.getItems().addAll(-10,-9,-8,-7,-6,-5,-4,-3,-2,-1,0,1,2,3,4,5,6,7,8,10);
//        x3.getItems().addAll(-10,-9,-8,-7,-6,-5,-4,-3,-2,-1,0,1,2,3,4,5,6,7,8,10);
//        y3.getItems().addAll(-10,-9,-8,-7,-6,-5,-4,-3,-2,-1,0,1,2,3,4,5,6,7,8,10);
//        x4.getItems().addAll(-10,-9,-8,-7,-6,-5,-4,-3,-2,-1,0,1,2,3,4,5,6,7,8,10);
//        y4.getItems().addAll(-10,-9,-8,-7,-6,-5,-4,-3,-2,-1,0,1,2,3,4,5,6,7,8,10);
//        x5.getItems().addAll(-10,-9,-8,-7,-6,-5,-4,-3,-2,-1,0,1,2,3,4,5,6,7,8,10);
//        y5.getItems().addAll(-10,-9,-8,-7,-6,-5,-4,-3,-2,-1,0,1,2,3,4,5,6,7,8,10);
        x31.getItems().addAll(-10,-9,-8,-7,-6,-5,-4,-3,-2,-1,0,1,2,3,4,5,6,7,8,10);
        y31.getItems().addAll(-10,-9,-8,-7,-6,-5,-4,-3,-2,-1,0,1,2,3,4,5,6,7,8,10);
        x32.getItems().addAll(-10,-9,-8,-7,-6,-5,-4,-3,-2,-1,0,1,2,3,4,5,6,7,8,10);
        y32.getItems().addAll(-10,-9,-8,-7,-6,-5,-4,-3,-2,-1,0,1,2,3,4,5,6,7,8,10);
        x33.getItems().addAll(-10,-9,-8,-7,-6,-5,-4,-3,-2,-1,0,1,2,3,4,5,6,7,8,10);
        y33.getItems().addAll(-10,-9,-8,-7,-6,-5,-4,-3,-2,-1,0,1,2,3,4,5,6,7,8,10);

    }
}