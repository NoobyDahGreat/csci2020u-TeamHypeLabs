package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.net.InetAddress;

public class Main extends Application {
    private GridPane summary;
    private TextField user, msg;
    private Button send, exit;
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("SimpleBBS Client v1.0");
        primaryStage.setScene(new Scene(root, 500, 275));

        summary = new GridPane();
        summary.setPadding(new Insets(10, 10, 10, 10));
        summary.setHgap(10);
        summary.setVgap(10);


        user = new TextField();
        Label userLabel = new Label("Username: ");
        summary.add(userLabel , 0, 0);
        user.setEditable(true);
        user.setPromptText("Username");
        summary.add(user, 1, 0);

        Label msgLabel = new Label("Message: ");
        summary.add(msgLabel, 0, 1);
        msg = new TextField();
        msg.setEditable(true);
        msg.setPromptText("Hello");
        summary.add(msg, 1, 1);

        send = new Button("Send");
        send.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String str = user.getText() + ": " + msg.getText();

                try {

                } catch (Exception e) {
                    e.printStackTrace();
                }
                Client.sendRequest(str, "Test");
            }
        });
        summary.add(send, 0, 2);

        exit = new Button("Exit");
        exit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

            }
        });
        summary.add(exit, 0, 3);

        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
