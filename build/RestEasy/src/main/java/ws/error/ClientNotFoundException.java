package ws.error;

public class ClientNotFoundException extends Exception {
    public ClientNotFoundException() {
        super("Client not found");
    }
}
