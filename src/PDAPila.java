
public class PDAPila {
	private char[] stack;
	private int size;
	private int capacity;

	// Constructor de la clase PDA.
	public PDAPila(int FirtSize) {
		capacity = FirtSize; // Capacidad inicial de la pila (ajusta según tus necesidades).
		stack = new char[capacity];
		push('Z');
	}

	// Métodos de la clase PDA.
	public void push(char symbol) {
		if (size < capacity && Alphabet(symbol) != '\0') {
			stack[size++] = Alphabet(symbol);
		} else {
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

	public void restart() {
		size = 0;
	}

	// obtener alfabeto de la pila
	public String getAlphabet() {
		// Devuelve el alfabeto de la PDA como una cadena de caracteres.
		return "S, 0, 1";
	}

	// Alfabeto de la pila
	public char Alphabet(char Sym) {
		char Symbol = ' ';
		switch (Sym) {
		case 'Z':
			Symbol = 'S';
			break;
		case 'a':
			Symbol = '0';
			break;
		case 'b':
			Symbol = '1';
			break;
		default:
			Symbol = '\0';
			break;
		}
		return Symbol;
	}

	public String estadoPila() {
		StringBuilder estado = new StringBuilder();
		for (int i = 0; i < size; i++) {
			estado.append(stack[i]);
		}
		return estado.toString();
	}

}
