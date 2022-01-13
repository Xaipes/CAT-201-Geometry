//Import the required packages
import java.util.ArrayList;
import java.util.Scanner;
import java.lang.Math;

//Main Class
public class Main {

    //Create a scanner to receive input
    static Scanner user_input = new Scanner(System.in);

    //Main Method
    public static void main(String[] args)
    {

        //Create the variables and arrays to store information for the Shape
        int number_of_points;
        ArrayList<Double> plot_x = new ArrayList<Double>();
        ArrayList<Double> plot_y = new ArrayList<Double>();
        
        //Receive the user's input on the number of points for the shape
        System.out.print("How many points does your shape have (please enter an integer above 0): ");
        number_of_points = user_input.nextInt();

        //Call the coordinates input method
        coordinates_input(number_of_points, plot_x, plot_y);

        System.out.print(plot_x);
        System.out.print(plot_y);
        System.out.print("\n");

        //Call the scaling method
        scaling(number_of_points, plot_x, plot_y);

        System.out.print(plot_x);
        System.out.print(plot_y);
        System.out.print("\n");

        //Close the scanner
        user_input.close();


    }

    /*Method to Receive Coordinates Input*/
    public static void coordinates_input(int number_of_points_alt, ArrayList<Double> plot_x_alt, ArrayList<Double> plot_y_alt)
    {

        //Create temporary variables to hold coordinates
        double temp_x;
        double temp_y;

        //Create a loop to receive input for the coordinates of all points
        for(int i = 1; i <= number_of_points_alt; i++)
        {
            //Input x coordinate of a point
            System.out.print("Enter the #" + i + " coordinate's x value: ");
            temp_x = user_input.nextDouble();
            plot_x_alt.add(temp_x);

            //Input y coordinate of a point
            System.out.print("Enter the #" + i + " coordinate's y value: ");
            temp_y = user_input.nextDouble();
            plot_y_alt.add(temp_y);

            //Print an empty line for visual aid
            System.out.print("\n");
        }

    }
    
    //Method for Translation
    public static void translation(int number_of_points_alt, ArrayList<Double> plot_x_alt, ArrayList<Double> plot_y_alt)
    {

        //Receive the translation value for x coordinates
        System.out.print("Please enter the translation value for x coordinates: ");
        double trans_x = user_input.nextDouble();

        //Receive the translation value for y coordinates
        System.out.print("Please enter the translation value for y coordinates: ");
        double trans_y = user_input.nextDouble();

        //Create temporary variables to store newly calculated coordinates
        double temp_x;
        double temp_y;

        //Create a loop to update the coordinate values after translation
        for(int i = 0; i < number_of_points_alt; i++)
        {
            //Update x value
            temp_x = plot_x_alt.get(i) + trans_x;
            plot_x_alt.set(i, temp_x);

            //Update y value
            temp_y = plot_y_alt.get(i) + trans_y;
            plot_y_alt.set(i, temp_y);
        }

    }

    //Method for Scaling
    public static void scaling(int number_of_points_alt, ArrayList<Double> plot_x_alt, ArrayList<Double> plot_y_alt)
    {

        //Receive user input for scale factor and reference point coordinates
        System.out.print("Please enter the reference point's x coordinate: ");
        double ref_x = user_input.nextDouble();
        System.out.print("Please enter the reference point's y coordinate: ");
        double ref_y = user_input.nextDouble();
        System.out.print("Please enter the scale factor desired: ");
        double scale_factor = user_input.nextDouble();

        //Create temporary variables to hold the updated coordinates
        double temp_x;
        double temp_y;

        //Create a loop to update the coordinate values after scaling
        for(int i = 0; i < number_of_points_alt; i++)
        {
            //Update x value
            temp_x = (plot_x_alt.get(i) * scale_factor) - ref_x;
            plot_x_alt.set(i, temp_x);

            //Update y value
            temp_y = (plot_y_alt.get(i) * scale_factor) - ref_y;
            plot_y_alt.set(i, temp_y);
        }

    }

    //Method for Reflection
    public static void reflection(int number_of_points_alt, ArrayList<Double> plot_x_alt, ArrayList<Double> plot_y_alt)
    {

        //Select user's reflection type
        System.out.print("Would you like to reflect the shape horizontally or vertically?\n");
        System.out.print("Enter 0 for a Horizontal Reflection and 1 for a Vertical Reflection: ");
        boolean is_vertical = user_input.nextBoolean();

        //Perform calculations based on reflection type
        if (is_vertical == false)
        {
            //Get the reflection axis value
            System.out.print("Enter the desired x-value for the axis of reflection: ");
            double reflect_x = user_input.nextDouble();

            //Create a temporary variable to store updated coordinate values
            double temp_x;

            //Update the coordinates values using a loop
            for(int i = 0; i < number_of_points_alt; i++)
            {
                temp_x = 2 * reflect_x - plot_x_alt.get(i);
                plot_x_alt.set(i, temp_x);
            }

        }
        else
        {
            //Get the reflection axis value
            System.out.print("Enter the desired y-value for the axis of reflection: ");
            double reflect_y = user_input.nextDouble();

            //Create a temporary variable to store updated coordinate values
            double temp_y;

            //Update the coordinates values using a loop
            for(int i = 0; i < number_of_points_alt; i++)
            {
                temp_y = 2 * reflect_y - plot_y_alt.get(i);
                plot_y_alt.set(i, temp_y);
            }

        }

    }

    //Method for Rotation
    public static void rotation(int number_of_points_alt, ArrayList<Double> plot_x_alt, ArrayList<Double> plot_y_alt)
    {
        //Request the angle of rotation from the user
        System.out.print("Please enter your desired angle of rotation: ");
        int angle_degree = user_input.nextInt();

        //Convert the degree to rad for calculation
        double angle_rad = angle_degree * Math.PI / 180 * (-1);

        //Create temporary variables to store updated coordinates values
        double temp_x;
        double temp_y;

        //Create a loop to update the coordinate values after rotation
        for(int i = 0; i < number_of_points_alt; i++)
        {
            //Update the x value
            temp_x = (plot_x_alt.get(i) * Math.cos(angle_rad)) - (plot_y_alt.get(i) * Math.sin(angle_rad));
            plot_x_alt.set(i, temp_x);

            //Update the y value
            temp_y = (plot_y_alt.get(i) * Math.cos(angle_rad)) - (plot_x_alt.get(i) * Math.sin(angle_rad));
            plot_y_alt.set(i, temp_y);
        }

    }

}