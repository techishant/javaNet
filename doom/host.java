package doom;

import java.net.*;
import java.io.*;
import java.util.Scanner;

public class host {
    ServerSocket serverSocket = null;
    Socket clientSocket;
    PrintWriter out;
    Scanner in;
    host(){
        this.serverSocket = null;
        start(4444);
    }

    public static void main(String[] args){
        host Myhost = new host();
        Myhost.start(9991);
    }

    public void start(int port){
        try {
            serverSocket = new ServerSocket(port);
            clientSocket = serverSocket.accept();
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new Scanner(clientSocket.getInputStream(), "UTF-8");
            String greeting = in.nextLine();
            if("hello server".equals(greeting)){
                out.println("hello client");
            }
            else{
                out.println("unrecognised greeting");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void stop(){
        in.close();
        out.close();
        try {
            clientSocket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
