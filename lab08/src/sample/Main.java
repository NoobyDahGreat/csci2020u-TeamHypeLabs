package sample;

import com.sun.image.codec.jpeg.TruncatedFileException;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
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
import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Observable;

import javafx.stage.Stage;

import javax.rmi.CORBA.StubDelegate;
import javax.swing.*;

public class Main extends Application {
    private BorderPane layout;
    private TableView<StudentRecord> table;
    private Button add;
    private GridPane summary;
    private TextField SID, assignments, midterm, finalExam;
    private File selectedFile;


    @Override
    public void start(Stage primaryStage) throws Exception{
        ObservableList<StudentRecord> marks = DataSource.getAllMarks();
        primaryStage.setTitle("Lab 08");


        table = new TableView<>();
        table.setItems(marks);
        table.setEditable(false);

        Menu menu = new Menu("File");
        MenuItem newItem = new MenuItem("New");
        newItem.setAccelerator(KeyCombination.keyCombination("Ctrl+N"));
        menu.getItems().add(newItem);
        menu.getItems().add(new SeparatorMenuItem());
        marks.clear();
        newItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                marks.clear();
            }
        });

        MenuItem openItem = new MenuItem("Open");
        openItem.setAccelerator(KeyCombination.keyCombination("Ctrl+O"));
        openItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                try {
                    FileChooser fileChooser = new FileChooser();
                    fileChooser.setTitle("Open Resource File");
                    fileChooser.getExtensionFilters().addAll(
                            new FileChooser.ExtensionFilter("Csv Files", "*.csv"),
                            new FileChooser.ExtensionFilter("All Files", "*.*"));
                    File selectedFile = fileChooser.showOpenDialog(primaryStage);
                    if (selectedFile != null) {
                        marks.setAll(DataSource.loadMarks(selectedFile));
                    }
                }
                catch (IOException e){
                    e.printStackTrace();
                }

            }
        });
        menu.getItems().add(openItem);

        MenuItem saveAsItem = new MenuItem("Save As");
        saveAsItem.setAccelerator(KeyCombination.keyCombination("Ctrl+Shift+S"));
        menu.getItems().add(saveAsItem);
        saveAsItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    FileChooser fileChooser = new FileChooser();
                    fileChooser.setTitle("Save File");
                    selectedFile = fileChooser.showSaveDialog(primaryStage);
                    if (selectedFile != null) {
                        DataSource.saveMarks(selectedFile, marks);
                    }
                }
                catch(IOException e) {
                    e.printStackTrace();
                }
            }
        });

        MenuItem saveItem = new MenuItem("Save");
        saveItem.setAccelerator(KeyCombination.keyCombination("Ctrl+S"));
        menu.getItems().add(saveItem);
        saveItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    if (selectedFile == null) {
                       saveAsItem.fire();
                    }
                    DataSource.saveMarks(selectedFile, marks);
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
        });


        MenuItem exitMenuItem = new MenuItem("Exit");
        exitMenuItem.setAccelerator(KeyCombination.keyCombination("Ctrl+Q"));
        exitMenuItem.setOnAction( e -> System.exit(0) );
        menu.getItems().add(exitMenuItem);


        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().add(menu);

        summary = new GridPane();
        summary.setPadding(new Insets(10, 10, 10, 10));
        summary.setVgap(10);
        summary.setHgap(10);

        Label SIDLabel = new Label("SID:");
        summary.add(SIDLabel ,0, 0);
        SID = new TextField();
        SID.setEditable(true);
        SID.setPromptText("100559945");
        summary.add(SID, 1, 0);

        Label assignmentsLabel = new Label("Assignments: ");
        summary.add(assignmentsLabel, 2, 0);
        assignments = new TextField();
        assignments.setEditable(true);
        assignments.setPromptText("50");
        summary.add(assignments, 3, 0);

        Label midtermLabel = new Label("Midterm:");
        summary.add(midtermLabel, 0, 1);
        midterm = new TextField();
        midterm.setEditable(true);
        midterm.setPromptText("50");
        summary.add(midterm, 1, 1);

        Label examLabel = new Label("Final Exam:");
        summary.add(examLabel, 2, 1);
        finalExam = new TextField();
        finalExam.setEditable(true);
        finalExam.setPromptText("50");
        summary.add(finalExam, 3, 1);

        add = new Button("Add");
        add.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                StudentRecord stu = new StudentRecord(SID.getText(), Double.parseDouble(midterm.getText()), Double.parseDouble(assignments.getText()), Double.parseDouble(finalExam.getText()));
                marks.add(stu);
            }
        });
        summary.add(add, 4, 1);




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
        layout.setTop(menuBar);
        layout.setBottom(summary);

        Scene scene = new Scene(layout, 900, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void chooseDir(Stage primaryStage){
        DirectoryChooser directoryChooser = new DirectoryChooser();
        directoryChooser.setInitialDirectory(new File("."));
        File mainDirectory = directoryChooser.showDialog(primaryStage);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
