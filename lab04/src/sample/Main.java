package sample;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.layout.*;
import javafx.scene.control.*;



public class Main extends Application {
    private BorderPane layout;
    private TextField nameField, username, email, phone, password;


    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("Lab 04 Solution");

        GridPane editArea = new GridPane();
        editArea.setPadding(new Insets(10, 10, 10, 10));
        editArea.setVgap(10);
        editArea.setHgap(10);

        Label nameLabel = new Label("Full name:");
        editArea.add(nameLabel, 0, 1);
        TextField nameField = new TextField();
        nameField.setPromptText("Full Name");
        editArea.add(nameField, 1, 1);

        Label passLabel = new Label("Password:");
        editArea.add(passLabel, 0, 2);
        PasswordField passField = new PasswordField();
        passField.setPromptText("Password");
        editArea.add(passField, 1, 2);

        layout = new BorderPane();
        layout.setCenter(editArea);

        primaryStage.setScene(new Scene(layout, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
