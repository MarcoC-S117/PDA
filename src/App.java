public class App {
    public static void main(String[] args) {
        System.out.println("Ingrese una cadena para analizar: ");
        String cadena = System.console().readLine();
        if(cadena==""){
            PDA pda = new PDA(cadena);
        }else System.out.println("La cadena no puede estar vacia");        
    }
}
