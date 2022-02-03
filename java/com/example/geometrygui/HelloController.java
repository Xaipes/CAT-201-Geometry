package com.example.geometrygui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;


public class HelloController {

    //Create the player object
    static Player player_1 = new Player();

    //Create variables to check the number of rounds
    static int round_number = 1;
    static int translation_round_number = 4;
    static int scaling_round_number = 4;
    static int reflection_round_number = 4;
    static int rotation_round_number = 4;


    //Declare JavaFX objects
    @FXML
    private Label validateMSG, score, errorMSG;
    @FXML
    private TextField enterPoints, enterXaxis, enterYaxis, enterScaleVal, enterAxisVal;
    @FXML
    private TextField enterCoordx1, enterCoordx2, enterCoordx3, enterCoordx4;
    @FXML
    private TextField enterCoordy1, enterCoordy2, enterCoordy3, enterCoordy4;
    @FXML
    private Button ruleButton, backButton,startButton,homeButton, coordButton, confirmPoint, translationCheck, scalingCheck, reflectionCheck, rotationCheck;
    @FXML
    private MenuButton reflectedOnBtn, rotationBtn;
//    @FXML
//    private ImageView imgSuccess, BckgroundView;
//    @FXML
//    private Label translateOriX,translateOriY,translateImgX,translateImgY;
//    @FXML
//    private Label scaleOriX,scaleOriY,scaleImgX,scaleImgY;
//    @FXML
//    private Label rotateOriX,rotateImgX, rotateOriY,rotateImgY;
//    @FXML
//    private Label reflectOriX,reflectImgX,reflectOriY,reflectImgY;
//    @FXML
//    private TableView<String> TransTable;
//
//    @FXML
//    private TableColumn<Player, Integer> TransX, TransXImg,TransY,TransYImg;


    @FXML
    private static LineChart CartesianPlane;

    //HOMEPAGE START BUTTON
    public void handlestartbtn() throws Exception {

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("coord4-view.fxml"));

        Stage window = (Stage)startButton.getScene().getWindow();
        window.setScene(new Scene(fxmlLoader.load(), 600, 650));

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

    //REFLECTION MENU BUTTON X-AXIS
    public void handleX() throws Exception {
        reflectedOnBtn.setText("X-Axis");
    }
    //REFLECTION MENU BUTTON X-AXIS
    public void handleY() throws Exception {
        reflectedOnBtn.setText("Y-Axis");
    }

    //ROTATION MENU BUTTON 90 DEGREES
    public void handle90() throws Exception {
        rotationBtn.setText("90 Degrees");
    }
    //ROTATION MENU BUTTON 90 DEGREES
    public void handle180() throws Exception {
        rotationBtn.setText("180 Degrees");
    }
    //ROTATION MENU BUTTON 90 DEGREES
    public void handle270() throws Exception {
        rotationBtn.setText("270 Degrees");
    }

    //START TRANSLATION ROUND
    public void handlecoordButton() throws Exception {

        int coordx1,coordx2,coordx3,coordx4;
        int coordy1,coordy2,coordy3,coordy4;
        //errorMSG
        try{
            //Check x-axis value
            coordx1 = Integer.parseInt(enterCoordx1.getText());
            coordx2 = Integer.parseInt(enterCoordx1.getText());
            coordx3 = Integer.parseInt(enterCoordx1.getText());
            coordx4 = Integer.parseInt(enterCoordx1.getText());

            //Check y-axis value
            coordy1 = Integer.parseInt(enterCoordy1.getText());
            coordy2 = Integer.parseInt(enterCoordy2.getText());
            coordy3 = Integer.parseInt(enterCoordy3.getText());
            coordy4 = Integer.parseInt(enterCoordy4.getText());

            if( coordx1 < -10 || coordx1 > 10 || coordx2 < -10 || coordx2 > 10 || coordx3 < -10 || coordx3 > 10 || coordx4 < -10  || coordx4 > 10 ||
                    coordy1 < -10 || coordy1 > 10 || coordy2 < -10 || coordy2 > 10 || coordy3 < -10 || coordy3 > 10 || coordy4 < -10 || coordy4 > 10){
                errorMSG.setText("Enter only s from -10 to 10 only!");
            } else {
                //Update the coordinates of the original and image shape
                coordinates_input(coordx1, coordy1, HelloApplication.get_plot_x(), HelloApplication.get_plot_y(), HelloApplication.get_plot_x_image(), HelloApplication.get_plot_y_image());
                coordinates_input(coordx2, coordy2, HelloApplication.get_plot_x(), HelloApplication.get_plot_y(), HelloApplication.get_plot_x_image(), HelloApplication.get_plot_y_image());
                coordinates_input(coordx3, coordy3, HelloApplication.get_plot_x(), HelloApplication.get_plot_y(), HelloApplication.get_plot_x_image(), HelloApplication.get_plot_y_image());
                coordinates_input(coordx4, coordy4, HelloApplication.get_plot_x(), HelloApplication.get_plot_y(), HelloApplication.get_plot_x_image(), HelloApplication.get_plot_y_image());

                //Set the number of points to 4
                HelloApplication.set_number_of_points(4);

                //Generate a random number between -10 and 10
                HelloApplication.set_rand_1(-10, 10);
                HelloApplication.set_rand_2(-10, 10);

                //Update the coordinates of the image shape for the first translation round
                translation(HelloApplication.get_rand_1(), HelloApplication.get_rand_2(), HelloApplication.get_number_of_points(), HelloApplication.get_plot_x_image(), HelloApplication.get_plot_y_image());

                System.out.print(HelloApplication.get_plot_x());
                System.out.print(HelloApplication.get_plot_y());
                System.out.print("\n");
                System.out.print(HelloApplication.get_plot_x_image());
                System.out.print(HelloApplication.get_plot_y_image());
                System.out.print("\n");


                //Display the graph and request answers
                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("translation-view.fxml"));
                Stage window = (Stage)coordButton.getScene().getWindow();
                window.setScene(new Scene(fxmlLoader.load(), 600, 400));
            }

        } catch(NumberFormatException e){
        //System.out.print("Enter only number!");
        errorMSG.setText("Enter only number!");
        }
            catch(Exception e) {
            System.out.print(e);
        }

    }

    //TRANSLATION ANSWER CHECK AND NEXT ROUND
    public void handletranslationCheck() throws Exception {

        //Launch Translation Levels again until total rounds has been reached
        if (round_number < translation_round_number)
        {
            //Check user's answers for translation
            translation_rounds(Integer.parseInt(enterXaxis.getText()), Integer.parseInt(enterYaxis.getText()), HelloApplication.get_rand_1(), HelloApplication.get_rand_2(), HelloApplication.get_number_of_points(), HelloApplication.get_plot_x(), HelloApplication.get_plot_y(), HelloApplication.get_plot_x_image(), HelloApplication.get_plot_y_image());

            System.out.print(player_1.get_player_score());

            //Generate new set of rng values for the next translation round
            HelloApplication.set_rand_1(-10, 10);
            HelloApplication.set_rand_2(-10, 10);

            //Generate new translated image
            translation(HelloApplication.get_rand_1(), HelloApplication.get_rand_2(), HelloApplication.get_number_of_points(), HelloApplication.get_plot_x_image(), HelloApplication.get_plot_y_image());

            //Increase the round counter for the next round
            round_number = round_number + 1;

            //Display the translation scene again
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("translation-view.fxml"));
            Stage window = (Stage)translationCheck.getScene().getWindow();
            window.setScene(new Scene(fxmlLoader.load(), 600, 400));

            // translateOriX.setText(Integer.toString(HelloApplication.get_plot_x()));
            // translateOriY.setText(Integer.toString(HelloApplication.get_plot_y()));
            // translateImgX.setText(Integer.toString(HelloApplication.get_plot_x_image()));
            // translateImgY.setText(Integer.toString(HelloApplication.get_plot_y_image()));

//            ObservableList<Player> list = FXCollections.observableArrayList(
//                    new Player(HelloApplication.get_plot_x().get(0), HelloApplication.get_plot_y().get(0)),
//                    new Player(HelloApplication.get_plot_x().get(1), HelloApplication.get_plot_y().get(1)),
//                    new Player(HelloApplication.get_plot_x().get(2), HelloApplication.get_plot_y().get(2)),
//                    new Player(HelloApplication.get_plot_x().get(3), HelloApplication.get_plot_y().get(3)),
//            );
//
//            TransX.setCellValueFactory(new PropertyValueFactory<Player,Integer>("plot_x"));
//            TransY.setCellValueFactory(new PropertyValueFactory<Player,Integer>("plot_y"));
//            TransXImg.setCellValueFactory(new PropertyValueFactory<Player,Integer>("plot_x_image"));
//            TransYImg.setCellValueFactory(new PropertyValueFactory<Player,Integer>("plot_y_image"));
//

            // System.out.print(HelloApplication.get_plot_x());
            // System.out.print(HelloApplication.get_plot_y());
            // System.out.print("\n");
            // System.out.print(HelloApplication.get_plot_x_image());
            // System.out.print(HelloApplication.get_plot_y_image());
            // System.out.print("\n");

        }
        else
        {
            //Check user's answers for translation
            translation_rounds(Integer.parseInt(enterXaxis.getText()), Integer.parseInt(enterYaxis.getText()), HelloApplication.get_rand_1(), HelloApplication.get_rand_2(), HelloApplication.get_number_of_points(), HelloApplication.get_plot_x(), HelloApplication.get_plot_y(), HelloApplication.get_plot_x_image(), HelloApplication.get_plot_y_image());

            System.out.print(player_1.get_player_score());

            //Generate new set of rng values for scaling round
            HelloApplication.set_rand_1(-3, 3);

            //Apply the rng scale factor to the image coordinates
            scaling(HelloApplication.get_rand_1(), HelloApplication.get_plot_x().get(0), HelloApplication.get_plot_y().get(0), HelloApplication.get_number_of_points(), HelloApplication.get_plot_x_image(), HelloApplication.get_plot_y_image());

            //reset the round number
            round_number = 1;

            System.out.print(HelloApplication.get_plot_x());
            System.out.print(HelloApplication.get_plot_y());
            System.out.print("\n");
            System.out.print(HelloApplication.get_plot_x_image());
            System.out.print(HelloApplication.get_plot_y_image());
            System.out.print("\n");

            //Display the scaling scene
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("scaling-view.fxml"));
            Stage window = (Stage)translationCheck.getScene().getWindow();
            window.setScene(new Scene(fxmlLoader.load(), 600, 400));

        }
    }

    //SCALING ANSWER CHECK AND NEXT ROUND
    public void handlescalingCheck() throws Exception {

        //Launch Scaling Levels again until total rounds has been reached
        if (round_number < scaling_round_number)
        {
            //Check user's answers for scaling
            scaling_rounds(Integer.parseInt(enterScaleVal.getText()), HelloApplication.get_rand_1(), HelloApplication.get_number_of_points(), HelloApplication.get_plot_x(), HelloApplication.get_plot_y(), HelloApplication.get_plot_x_image(), HelloApplication.get_plot_y_image());

            System.out.print(player_1.get_player_score());

            //Generate new value for scaling
            HelloApplication.set_rand_1(-3, 3);

            //Generate new scaled image
            scaling(HelloApplication.get_rand_1(), HelloApplication.get_plot_x().get(0), HelloApplication.get_plot_y().get(0), HelloApplication.get_number_of_points(), HelloApplication.get_plot_x_image(), HelloApplication.get_plot_y_image());

            //Increase the round counter for the next round
            round_number = round_number + 1;

            //Display the scaling scene again
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("scaling-view.fxml"));
            Stage window = (Stage)scalingCheck.getScene().getWindow();
            window.setScene(new Scene(fxmlLoader.load(), 600, 400));

            System.out.print(HelloApplication.get_plot_x());
            System.out.print(HelloApplication.get_plot_y());
            System.out.print("\n");
            System.out.print(HelloApplication.get_plot_x_image());
            System.out.print(HelloApplication.get_plot_y_image());
            System.out.print("\n");

        }
        else
        {
            //Check user's answers for scaling
            scaling_rounds(Integer.parseInt(enterScaleVal.getText()), HelloApplication.get_rand_1(), HelloApplication.get_number_of_points(), HelloApplication.get_plot_x(), HelloApplication.get_plot_y(), HelloApplication.get_plot_x_image(), HelloApplication.get_plot_y_image());

            System.out.print(player_1.get_player_score());

            //Generate new set of rng values for reflection round
            HelloApplication.set_rand_1(-10, 10);
            HelloApplication.set_rand_2(0, 1);

            //Apply the reflection to the image coordinates
            reflection(HelloApplication.get_rand_1(), HelloApplication.get_rand_2(), HelloApplication.get_number_of_points(), HelloApplication.get_plot_x_image(), HelloApplication.get_plot_y_image());

            //reset the round number
            round_number = 1;

            System.out.print(HelloApplication.get_plot_x());
            System.out.print(HelloApplication.get_plot_y());
            System.out.print("\n");
            System.out.print(HelloApplication.get_plot_x_image());
            System.out.print(HelloApplication.get_plot_y_image());
            System.out.print("\n");

            //Display the reflection scene
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("reflection-view.fxml"));
            Stage window = (Stage)scalingCheck.getScene().getWindow();
            window.setScene(new Scene(fxmlLoader.load(), 600, 400));

        }
    }

    //REFLECTION ANSWER CHECK AND NEXT ROUND
    public void handlereflectionCheck() throws Exception {

        //Launch Reflection Levels again until total rounds has been reached
        if (round_number < reflection_round_number)
        {
            //Check user's answers for reflection
            if (reflectedOnBtn.getText() == "Y-Axis")
                reflection_rounds(Integer.parseInt(enterAxisVal.getText()), 0,  HelloApplication.get_number_of_points(), HelloApplication.get_plot_x(), HelloApplication.get_plot_y(), HelloApplication.get_plot_x_image(), HelloApplication.get_plot_y_image());
            else
                reflection_rounds(Integer.parseInt(enterAxisVal.getText()), 1,  HelloApplication.get_number_of_points(), HelloApplication.get_plot_x(), HelloApplication.get_plot_y(), HelloApplication.get_plot_x_image(), HelloApplication.get_plot_y_image());

            System.out.print(player_1.get_player_score());

            //Generate new values for reflection
            HelloApplication.set_rand_1(-10, 10);
            HelloApplication.set_rand_2(0, 1);

            //Apply the reflection to the image coordinates
            reflection(HelloApplication.get_rand_1(), HelloApplication.get_rand_2(), HelloApplication.get_number_of_points(), HelloApplication.get_plot_x_image(), HelloApplication.get_plot_y_image());

            //Increase the round counter for the next round
            round_number = round_number + 1;

            //Display the reflection scene again
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("reflection-view.fxml"));
            Stage window = (Stage)reflectionCheck.getScene().getWindow();
            window.setScene(new Scene(fxmlLoader.load(), 600, 400));

            System.out.print(HelloApplication.get_plot_x());
            System.out.print(HelloApplication.get_plot_y());
            System.out.print("\n");
            System.out.print(HelloApplication.get_plot_x_image());
            System.out.print(HelloApplication.get_plot_y_image());
            System.out.print("\n");

        }
        else
        {

            //Check user's answers for reflection
            if (reflectedOnBtn.getText() == "Y-Axis")
                reflection_rounds(Integer.parseInt(enterAxisVal.getText()), 0, HelloApplication.get_number_of_points(),  HelloApplication.get_plot_x(), HelloApplication.get_plot_y(), HelloApplication.get_plot_x_image(), HelloApplication.get_plot_y_image());
            else
                reflection_rounds(Integer.parseInt(enterAxisVal.getText()), 1, HelloApplication.get_number_of_points(),  HelloApplication.get_plot_x(), HelloApplication.get_plot_y(), HelloApplication.get_plot_x_image(), HelloApplication.get_plot_y_image());

            System.out.print(player_1.get_player_score());

            //Generate new set of rng values for rotation round
            HelloApplication.set_rand_1(1, 3);

            //Apply the rotation to the image coordinates
            rotation(HelloApplication.get_rand_1() * 90, HelloApplication.get_number_of_points(), HelloApplication.get_plot_x_image(), HelloApplication.get_plot_y_image());

            //reset the round number
            round_number = 1;

            System.out.print(HelloApplication.get_plot_x());
            System.out.print(HelloApplication.get_plot_y());
            System.out.print("\n");
            System.out.print(HelloApplication.get_plot_x_image());
            System.out.print(HelloApplication.get_plot_y_image());
            System.out.print("\n");

            //Display the rotation scene
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("rotation-view.fxml"));
            Stage window = (Stage)reflectionCheck.getScene().getWindow();
            window.setScene(new Scene(fxmlLoader.load(), 600, 400));

        }
    }

    //ROTATION ANSWER CHECK AND NEXT ROUND
    public void handlerotationCheck() throws Exception {

        //Launch Rotation Levels again until total rounds has been reached
        if (round_number < rotation_round_number)
        {
            //Check user's answers for rotation
            if (rotationBtn.getText() == "90 Degrees")
                rotation_rounds(1, HelloApplication.get_number_of_points(), HelloApplication.get_plot_x(), HelloApplication.get_plot_y(), HelloApplication.get_plot_x_image(), HelloApplication.get_plot_y_image());
            else if (rotationBtn.getText() == "180 Degrees")
                rotation_rounds(2, HelloApplication.get_number_of_points(), HelloApplication.get_plot_x(), HelloApplication.get_plot_y(), HelloApplication.get_plot_x_image(), HelloApplication.get_plot_y_image());
            else
                rotation_rounds(3, HelloApplication.get_number_of_points(), HelloApplication.get_plot_x(), HelloApplication.get_plot_y(), HelloApplication.get_plot_x_image(), HelloApplication.get_plot_y_image());

            System.out.print(player_1.get_player_score());

            //Generate new values for rotation
            HelloApplication.set_rand_1(1, 3);

            //Apply the rotation to the image coordinates
            rotation(HelloApplication.get_rand_1() * 90, HelloApplication.get_number_of_points(), HelloApplication.get_plot_x_image(), HelloApplication.get_plot_y_image());

            //Increase the round counter for the next round
            round_number = round_number + 1;

            //Display the rotation scene again
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("rotation-view.fxml"));
            Stage window = (Stage)rotationCheck.getScene().getWindow();
            window.setScene(new Scene(fxmlLoader.load(), 600, 400));

            System.out.print(HelloApplication.get_plot_x());
            System.out.print(HelloApplication.get_plot_y());
            System.out.print("\n");
            System.out.print(HelloApplication.get_plot_x_image());
            System.out.print(HelloApplication.get_plot_y_image());
            System.out.print("\n");

        }
        else
        {
            //Check user's answers for rotation
            if (rotationBtn.getText() == "90 Degrees")
                rotation_rounds(1, HelloApplication.get_number_of_points(), HelloApplication.get_plot_x(), HelloApplication.get_plot_y(), HelloApplication.get_plot_x_image(), HelloApplication.get_plot_y_image());
            else if (rotationBtn.getText() == "180 Degrees")
                rotation_rounds(2, HelloApplication.get_number_of_points(), HelloApplication.get_plot_x(), HelloApplication.get_plot_y(), HelloApplication.get_plot_x_image(), HelloApplication.get_plot_y_image());
            else
                rotation_rounds(3, HelloApplication.get_number_of_points(), HelloApplication.get_plot_x(), HelloApplication.get_plot_y(), HelloApplication.get_plot_x_image(), HelloApplication.get_plot_y_image());

            //Update the score label
            score.setText(Integer.toString(player_1.get_player_score()));

            //Display the final scene
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("final-view.fxml"));
            Stage window = (Stage)rotationCheck.getScene().getWindow();
            window.setScene(new Scene(fxmlLoader.load(), 600, 400));

        }
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

    //Connecting Back to homepage
    public void GoToHome(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));

        Stage window = (Stage)homeButton.getScene().getWindow();
        window.setScene(new Scene(fxmlLoader.load(), 600, 400));
    }

    //Method to Receive Coordinates Input
    public static void coordinates_input(int temp_x, int temp_y, ArrayList<Integer> plot_x_alt, ArrayList<Integer> plot_y_alt, ArrayList<Integer> plot_x_image_alt, ArrayList<Integer> plot_y_image_alt)
    {
        //Assign the entered x coordinate values
        plot_x_alt.add(temp_x);
        plot_x_image_alt.add(temp_x);

        //Assign the entered y coordinate values
        plot_y_alt.add(temp_y);
        plot_y_image_alt.add(temp_y);

    }

    //Method for Resetting Image Coordinates
    public static void reset_image(int number_of_points_alt, ArrayList<Integer> plot_x_alt, ArrayList<Integer> plot_y_alt, ArrayList<Integer> plot_x_image_alt, ArrayList<Integer> plot_y_image_alt)
    {

        //Create a loop to update the coordinates of all points based on the original shape
        for(int i = 0; i < number_of_points_alt; i++)
        {
            //Update x coordinates
            plot_x_image_alt.set(i, plot_x_alt.get(i));

            //Update y coordinates
            plot_y_image_alt.set(i, plot_y_alt.get(i));

        }

    }

    //Method for Translation
    public static void translation(int trans_x, int trans_y, int number_of_points_alt, ArrayList<Integer> x_coord, ArrayList<Integer> y_coord)
    {
        //Create temporary variables to store newly calculated coordinates
        int temp_x;
        int temp_y;



        //Create a loop to update the coordinate values after translation
        for(int i = 0; i < number_of_points_alt; i++)
        {

            //Update x value
            temp_x = x_coord.get(i) + trans_x;
            x_coord.set(i, temp_x);

            //Update y value
            temp_y = y_coord.get(i) + trans_y;
            y_coord.set(i, temp_y);
        }
    }

    //Method for Scaling
    public static void scaling(int scale_factor, int ref_x, int ref_y, int number_of_points_alt, ArrayList<Integer> x_coord, ArrayList<Integer> y_coord)
    {

        //Create temporary variables to hold the updated coordinates
        int temp_x;
        int temp_y;

        //Create a loop to update the coordinate values after scaling
        for(int i = 0; i < number_of_points_alt; i++)
        {
            //Update x value
            temp_x = (x_coord.get(i) * scale_factor) - ref_x;
            x_coord.set(i, temp_x);

            //Update y value
            temp_y = (y_coord.get(i) * scale_factor) - ref_y;
            y_coord.set(i, temp_y);
        }

    }

    //Method for Reflection
    public static void reflection(int axis_value, int x_reflect, int number_of_points_alt, ArrayList<Integer> x_coord, ArrayList<Integer> y_coord)
    {
        //Perform calculations based on reflection type
        if (x_reflect == 0)
        {
            //Create a temporary variable to store updated coordinate values
            int temp_x;

            //Update the coordinates values using a loop
            for(int i = 0; i < number_of_points_alt; i++)
            {
                temp_x = 2 * axis_value - x_coord.get(i);
                x_coord.set(i, temp_x);
            }

        }
        else
        {
            //Create a temporary variable to store updated coordinate values
            int temp_y;

            //Update the coordinates values using a loop
            for(int i = 0; i < number_of_points_alt; i++)
            {
                temp_y = 2 * axis_value - y_coord.get(i);
                y_coord.set(i, temp_y);
            }

        }

    }

    //Method for Rotation
    public static void rotation(int angle_degree, int number_of_points_alt, ArrayList<Integer> x_coord, ArrayList<Integer> y_coord)
    {
        //Convert the degree to rad for calculation
        double angle_rad = angle_degree * Math.PI / 180 * (-1);

        //Create temporary variables to store updated coordinates values
        double temp_x;
        double temp_y;

        //Create a loop to update the coordinate values after rotation
        for(int i = 0; i < number_of_points_alt; i++)
        {
            //Update the x value
            temp_x = (HelloApplication.get_plot_x().get(i) * Math.cos(angle_rad)) - (HelloApplication.get_plot_y().get(i) * Math.sin(angle_rad));
            x_coord.set(i, (int) Math.round(temp_x));

            //Update the y value
            temp_y = (HelloApplication.get_plot_x().get(i) * Math.sin(angle_rad)) + (HelloApplication.get_plot_y().get(i) * Math.cos(angle_rad));
            y_coord.set(i, (int) Math.round(temp_y));
        }
    }

    //Method for Translation Rounds
    public static void translation_rounds(int answer_x, int answer_y, int trans_x, int trans_y, int number_of_points_alt, ArrayList<Integer> plot_x_alt, ArrayList<Integer> plot_y_alt, ArrayList<Integer> plot_x_image_alt, ArrayList<Integer> plot_y_image_alt)
    {
        //Check the player's answer
        if (answer_x == trans_x && answer_y == trans_y){
            player_1.set_player_is_correct(true);
        }
        else{
            player_1.set_player_is_correct(false);
        }

        //Calculate the player's score
        player_1.set_player_score();

        //Reset the coordinates of the image shape to match the original shape at the end of the round
        reset_image(number_of_points_alt, plot_x_alt, plot_y_alt, plot_x_image_alt, plot_y_image_alt);

    }

    //Method for Scaling Rounds
    public static void scaling_rounds(int answer, int scale_factor, int number_of_points_alt, ArrayList<Integer> plot_x_alt, ArrayList<Integer> plot_y_alt, ArrayList<Integer> plot_x_image_alt, ArrayList<Integer> plot_y_image_alt)
    {
        //Check the player's answer
        if (answer == scale_factor){
            player_1.set_player_is_correct(true);
        }
        else{
            player_1.set_player_is_correct(false);
        }

        //Calculate the player's score
        player_1.set_player_score();

        //Reset the coordinates of the image shape to match the original shape at the end of the round
        reset_image(number_of_points_alt, plot_x_alt, plot_y_alt, plot_x_image_alt, plot_y_image_alt);

    }

    //Method for Reflection Rounds
    public static void reflection_rounds(int answer_1, int answer_2, int number_of_points_alt, ArrayList<Integer> plot_x_alt, ArrayList<Integer> plot_y_alt, ArrayList<Integer> plot_x_image_alt, ArrayList<Integer> plot_y_image_alt)
    {
        //Check the player's answer
        if (answer_1 == HelloApplication.get_rand_1() && answer_2 == HelloApplication.get_rand_2())
            player_1.set_player_is_correct(true);
        else
            player_1.set_player_is_correct(false);

        //Calculate the player's score
        player_1.set_player_score();

        //Reset the coordinates of the image shape to match the original shape at the end of the round
        reset_image(number_of_points_alt, plot_x_alt, plot_y_alt, plot_x_image_alt, plot_y_image_alt);

    }

    //Method for Rotation Rounds
    public static void rotation_rounds(int answer, int number_of_points_alt, ArrayList<Integer> plot_x_alt, ArrayList<Integer> plot_y_alt, ArrayList<Integer> plot_x_image_alt, ArrayList<Integer> plot_y_image_alt)
    {
        //Check the player's answer
        if (answer == HelloApplication.get_rand_1())
            player_1.set_player_is_correct(true);
        else
            player_1.set_player_is_correct(false);

        //Calculate the player's score
        player_1.set_player_score();

        //Reset the coordinates of the image shape to match the original shape at the end of the round
        reset_image(number_of_points_alt, plot_x_alt, plot_y_alt, plot_x_image_alt, plot_y_image_alt);

    }

    //Generate shape
//    public static void generate_shape(ArrayList<Integer> plot_x_alt, ArrayList<Integer> plot_y_alt, ArrayList<Integer> plot_x_image_alt, ArrayList<Integer> plot_y_image_alt){
//
//        //Prepare XYChart.Series objects by setting data
//        XYChart.Series series = new XYChart.Series();
//        series.setName("Ori");
//
//        series.getData().add(new XYChart.Data(plot_x_alt.get(0), plot_y_alt.get(0)));
//        series.getData().add(new XYChart.Data(plot_x_alt.get(1), plot_y_alt.get(1)));
//        series.getData().add(new XYChart.Data(plot_x_alt.get(2), plot_y_alt.get(2)));
//        series.getData().add(new XYChart.Data(plot_x_alt.get(3), plot_y_alt.get(3)));
//
//        XYChart.Series series2 = new XYChart.Series();
//        series2.setName("IMG");
//
//        series2.getData().add(new XYChart.Data(plot_x_image_alt.get(0), plot_y_alt.get(0)));
//        series2.getData().add(new XYChart.Data(plot_x_image_alt.get(1), plot_y_alt.get(1)));
//        series2.getData().add(new XYChart.Data(plot_x_image_alt.get(2), plot_y_alt.get(2)));
//        series2.getData().add(new XYChart.Data(plot_x_image_alt.get(3), plot_y_alt.get(3)));
//
//        //Setting the data to Line chart
//        CartesianPlane.getData().add(series);
//        CartesianPlane.getData().add(series2);
//    }
}