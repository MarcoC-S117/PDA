
public class PDAPila {
    private char[] stack;
    private int size;
    private int capacity;

    public PDAPila(int FirtSize) {
        capacity = FirtSize;  // Capacidad inicial de la pila (ajusta según tus necesidades).
        stack = new char[capacity];
        push("Z0");
    }

    public void push(String symbol) {
        if (size < capacity && Alphabet(symbol)!='\0') {
            stack[size++] = Alphabet(symbol);
        } else {
            // Aquí puedes implementar manejo de errores o redimensionar la pila si es necesario.
            throw new RuntimeException("La pila está llena o el simbolo es invalido. No se puede hacer push.");
        }
    }

    public char pop() {
        if (!empty()) {
            return stack[--size];
        } else {
            throw new RuntimeException("La pila está vacía. No se puede hacer pop.");
        }
    }

    public char top() {
        if (!empty()) {
            return stack[size - 1];
        } else {
            throw new RuntimeException("La pila está vacía. No hay elemento en la cima.");
        }
    }

    public boolean empty() {
        return size == 0;
    }

    public void init() {
        size = 0;
    }

    public String getAlphabet() {
        // Devuelve el alfabeto de la PDA como una cadena de caracteres.
        return "S, 0, 1";
    }
    public char Alphabet(String Sym){
        char Symbol = ' ';
        switch (Sym){
            case "Z0":
                Symbol = 'S';
                break;
            case "0":
                Symbol = '0';
                break;
            case "1":
                Symbol = '1';
                break;
            default:
                Symbol = '\0';
                break;
        }
        return Symbol;
    }
}
