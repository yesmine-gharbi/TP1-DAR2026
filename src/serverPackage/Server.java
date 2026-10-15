
package serverPackage;

import java.net.ServerSocket;
import java.net.Socket;
import java.io.IOException;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(5000);

            System.out.println("Je suis un serveur en attente de la connexion d'un client");

            Socket socket = serverSocket.accept();

            System.out.println("Un client est connecté");

            socket.close();
            serverSocket.close();

        } catch (IOException e) {
            System.out.println("Erreur : " + e.getMessage());
        }
    }
}
