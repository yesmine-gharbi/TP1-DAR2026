
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

            int choix;
            double a;
            double b;
            double resultat;

            do {
                choix = entree.readInt();

                if (choix != 0) {
                    a = entree.readDouble();
                    b = entree.readDouble();

                    if (choix == 1) {
                        resultat = a + b;
                        sortie.writeUTF("Résultat : " + resultat);
                    } else if (choix == 2) {
                        resultat = a - b;
                        sortie.writeUTF("Résultat : " + resultat);
                    } else if (choix == 3) {
                        resultat = a * b;
                        sortie.writeUTF("Résultat : " + resultat);
                    } else if (choix == 4) {
                        if (b != 0) {
                            resultat = a / b;
                            sortie.writeUTF("Résultat : " + resultat);
                        } else {
                            sortie.writeUTF("Erreur : division par zéro");
                        }
                    } else {
                        sortie.writeUTF("Choix invalide");
                    }

                    sortie.flush();
                }
            } while (choix != 0);

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
