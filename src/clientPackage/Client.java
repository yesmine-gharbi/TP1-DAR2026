
package clientPackage;

import java.net.Socket;
import java.io.IOException;

public class Client {
    public static void main(String[] args) {
        try {
            System.out.println("Je suis un client pas encore connecté...");

            Socket socket = new Socket("localhost", 5000);

            System.out.println("Je suis un client connecté");

            socket.close();

        } catch (IOException e) {
            System.out.println("Erreur : " + e.getMessage());
        }
    }
}
