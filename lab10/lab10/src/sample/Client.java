package sample;

import java.io.*;
import java.net.Socket;

/**
 * Created by jude on 28/03/16.
 */
public class Client {
    public static void sendRequest(String message, String hostName) {
        Socket socket;
        BufferedReader in;
        PrintWriter out;

        int portNumber = 8080;

        try {
            socket = new Socket(hostName, portNumber);

            // wrap the input streams into readers and writers
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream());

            // send the HTTP request GET /yahoo/yahoo.html HTTP/1.0\n\n
            //String request = "GET /yahoo/yahoo.html HTTP/1.0";
            //String header = "Host: " + hostName;
            //String delim = "\r\n";
            //out.print(request + delim + header + delim + delim);
            out.println(message);
            out.flush();

            while ((message = in.readLine()) != null) {
                System.out.println(message);
                out.println("bye");

                if (message.equals("bye"))
                    break;
            }

            // read and print the response
            String response;
            System.out.println("Response:");
            while ((response = in.readLine()) != null) {
                System.out.println(response);
            }

            // close the connection (3-way tear down handshake)
            out.close();
            in.close();
            socket.close();

        }
        catch (IOException e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }
}
