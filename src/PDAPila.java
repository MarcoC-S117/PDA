import java.util.Stack;
import java.util.HashSet;
import java.util.Set;

public class PDAPila {
    private Stack<Character> stack;

    public PDAPila() {
        stack = new Stack<>();
    }

    public void push(char symbol) {
        stack.push(symbol);
    }

    public char pop() {
        if (!empty()) {
            return stack.pop();
        } else {
            throw new RuntimeException("La pila está vacía. No se puede hacer pop.");
        }
    }

    public char top() {
        if (!empty()) {
            return stack.peek();
        } else {
            throw new RuntimeException("La pila está vacía. No hay elemento en la cima.");
        }
    }

    public boolean empty() {
        return stack.isEmpty();
    }

    public void init() {
        stack.clear();
    }

    public Set<Character> alphabet() {
        // Devuelve el alfabeto de la PDA, que podría ser un conjunto de símbolos permitidos.
        // Esto debe ser personalizado para tu aplicación específica.
        return new HashSet<>(stack);
    }
}
