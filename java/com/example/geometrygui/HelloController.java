package com.example.geometrygui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;


public class HelloController {

    //Create the player object
    static Player player_1 = new Player();

    //Create the variables and arrays to store information for the Shape
    int number_of_points;
    ArrayList<Integer> plot_x = new ArrayList<Integer>();
    ArrayList<Integer> plot_y = new ArrayList<Integer>();
    ArrayList<Integer> plot_x_image = new ArrayList<Integer>();
    ArrayList<Integer> plot_y_image = new ArrayList<Integer>();

    @FXML
    Button ruleButton, backButton,startButton;
    @FXML
    private Label validateMSG;
    @FXML
    private TextField enterPoints;
    @FXML
    private static TextField enterXaxis;
    @FXML
    private static TextField enterYaxis;
    @FXML
    private static TextField enterScalevVal;
    @FXML
    private static TextField enterAxisVal;
    @FXML
    private Button confirmPoint;
    @FXML
    private Button homeButton;
    @FXML
    private static Button rotationBtn;
    @FXML
    private static Button reflectedOnBtn;
    @FXML
    private ImageView imgSuccess, BckgroundView;
    @FXML
    private static TextField enterCoordx1;
    @FXML
    private static TextField enterCoordx2;
    @FXML
    private static TextField enterCoordx3;
    @FXML
    private static TextField enterCoordx4;
    @FXML
    private static TextField enterCoordy1;
    @FXML
    private static TextField enterCoordy2;
    @FXML
    private static TextField enterCoordy3;
    @FXML
    private static TextField enterCoordy4;



    // SUBMITTING THE POINTS
    public void submit(ActionEvent event){

        try {
            number_of_points = Integer.parseInt(enterPoints.getText());

            if(number_of_points >= 6 || number_of_points <= 2){
                validateMSG.setText("Please enter number between 3-5");
            }else if(number_of_points == 3){
                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("coord3-view.fxml"));

                Stage window = (Stage)confirmPoint.getScene().getWindow();
                window.setScene(new Scene(fxmlLoader.load(), 600, 550));
            }else if(number_of_points == 4){
                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("coord4-view.fxml"));

                Stage window = (Stage)confirmPoint.getScene().getWindow();
                window.setScene(new Scene(fxmlLoader.load(), 600, 650));
            }else if(number_of_points == 5){
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

    //Connecting Back to homepage
    public void GoToHome(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));

        Stage window = (Stage)homeButton.getScene().getWindow();
        window.setScene(new Scene(fxmlLoader.load(), 600, 400));
    }

    //Method to Receive Coordinates Input
    public static void coordinates_input(int number_of_points_alt, ArrayList<Integer> plot_x_alt, ArrayList<Integer> plot_y_alt, ArrayList<Integer> plot_x_image_alt, ArrayList<Integer> plot_y_image_alt)
    {
        //Assign the entered x coordinate values
        plot_x_alt.add(Integer.parseInt(enterCoordx1.getText()));
        plot_x_alt.add(Integer.parseInt(enterCoordx2.getText()));
        plot_x_alt.add(Integer.parseInt(enterCoordx3.getText()));
        plot_x_alt.add(Integer.parseInt(enterCoordx4.getText()));
        plot_x_image_alt.add(Integer.parseInt(enterCoordx1.getText()));
        plot_x_image_alt.add(Integer.parseInt(enterCoordx2.getText()));
        plot_x_image_alt.add(Integer.parseInt(enterCoordx3.getText()));
        plot_x_image_alt.add(Integer.parseInt(enterCoordx4.getText()));

        //Assign the entered x coordinate values
        plot_y_alt.add(Integer.parseInt(enterCoordy1.getText()));
        plot_y_alt.add(Integer.parseInt(enterCoordy2.getText()));
        plot_y_alt.add(Integer.parseInt(enterCoordy3.getText()));
        plot_y_alt.add(Integer.parseInt(enterCoordy4.getText()));
        plot_y_image_alt.add(Integer.parseInt(enterCoordy1.getText()));
        plot_y_image_alt.add(Integer.parseInt(enterCoordy2.getText()));
        plot_y_image_alt.add(Integer.parseInt(enterCoordy3.getText()));
        plot_y_image_alt.add(Integer.parseInt(enterCoordy4.getText()));

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
    public static void reflection(int axis_value, int is_vertical, int number_of_points_alt, ArrayList<Integer> x_coord, ArrayList<Integer> y_coord)
    {
        //Perform calculations based on reflection type
        if (is_vertical == 0)
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

        //Create temporary variables to store the old coordinate values
        int old_x;
        int old_y;

        //Create a loop to update the coordinate values after rotation
        for(int i = 0; i < number_of_points_alt; i++)
        {
            //Store the old x and y coordinate values in the temporary variables
            old_x = x_coord.get(i);
            old_y = y_coord.get(i);

            //Update the x value
            temp_x = (old_x * Math.cos(angle_rad)) - (old_y * Math.sin(angle_rad));
            x_coord.set(i, (int) Math.round(temp_x));

            //Update the y value
            temp_y = (old_x * Math.sin(angle_rad)) + (old_y * Math.cos(angle_rad));
            y_coord.set(i, (int) Math.round(temp_y));
        }
    }

    //Method for Translation Rounds
    public static void translation_rounds(int number_of_rounds, int number_of_points_alt, ArrayList<Integer> plot_x_alt, ArrayList<Integer> plot_y_alt, ArrayList<Integer> plot_x_image_alt, ArrayList<Integer> plot_y_image_alt)
    {
        //Set the minimum and maximum rng values
        int min = -10;
        int max = 10;

        //Create a loop to run the translation stages a number of times
        for (int round = 1; round <= number_of_rounds; round++)
        {
            //Generate a random set of numbers using the rng
            int rand_1 = (int) (Math.floor (Math.random() * (max-min+1) + min));
            int rand_2 = (int) (Math.floor (Math.random() * (max-min+1) + min));

            //Update the coordinates of the image shape after applying translation
            translation(rand_1, rand_2, number_of_points_alt, plot_x_image_alt, plot_y_image_alt);

            //Print the original and image shapes' values
            System.out.print("Original Shape: ");
            System.out.print (plot_x_alt);
            System.out.print(plot_y_alt + "\n");
            System.out.print("Image Shape: ");
            System.out.print (plot_x_image_alt);
            System.out.print(plot_y_image_alt + "\n");

            //Update answer with input from textbox
            int answer_x = Integer.parseInt(enterXaxis.getText());
            int answer_y = Integer.parseInt(enterYaxis.getText());

            //Check the player's answer
            if (answer_x == rand_1 && answer_y == rand_2){
                player_1.set_player_is_correct(true);
                System.out.print("Correct!\n");
            }
            else{
                player_1.set_player_is_correct(false);
                System.out.print("Wrong!\n");
            }

            //Calculate the player's score
            player_1.set_player_score();

            //Reset the coordinates of the image shape to match the original shape at the end of the round
            reset_image(number_of_points_alt, plot_x_alt, plot_y_alt, plot_x_image_alt, plot_y_image_alt);
        }
    }

    //Method for Scaling Rounds
    public static void scaling_rounds(int number_of_rounds, int number_of_points_alt, ArrayList<Integer> plot_x_alt, ArrayList<Integer> plot_y_alt, ArrayList<Integer> plot_x_image_alt, ArrayList<Integer> plot_y_image_alt)
    {
        //Set the minimum and maximum rng values
        int min = 0;
        int max = 10;

        //Create a loop to run the scaling stages a number of times
        for (int round = 1; round <= number_of_rounds; round++)
        {
            //Generate a random number using the rng
            int rand = (int) (Math.floor (Math.random() * (max-min+1) + min));

            //Update the coordinates of the image shape after applying translation
            scaling(rand, plot_x_alt.get(0), plot_y_alt.get(0), number_of_points_alt, plot_x_image_alt, plot_y_image_alt);

            //Print the original and image shapes' values
            System.out.print("Original Shape: ");
            System.out.print (plot_x_alt);
            System.out.print(plot_y_alt + "\n");
            System.out.print("Image Shape: ");
            System.out.print (plot_x_image_alt);
            System.out.print(plot_y_image_alt + "\n");

            //Update answer with input from the textbox
            int answer = Integer.parseInt(enterScalevVal.getText());

            //Check the player's answer
            if (answer == rand){
                player_1.set_player_is_correct(true);
                System.out.print("Correct!\n");
            }
            else{
                player_1.set_player_is_correct(false);
                System.out.print("Wrong!\n");
            }

            //Calculate the player's score
            player_1.set_player_score();

            //Reset the coordinates of the image shape to match the original shape at the end of the round
            reset_image(number_of_points_alt, plot_x_alt, plot_y_alt, plot_x_image_alt, plot_y_image_alt);
        }
    }

    //Method for Reflection Rounds
    public static void reflection_rounds(int number_of_rounds, int number_of_points_alt, ArrayList<Integer> plot_x_alt, ArrayList<Integer> plot_y_alt, ArrayList<Integer> plot_x_image_alt, ArrayList<Integer> plot_y_image_alt)
    {
        //Set the minimum and maximum rng values
        int min_1 = -10;
        int max_1 = 10;
        int min_2 = 0;
        int max_2 = 1;

        //Create a loop to run the scaling stages a number of times
        for (int round = 1; round <= number_of_rounds; round++)
        {
            //Generate a random number using the rng
            int rand_1 = (int) (Math.floor (Math.random() * (max_1-min_1+1) + min_1));
            int rand_2 = (int) (Math.floor (Math.random() * (max_2-min_2+1) + min_2));

            //Update the coordinates of the image shape after applying translation
            reflection(rand_1, rand_2, number_of_points_alt, plot_x_image_alt, plot_y_image_alt);

            //Print the original and image shapes' values
            System.out.print("Original Shape: ");
            System.out.print (plot_x_alt);
            System.out.print(plot_y_alt + "\n");
            System.out.print("Image Shape: ");
            System.out.print (plot_x_image_alt);
            System.out.print(plot_y_image_alt + "\n");

            //Update answer with input from the drop down menu and textbox
            int answer_2;
            if (reflectedOnBtn.getText() == "X-axis" ){
                answer_2 = 0;
            }
            else{
                answer_2 = 1;
            }
            int answer_1 = Integer.parseInt(enterAxisVal.getText());

            //Check the player's answer
            if (answer_1 == rand_1 && answer_2 == rand_2){
                player_1.set_player_is_correct(true);
                System.out.print("Correct!\n");
            }
            else{
                player_1.set_player_is_correct(false);
                System.out.print("Wrong!\n");
            }

            //Calculate the player's score
            player_1.set_player_score();

            //Reset the coordinates of the image shape to match the original shape at the end of the round
            reset_image(number_of_points_alt, plot_x_alt, plot_y_alt, plot_x_image_alt, plot_y_image_alt);
        }
    }

    //Method for Rotation Rounds
    public static void rotation_rounds(int number_of_rounds, int number_of_points_alt, ArrayList<Integer> plot_x_alt, ArrayList<Integer> plot_y_alt, ArrayList<Integer> plot_x_image_alt, ArrayList<Integer> plot_y_image_alt)
    {
        //Set the minimum and maximum rng values
        int min = 0;
        int max = 3;

        //Create a loop to run the scaling stages a number of times
        for (int round = 1; round <= number_of_rounds; round++)
        {
            //Generate a random number using the rng and convert it to multiples of 90
            int rand = (int) (Math.floor (Math.random() * (max-min+1) + min));
            rand = rand * 90;

            //Update the coordinates of the image shape after applying translation
            rotation(rand, number_of_points_alt, plot_x_image_alt, plot_y_image_alt);

            //Print the original and image shapes' values
            System.out.print("Original Shape: ");
            System.out.print (plot_x_alt);
            System.out.print(plot_y_alt + "\n");
            System.out.print("Image Shape: ");
            System.out.print (plot_x_image_alt);
            System.out.print(plot_y_image_alt + "\n");

            //Update answer with input from the drop down menu
            int answer;
            if (rotationBtn.getText() == "90 Degrees")
                answer = 90;
            else if (rotationBtn.getText() == "180 Degrees")
                answer = 180;
            else
                answer = 270;

            //Check the player's answer
            if (answer == rand){
                player_1.set_player_is_correct(true);
                System.out.print("Correct!\n");
            }
            else{
                player_1.set_player_is_correct(false);
                System.out.print("Wrong!\n");
            }

            //Calculate the player's score
            player_1.set_player_score();

            //Reset the coordinates of the image shape to match the original shape at the end of the round
            reset_image(number_of_points_alt, plot_x_alt, plot_y_alt, plot_x_image_alt, plot_y_image_alt);

        }


    }
}