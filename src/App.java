public class App {
    public static void main(String[] args) {
        PDAPila pdaStack = new PDAPila();

        // Realizando algunas operaciones en la pila:
        pdaStack.push('A');
        pdaStack.push('B');
        System.out.println("Top: " + pdaStack.top());  // Output: Top: B
        pdaStack.pop();
        System.out.println("Top: " + pdaStack.top());  // Output: Top: A

        // Reinicializando la pila:
        pdaStack.init();
        System.out.println("Pila vacía: " + pdaStack.empty());  // Output: Pila vacía: true

        // Obtener el alfabeto (conjunto de símbolos) de la PDA:
        System.out.println("Alfabeto: " + pdaStack.alphabet());  // Output: Alfabeto: [A]
    }
}
