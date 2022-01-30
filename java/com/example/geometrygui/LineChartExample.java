package com.example.geometrygui;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

public class LineChartExample extends Application {
    @Override
    public void start(Stage stage) {
        //Defining the x axis
        NumberAxis xAxis = new NumberAxis(-10, 10, 1);

        //Defining the y axis
        NumberAxis yAxis = new NumberAxis   (-10, 10, 1);

        //Creating the line chart
        LineChart linechart = new LineChart(xAxis, yAxis);

        //Prepare XYChart.Series objects by setting data
        XYChart.Series series = new XYChart.Series();
        series.setName("Ori");

        series.getData().add(new XYChart.Data(0, 0));
        series.getData().add(new XYChart.Data(0, 3));
        series.getData().add(new XYChart.Data(3, 3));
        series.getData().add(new XYChart.Data(3, 0));

        XYChart.Series series2 = new XYChart.Series();
        series2.setName("IMG");

        int a = 2;
        int b = 1;
        series2.getData().add(new XYChart.Data(-6, 2));
        series2.getData().add(new XYChart.Data(-6, 5));
        series2.getData().add(new XYChart.Data(-3, 5));
        series2.getData().add(new XYChart.Data(-3, 2));

        //Setting the data to Line chart
        linechart.getData().add(series);
        linechart.getData().add(series2);
        //Creating a Group object
        Group root = new Group(linechart);

        //Creating a scene object
        Scene scene = new Scene(root, 600, 400);

        //Setting title to the Stage
        stage.setTitle("Line Chart");

        //Adding scene to the stage
        stage.setScene(scene);

        //Displaying the contents of the stage
        stage.show();
    }
    public static void main(String args[]){
        launch(args);
    }
}