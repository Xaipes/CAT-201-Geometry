package com.example.geometrygui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class HelloApplication extends Application {

    //Create the variables and arrays to store information for the Shape
    private static int number_of_points;
    private static ArrayList<Integer> plot_x = new ArrayList<Integer>();
    private static ArrayList<Integer> plot_y = new ArrayList<Integer>();
    private static ArrayList<Integer> plot_x_image = new ArrayList<Integer>();
    private static ArrayList<Integer> plot_y_image = new ArrayList<Integer>();

    //Create variables to temporarily store rng values.
    private static int rand_1, rand_2;

    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("Geometry");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    //Accessor Method
    public static int get_number_of_points() {
        return number_of_points;
    }
    public static ArrayList<Integer> get_plot_x() {
        return plot_x;
    }
    public static ArrayList<Integer> get_plot_y() {
        return plot_y;
    }
    public static ArrayList<Integer> get_plot_x_image() {
        return plot_x_image;
    }
    public static ArrayList<Integer> get_plot_y_image() {
        return plot_y_image;
    }
    public static int get_rand_1(){
        return rand_1;
    }
    public static int get_rand_2(){
        return rand_2;
    }

    //Mutator Method
    public static void set_number_of_points(int number_of_points_alt){
        number_of_points = number_of_points_alt;
    }
    public static void set_plot_x(int i, int input){
        plot_x.set(i, input);
    }
    public static void set_plot_y(int i, int input){
        plot_y.set(i, input);
    }
    public static void set_plot_x_image(int i, int input){
        plot_x_image.set(i, input);
    }
    public static void set_plot_y_image(int i, int input){
        plot_y_image.set(i, input);
    }
    public static void set_rand_1(int min, int max) {
        rand_1 = (int) (Math.floor (Math.random() * (max-min+1) + min));
    }
    public static void set_rand_2(int min, int max) {
        rand_2 = (int) (Math.floor (Math.random() * (max-min+1) + min));
    }

}