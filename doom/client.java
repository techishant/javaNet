package doom;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class client {
    Socket clientSocket;
    PrintWriter out;
    Scanner in;

    public void startConnection(String ip, int port){
        try{
            clientSocket = new Socket(ip, port);
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new Scanner(clientSocket.getInputStream(), "UTF-8");
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public String sendMessage(String msg){
        out.println(msg);
        String resp = in.nextLine();
        return resp;
    }

    public void stopConnection(){
        in.close();
        try{
            out.close();
            clientSocket.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
