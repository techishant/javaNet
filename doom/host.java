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

    public int getInput(Scanner in, PrintWriter out){
        String greeting = in.nextLine();
        if("hello server".equals(greeting)){
            out.println("hello client");
        }
        else{
            out.println("unrecognised greeting");
        }
        if("0".equals(greeting)){
            System.out.println("00000");
            return 0;
        }
        return 1;
    }

    public void start(int port){
        try {
            serverSocket = new ServerSocket(port);
            clientSocket = serverSocket.accept();
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new Scanner(clientSocket.getInputStream(), "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }


        System.out.println("----------------------");
        System.out.println("Local Port: " + serverSocket.getLocalPort());
        System.out.println("Channel: " + serverSocket.getChannel());
        System.out.println("Inet Address: " + serverSocket.getInetAddress());
        System.out.println("Local Socket Address: " + serverSocket.getLocalSocketAddress());
        System.out.println("Server Started Successfully");

        

        int st;
        while(true){
            st = getInput(in, out);
            if (st==0) break;
        }
        System.out.println("Outside loop( st: " + st);

        stop();
        System.out.println("Server stopped");
        System.exit(0);
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
