package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.*;
import javafx.scene.input.KeyCombination;
import javafx.scene.image.*;
import javafx.collections.*;
import javafx.event.*;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.cell.*;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import javafx.stage.Stage;

import javax.rmi.CORBA.StubDelegate;

public class Main extends Application {
    private BorderPane layout;
    private TableView<StudentRecord> table;

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("Lab 05 Solutions");


        table = new TableView<>();
        table.setItems(DataSource.getAllMarks());
        table.setEditable(false);

        TableColumn<StudentRecord,Integer> sidColumn = null;
        sidColumn = new TableColumn<>("SID");
        sidColumn.setMinWidth(150);
        sidColumn.setCellValueFactory(new PropertyValueFactory<>("studentId"));

        TableColumn<StudentRecord,String> assignmentsColumn = null;
        assignmentsColumn = new TableColumn<>("Assignments");
        assignmentsColumn.setMinWidth(150);
        assignmentsColumn.setCellValueFactory(new PropertyValueFactory<>("assignments"));

        TableColumn<StudentRecord,String> midtermColumn = null;
        midtermColumn = new TableColumn<>("Midterm");
        midtermColumn.setMinWidth(150);
        midtermColumn.setCellValueFactory(new PropertyValueFactory<>("midterm"));

        TableColumn<StudentRecord,Double> examColumn = null;
        examColumn = new TableColumn<>("Final Exam");
        examColumn.setMinWidth(150);
        examColumn.setCellValueFactory(new PropertyValueFactory<>("exam"));

        TableColumn<StudentRecord,Double> finalColumn = null;
        finalColumn = new TableColumn<>("Final Exam");
        finalColumn.setMinWidth(150);
        finalColumn.setCellValueFactory(new PropertyValueFactory<>("mark"));

        TableColumn<StudentRecord,Double> letterColumn = null;
        letterColumn = new TableColumn<>("Letter Grade");
        letterColumn.setMinWidth(50);
        letterColumn.setCellValueFactory(new PropertyValueFactory<>("letterGrade"));




        table.getColumns().add(sidColumn);
        table.getColumns().add(assignmentsColumn);
        table.getColumns().add(midtermColumn);
        table.getColumns().add(examColumn);
        table.getColumns().add(finalColumn);
        table.getColumns().add(letterColumn);


        layout = new BorderPane();
        layout.setCenter(table);

        Scene scene = new Scene(layout, 900, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
