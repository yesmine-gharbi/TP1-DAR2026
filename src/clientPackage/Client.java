
package clientPackage;

import java.net.Socket;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 5000);

            DataInputStream entree =
                    new DataInputStream(socket.getInputStream());
            DataOutputStream sortie =
                    new DataOutputStream(socket.getOutputStream());

            Scanner clavier = new Scanner(System.in);
            int x;

            do {
                System.out.print("Entrez un entier (0 pour quitter) : ");
                x = clavier.nextInt();

                sortie.writeInt(x);
                sortie.flush();

                if (x != 0) {
                    int resultat = entree.readInt();
                    System.out.println("Résultat : " + resultat);
                }
            } while (x != 0);

            entree.close();
            sortie.close();
            socket.close();

            System.out.println("Client déconnecté.");

        } catch (IOException e) {
            System.out.println("Erreur : " + e.getMessage());
        }
    }
}
