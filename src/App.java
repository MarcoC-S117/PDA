public class App {
    public static void main(String[] args) {
        PDAPila pdaStack = new PDAPila(3);

        // Realizando algunas operaciones en la pila:
        pdaStack.push("2");
        pdaStack.push("1");
        System.out.println("Pop: " + pdaStack.pop());  // Output: Pop: BpdaStack.pop();
        System.out.println("Pop: " + pdaStack.pop());  // Output: Pop: BpdaStack.pop();
        System.out.println("Top: " + pdaStack.top());  // Output: Pop: BpdaStack.pop();
        System.out.println("pop: " + pdaStack.pop());  // Output: Size: 0

        System.out.println("Pila vacía: " + pdaStack.empty());  // Output: Pila vacía: true

        // Obtener el alfabeto (conjunto de símbolos) de la PDA:
        System.out.println("Alfabeto: " + pdaStack.getAlphabet());  // Output: Alfabeto: [A]
    }
}
