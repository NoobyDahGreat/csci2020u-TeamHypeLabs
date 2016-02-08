package sample;

import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.layout.*;
import javafx.scene.control.*;

import java.time.LocalDate;


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

        Label userNameLabel = new Label("Username:");
        editArea.add(userNameLabel, 0, 1);
        TextField userNameField = new TextField();
        userNameField.setPromptText("Username");
        editArea.add(userNameField, 1, 1);

        Label passwordLabel = new Label("Password:");
        editArea.add(passwordLabel, 0, 2);
        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Password");
        editArea.add(passwordField, 1, 2);

        Label fullNameLabel = new Label("Full name:");
        editArea.add(fullNameLabel, 0, 3);
        TextField fullNameField = new TextField();
        fullNameField.setPromptText("Full Name");
        editArea.add(fullNameField, 1, 3);

        Label emailLabel = new Label("E-Mail:");
        editArea.add(emailLabel, 0, 4);
        TextField emailField = new TextField();
        emailField.setPromptText("email@stuff.com");
        editArea.add(emailField, 1, 4);

        Label phoneLabel = new Label("Phone #:");
        editArea.add(phoneLabel, 0, 5);
        TextField phoneField = new TextField();
        phoneField.setPromptText("000-000-0000");
        editArea.add(phoneField, 1, 5);

        Label dateLabel = new Label("Date of Birth:");
        editArea.add(dateLabel, 0, 6);
        final DatePicker datePicker = new DatePicker();
        datePicker.setOnAction(new EventHandler() {
            public void handle(Event t) {
                LocalDate date = datePicker.getValue();
                System.err.println("Selected date: " + date);
            }
        });
        editArea.add(datePicker, 1, 6);



        layout = new BorderPane();
        layout.setCenter(editArea);

        primaryStage.setScene(new Scene(layout, 325, 300));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
