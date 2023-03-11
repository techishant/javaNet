import java.io.*;
import java.net.Socket;

public class ls2 {
    public static void main(String[] args) {
        System.out.println("Client main Started");
        connectToServer();
    }

    public static void connectToServer() {
        //Try connect to the server on an unused port eg 9991. A successful connection will return a socket
        try(Socket cs = new Socket("127.0.0.1",9991)) {

            //Create Input&Outputstreams for the connection
            InputStream inputToServer = cs.getInputStream();
            OutputStream outputFromServer = cs.getOutputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}