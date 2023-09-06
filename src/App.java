import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("1_2 Programa: PDA");
        System.out.println("L = { w | w is a palindrome of a's and b's}");
        System.out.println("\nDefinicion Formal: \nM = {Q, E, ¬, &, q0, Z0, F} donde");
        System.out.println("Q = {q0, q1}\nE = {A, B}\n¬ = {S, 0, 1}\nF = {}\nZ0={S}\nq0=q0\n");

        System.out.println("Ingrese una cadena para analizar: ");
        String cadena = scan.nextLine();
        if (!cadena.isEmpty()) {
            if (cadena.length() % 2 != 1) { // Verificar si la longitud es impar
                PDA pda = new PDA(cadena);
                System.out.println(pda.Transitions() ? "Es palíndromo" : "No es palíndromo");
            } else {
                System.out.println("La cadena no puede tener longitud impar");
            }
        } else {
            System.out.println("La cadena no puede estar vacía");
        }
        scan.close();     
    }
}
