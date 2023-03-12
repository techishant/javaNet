package doom;

import java.util.Scanner;

public class driver {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        client myclient  = new client();
        myclient.startConnection("192.168.0.200", 5500);

        while(true){
            String inp = in.nextLine();
            String response = myclient.sendMessage(inp);
            System.out.println(response);
            if(inp.equals("0")){
                break;
            }
        }
    }
}
