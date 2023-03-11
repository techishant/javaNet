package doom;

public class driver {
    public static void main(String[] args) {
        client myclient  = new client();
        myclient.startConnection("127.0.0.1", 4444);
        String response = myclient.sendMessage("hello server");
        System.out.println(response);

    }
}
