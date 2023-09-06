import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
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
