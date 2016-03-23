package sample;

import java.io.*;
import java.net.Socket;
import java.net.SocketException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;
import javafx.collections.ObservableList;

/**
 * Created by jude on 21/03/16.
 */
public class Download {
    private static ObservableList<Data> close;
    private static ObservableList<Data> adjClose;



    public void downloadStockPrices() {

        try {
            URL url = new URL("http://ichart.finance.yahoo.com/table.csv?s=GOOG&a=1&b=01&c=2010&d=11&e=31&f=2015&g=m");
            URLConnection con = url.openConnection();

            BufferedInputStream in = new BufferedInputStream(con.getInputStream());
            FileOutputStream out = new FileOutputStream("./table.csv");

            int i = 0;
            byte[] bytesIn = new byte[1024];

            while ((i = in.read(bytesIn)) >= 0) {
                out.write(bytesIn, 0, i);
            }
            out.close();
            in.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        readFile();
    }

    private static void readFile() {
        File file = new File("../table.csv");

        try {
            Scanner fileIn = new Scanner(new FileReader(file));
            while (fileIn.hasNext()) {
                for (int i = 0; i < 5; i++) {
                    fileIn.next();
                }
                float close = fileIn.nextFloat();
                System.out.println(close);
                float adjClose = fileIn.nextFloat();
                System.out.println(adjClose);

                this.close.add(new Data(close));
                this.adjClose.add(new Data(adjClose));

            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
