//include the file in the package
package com.geometry;

//Import the required packages
import java.util.ArrayList;
import java.util.Scanner;
import java.lang.Math;
import javax.lang.model.util.ElementScanner14;

//Import JavaFX packages
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


//Main Class
public class Main {

    //Create a scanner to receive input
    static Scanner user_input = new Scanner(System.in);

    //Create the player object
    static Player player_1 = new Player();

    //Main Method
    public static void main(String[] args)
    {
        //Create the variables and arrays to store information for the Shape
        int number_of_points;
        ArrayList<Integer> plot_x = new ArrayList<Integer>();
        ArrayList<Integer> plot_y = new ArrayList<Integer>();
        ArrayList<Integer> plot_x_image = new ArrayList<Integer>();
        ArrayList<Integer> plot_y_image = new ArrayList<Integer>();
        
        //Receive the user's input on the number of points for the shape (Maximum 5)
        System.out.print("How many points does your shape have (please enter an integer above 0): ");
        number_of_points = user_input.nextInt();

        //Set the coordinates for the original shape and duplicate it to the image shape
        coordinates_input(number_of_points, plot_x, plot_y);
        plot_x_image = plot_x;
        plot_y_image = plot_y;

        //Call Translation Round
        translation_rounds(4, number_of_points, plot_x, plot_y, plot_x_image, plot_y_image);

        //Display the score after the game ends
        System.out.print("Your score is: ");
        System.out.print(player_1.get_player_score());
        
        //Close the scanner
        user_input.close();

    }

    /*Method to Receive Coordinates Input*/
    public static void coordinates_input(int number_of_points_alt, ArrayList<Integer> x_coord, ArrayList<Integer> y_coord)
    {

        //Create temporary variables to hold coordinates
        int temp_x;
        int temp_y;

        //Create a loop to receive input for the coordinates of all points
        for(int i = 1; i <= number_of_points_alt; i++)
        {
            //Input x coordinate of a point
            System.out.print("Enter the #" + i + " coordinate's x value: ");
            temp_x = user_input.nextInt();
            x_coord.add(temp_x);

            //Input y coordinate of a point
            System.out.print("Enter the #" + i + " coordinate's y value: ");
            temp_y = user_input.nextInt();
            y_coord.add(temp_y);

            //Print an empty line for visual aid
            System.out.print("\n");
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
    public static void scaling(int scale_input, int input_ref_x, int input_ref_y, int number_of_points_alt, ArrayList<Integer> x_coord, ArrayList<Integer> y_coord)
    {

        //Receive user input for scale factor and reference point coordinates
        int ref_x = input_ref_x;
        int ref_y = input_ref_y;

        //Use the randomly generated number as the scale factor
        int scale_factor = scale_input;

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

            //Ask for answer
            System.out.print("Translation x:\n");
            int answer_x = user_input.nextInt();
            System.out.print("Translation y:\n");
            int answer_y = user_input.nextInt();

            //Check the player's answer
            if (answer_x == rand_1 && answer_y == rand_2){
                player_1.set_player_is_correct(true);
            }
            else{
                player_1.set_player_is_correct(false);
            }

            //Calculate the player's score
            player_1.set_player_score();

            //Reset the coordinates of the image shape to match the original shape at the end of the round
            plot_x_image_alt = plot_x_alt;
            plot_y_image_alt = plot_y_alt;
            
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

            //Ask for answer
            System.out.print("Scale factor:\n");
            int answer = user_input.nextInt();

            //Check the player's answer
            if (answer == rand){
                player_1.set_player_is_correct(true);
            }
            else{
                player_1.set_player_is_correct(false);
            }

            //Calculate the player's score
            player_1.set_player_score();

            //Reset the coordinates of the image shape to match the original shape at the end of the round
            plot_x_image_alt = plot_x_alt;
            plot_y_image_alt = plot_y_alt;
            
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

            //Ask for answer
            System.out.print("Reflection Axis:\n");
            int answer_2 = user_input.nextInt();
            System.out.print("Axis Value:\n");
            int answer_1 = user_input.nextInt();

            //Check the player's answer
            if (answer_1 == rand_1 && answer_2 == rand_2){
                player_1.set_player_is_correct(true);
            }
            else{
                player_1.set_player_is_correct(false);
            }

            //Calculate the player's score
            player_1.set_player_score();

            //Reset the coordinates of the image shape to match the original shape at the end of the round
            plot_x_image_alt = plot_x_alt;
            plot_y_image_alt = plot_y_alt;
            
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

            //Ask for answer
            System.out.print("Rotation Angle:\n");
            int answer = user_input.nextInt();

            //Check the player's answer
            if (answer == rand){
                player_1.set_player_is_correct(true);
            }
            else{
                player_1.set_player_is_correct(false);
            }

            //Calculate the player's score
            player_1.set_player_score();

            //Reset the coordinates of the image shape to match the original shape at the end of the round
            plot_x_image_alt = plot_x_alt;
            plot_y_image_alt = plot_y_alt;
            
        }


    }

}

