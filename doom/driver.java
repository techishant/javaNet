package doom;

import java.util.Scanner;

public class driver {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        client myclient  = new client();
        myclient.startConnection("127.0.0.1", 4444);
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
