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
            Scanner scanner = new Scanner(new File("~/Programing/CSCI-2020U/csci2020u-TeamHypeLabs/lab07/weatherwarnings-2015.csv"));
            scanner.useDelimiter(",");

            int flashFlood = 0,severeThunderstorm = 0 ,specialMarine= 0 ,tornado = 0 ;

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
        }

        catch(FileNotFoundException e){
            e.printStackTrace();
        }


    }
}
