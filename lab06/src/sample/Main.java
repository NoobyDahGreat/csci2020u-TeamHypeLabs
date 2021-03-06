package sample;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Main extends Application {
    private static double[] avgHousePricesByYear = {
            247381.0,264171.4,287715.3,294736.1,
            308431.4,322635.9,340253.0,363153.7
    };
    private static double[] avgCommercialPricesByYear = {
            1121585.3,1219479.5,1246354.2,1295364.8,
            1335932.6,1472362.0,1583521.9,1613246.3
    };

    private static String[] ageGroups = {
            "18-25", "26-35", "36-45", "46-55", "56-65", "65+"
    };
    private static int[] purchasesByAgeGroup = {
            648, 1021, 2453, 3173, 1868, 2247
    };
    private static Color[] pieColours = {
            Color.AQUA, Color.GOLD, Color.DARKORANGE,
            Color.DARKSALMON, Color.LAWNGREEN, Color.PLUM
    };

    @FXML
    private Canvas canvas;
        final static String bar1 = "1";
        final static String bar2 = "2";
        final static String bar3 = "3";
        final static String bar4 = "4";
        final static String bar5 = "5";
        final static String bar6 = "6";
        final static String bar7 = "7";
        final static String bar8 = "8";
    @Override
    public void start(Stage stage) throws Exception{
        stage.setTitle("");
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        final BarChart<String,Number> bc =
                new BarChart<String,Number>(xAxis,yAxis);
        bc.setTitle("");
        xAxis.setLabel("");
        yAxis.setLabel("");

        XYChart.Series series1 = new XYChart.Series();
        series1.setName("");
        series1.getData().add(new XYChart.Data(bar1, avgHousePricesByYear[0]));
        series1.getData().add(new XYChart.Data(bar2, avgHousePricesByYear[1]));
        series1.getData().add(new XYChart.Data(bar3, avgHousePricesByYear[2]));
        series1.getData().add(new XYChart.Data(bar4, avgHousePricesByYear[3]));
        series1.getData().add(new XYChart.Data(bar5, avgHousePricesByYear[4]));
        series1.getData().add(new XYChart.Data(bar6, avgHousePricesByYear[5]));
        series1.getData().add(new XYChart.Data(bar7, avgHousePricesByYear[6]));
        series1.getData().add(new XYChart.Data(bar8, avgHousePricesByYear[7]));


        XYChart.Series series2 = new XYChart.Series();
        series2.setName("");
        series2.getData().add(new XYChart.Data(bar1, avgCommercialPricesByYear[0]));
        series2.getData().add(new XYChart.Data(bar2, avgCommercialPricesByYear[1]));
        series2.getData().add(new XYChart.Data(bar3, avgCommercialPricesByYear[2]));
        series2.getData().add(new XYChart.Data(bar4, avgCommercialPricesByYear[3]));
        series2.getData().add(new XYChart.Data(bar5, avgCommercialPricesByYear[4]));
        series2.getData().add(new XYChart.Data(bar6, avgCommercialPricesByYear[5]));
        series2.getData().add(new XYChart.Data(bar7, avgCommercialPricesByYear[6]));
        series2.getData().add(new XYChart.Data(bar8, avgCommercialPricesByYear[7]));


        Scene scene  = new Scene(bc,800,600);
        bc.getData().addAll(series1, series2);
        stage.setScene(scene);
        stage.show();
    }

    private void draw(Group group) {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        System.out.println("width: " + canvas.getWidth());
        System.out.println("height: " + canvas.getHeight());
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
    }


    public static void main(String[] args) {launch(args);
    }
}
