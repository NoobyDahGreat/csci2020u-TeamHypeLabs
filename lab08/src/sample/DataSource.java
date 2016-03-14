package sample;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class DataSource {

    public static ObservableList<StudentRecord> loadMarks (File fName) throws IOException {
        Scanner fileIn = new Scanner(new FileReader(fName));
        fileIn.useDelimiter("(,|\\n)");

        ObservableList<StudentRecord> marks = FXCollections.observableArrayList();

        while (fileIn.hasNext()) {
            String SID = fileIn.next();
            System.out.println(SID);
            Double midterm = fileIn.nextDouble();
            System.out.println(midterm);
            Double assignment = fileIn.nextDouble();
            System.out.println(assignment);
            Double exam = fileIn.nextDouble();
            System.out.println(exam);

           marks.add(new StudentRecord(SID, midterm, assignment, exam));
        }

        fileIn.close();


        return marks;
    }

    public static void saveMarks (File fname, ObservableList<StudentRecord> records) throws IOException {
        PrintWriter outFile = new PrintWriter(fname);
        for (int i = 0; i < records.size(); i++) {
            outFile.print (records.get(i).getStudentId() + "," + records.get(i).getMidterm() + ","
                             + records.get(i).getAssignments() + "," + records.get(i).getExam() + "\n");
        }


        outFile.close();
    }

    public static ObservableList<StudentRecord> getAllMarks() {
        ObservableList<StudentRecord> marks = FXCollections.observableArrayList();

        // Student ID, Assignements, Midterm, Final exam
        marks.add(new StudentRecord("100100100", 75.0f, 68.0f, 54.25f));
        marks.add(new StudentRecord("100100101", 70.0f, 69.25f, 51.5f));
        marks.add(new StudentRecord("100100102", 100.0f, 97.0f, 92.5f));
        marks.add(new StudentRecord("100100103", 90.0f, 88.5f, 68.75f));
        marks.add(new StudentRecord("100100104", 72.25f, 74.75f, 58.25f));
        marks.add(new StudentRecord("100100105", 85.0f, 56.0f, 62.5f));
        marks.add(new StudentRecord("100100106", 70.0f, 66.5f, 61.75f));
        marks.add(new StudentRecord("100100107", 55.0f, 47.0f, 50.5f));
        marks.add(new StudentRecord("100100108", 40.0f, 32.5f, 27.75f));
        marks.add(new StudentRecord("100100109", 82.5f, 77.0f, 74.25f));

        return marks;
    }
}
