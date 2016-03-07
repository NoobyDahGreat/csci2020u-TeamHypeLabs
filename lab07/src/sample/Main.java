package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
        try {
            Scanner scanner = new Scanner(new File("/home/brad/Documents/csci2020u/lab07/weatherwarnings-2015.csv"));
            scanner.useDelimiter(",");
            while (scanner.hasNext()) {
                /////ADD CODE HERE
            }
            scanner.close();
        }

        catch(FileNotFoundException e){
            e.printStackTrace();
        }


    }
}
