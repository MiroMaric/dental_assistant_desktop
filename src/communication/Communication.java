package communication;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import transfer.Request;
import transfer.Response;

public class Communication {

    private static Communication instance;
    private final Socket socket;

    private Communication() throws IOException {
        socket = new Socket("localhost", 9000);
    }

    public static Communication getInstance()throws Exception{
        if (instance == null) {
            try {
                instance = new Communication();
            } catch (IOException ex) {
                Logger.getLogger(Communication.class.getName()).log(Level.SEVERE, null, ex);
                throw new IOException("Neuspešno uspostavljanje konekcije sa serverom");
            }
        }
        return instance;
    }

    public void sendRequest(Request request)throws Exception{
        try{
            ObjectOutputStream outSocket = new ObjectOutputStream(socket.getOutputStream());
            outSocket.writeObject(request);
        } catch (IOException ex) {
            Logger.getLogger(Communication.class.getName()).log(Level.SEVERE, null, ex);
            throw new IOException("Neuspešno slanje zahteva");
        }
    }

    public Response readResponse()throws Exception{
        try{
            ObjectInputStream inSocket = new ObjectInputStream(socket.getInputStream());
            return (Response) inSocket.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(Communication.class.getName()).log(Level.SEVERE, null, ex);
            throw new IOException("Neuspešan prijem odgovora");
        }
    }

}
