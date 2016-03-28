package Server;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {
    private GridPane summary;
    private TextArea board;
    private Button exit;


    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("SimpleBBS Server v1.0");
        primaryStage.setScene(new Scene(root, 300, 275));

        summary = new GridPane();
        summary.setPadding(new Insets(10, 10, 10, 10));
        summary.setHgap(10);
        summary.setVgap(10);

        board = new TextArea();
        board.setText();
        summary.add(board, 0, 0);
        

        exit = new Button();
        exit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

            }
        });
        summary.add(exit, 0, 1);

        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
