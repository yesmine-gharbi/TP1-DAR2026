
package serverPackage;

import java.net.ServerSocket;
import java.net.Socket;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(5000);
            System.out.println("Serveur en attente d'un client...");

            Socket socket = serverSocket.accept();
            System.out.println("Client connecté.");

            DataInputStream entree =
                    new DataInputStream(socket.getInputStream());
            DataOutputStream sortie =
                    new DataOutputStream(socket.getOutputStream());

            int x;

            do {
                x = entree.readInt();

                if (x != 0) {
                    int resultat = x * 5;
                    sortie.writeInt(resultat);
                    sortie.flush();
                }
            } while (x != 0);

            entree.close();
            sortie.close();
            socket.close();
            serverSocket.close();

            System.out.println("Connexion terminée.");

        } catch (IOException e) {
            System.out.println("Erreur : " + e.getMessage());
        }
    }
}
