package sample;

import java.io.*;
import java.net.*;


/**
 * Created by brad on 28/03/16.
 */
public final class HttpServer {
    private ServerSocket serverSocket = null;

    public HttpServer(int port) throws IOException{
        serverSocket = new ServerSocket(port);
    }

    public void handleRequests() throws IOException{
        System.out.println("Server Ready");

        while(true){
            Socket socket = serverSocket.accept();
            Thread handleThread = new Thread(new HttpRequestHandler(socket));
            handlerThread.start;
        }

    }

    public static void main(String[] args){
        int port = 8080;
        if(args.length> 0){
            port = Integer.parseInt(args[0]);
        }
        try{
            HttpServer server = new HttpServer(port);
            server.handleRequests();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
