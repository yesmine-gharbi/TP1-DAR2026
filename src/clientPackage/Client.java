
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

            int choix;
            double a;
            double b;
            String resultat;

            do {
                System.out.println("\n--- CALCULATRICE ---");
                System.out.println("1. Addition");
                System.out.println("2. Soustraction");
                System.out.println("3. Multiplication");
                System.out.println("4. Division");
                System.out.println("0. Quitter");
                System.out.print("Votre choix : ");

                choix = clavier.nextInt();
                sortie.writeInt(choix);
                sortie.flush();

                if (choix >= 1 && choix <= 4) {
                    System.out.print("Premier nombre : ");
                    a = clavier.nextDouble();

                    System.out.print("Deuxième nombre : ");
                    b = clavier.nextDouble();

                    sortie.writeDouble(a);
                    sortie.writeDouble(b);
                    sortie.flush();

                    resultat = entree.readUTF();
                    System.out.println(resultat);
                } else if (choix != 0) {
                    resultat = entree.readUTF();
                    System.out.println(resultat);
                }
            } while (choix != 0);

            entree.close();
            sortie.close();
            socket.close();

            System.out.println("Client déconnecté.");

        } catch (IOException e) {
            System.out.println("Erreur : " + e.getMessage());
        }
    }
}
