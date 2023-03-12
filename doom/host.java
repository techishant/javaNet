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
    }


    /**
     * It gets input and processes it
     * @param in
     * @param out
     * @return
     */
    public int getInput(Scanner in, PrintWriter out){
        String greeting = in.nextLine();
        if("hello server".equals(greeting)){
            out.println("hello client");
        }
        else{
            out.println("unrecognised greeting");
        }
        if("0".equals(greeting)){
            return 0;
        }
        return 1;
    }

    /**
     * It Starts the server
     * @param port
     */
    public void start(int port){
        try {
            System.out.println("i was here");
            this.serverSocket = new ServerSocket();
            this.serverSocket.bind(new InetSocketAddress("192.168.0.200",port));
            this.clientSocket = this.serverSocket.accept();
            out = new PrintWriter(this.clientSocket.getOutputStream(), true);
            in = new Scanner(this.clientSocket.getInputStream(), "UTF-8");
        } catch (IOException e) {
            System.out.println("Here we go again");
            e.printStackTrace();
        }

        printEssentials();
        
        int st;
        while(true){
            st = getInput(in, out);
            if (st==0) break;
        }
        System.out.println("Outside loop( st: " + st);
        stop();
        System.out.println("Server stopped");
    }

    public void printEssentials(){
        System.out.println("i am here " + this.serverSocket);
        System.out.println("----------------------");
        System.out.println("Local Port: " + this.serverSocket.getLocalPort());
        System.out.println("Channel: " + this.serverSocket.getChannel());
        System.out.println("Inet Address: " + this.serverSocket.getInetAddress());
        System.out.println("Local Socket Address: " + this.serverSocket.getLocalSocketAddress());
        System.out.println("Server Started Successfully");
    }

    /**
     * closes all the sockets and buffers
     */
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
