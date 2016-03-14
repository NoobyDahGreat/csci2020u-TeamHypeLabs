package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Side;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javafx.scene.chart.*;



public class Main extends Application {


    @Override
    public void start(Stage stage) throws Exception {
        int flashFlood = 0, severeThunderstorm = 0, specialMarine = 0, tornado = 0;
        try {
            Scanner scanner = new Scanner(new File("/home/brad/Documents/csci2020u/lab07/weatherwarnings-2015.csv"));
            scanner.useDelimiter(",");



            while (scanner.hasNext()) {

                for (int i = 0; i < 5; i++) {
                    scanner.next();
                }

                String type = scanner.next();
                if (type.equalsIgnoreCase("FLASH FLOOD")) {
                    flashFlood++;
                } else if (type.equalsIgnoreCase("SEVERE THUNDERSTORM")) {
                    severeThunderstorm++;
                } else if (type.equalsIgnoreCase("SPECIAL MARINE")) {
                    specialMarine++;
                } else if (type.equalsIgnoreCase("TORNADO")) {
                    tornado++;
                }

                scanner.nextLine();

            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }





        Scene scene = new Scene(new Group());
        stage.setTitle("Lab 07");
        stage.setWidth(500);
        stage.setHeight(400);

        ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList(
                        new PieChart.Data("FLASH FLOOD", flashFlood),
                        new PieChart.Data("SEVERE THUNDERSTORM", severeThunderstorm),
                        new PieChart.Data("SPECIAL MARINE", specialMarine),
                        new PieChart.Data("TORNADO", tornado));
        final PieChart chart = new PieChart(pieChartData);
        chart.setTitle("Lab 07");
        chart.setLabelLineLength(20);
        chart.setLegendSide(Side.LEFT);

        ((Group) scene.getRoot()).getChildren().add(chart);
        stage.setScene(scene);
        stage.show();

        stage.setScene(scene);
        stage.show();
    }


        public static void Main(String[] args) {



            launch(args);



        }
    }

