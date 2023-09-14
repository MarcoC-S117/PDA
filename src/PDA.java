public class PDA {

	private int Mitad_Cadena = 0;
	private String cadena;
	private int state = 0;
	private PDAPila pila;
	private StringBuilder resultStringBuilder = new StringBuilder(); // Variable para almacenar resultados
	String Transiciones;

	// constructor de la clase PDA
	PDA(String Cadena) {
		Mitad_Cadena = Cadena.length() / 2;
		this.cadena = Cadena;
		this.pila = new PDAPila(Mitad_Cadena + 1);
	}

	boolean Transitions() {
		boolean valid = false;

		for (int i = 0; i < cadena.length(); i++) {
			switch (state) {

			case 0:
				// En caso de ser palindromo impar
				if (i == Mitad_Cadena && cadena.length() % 2 != 0) {
					resultStringBuilder.append("(q0, ").append(getCadenaFaltante(i)).append(", ").append(pila.estadoPila())
							.append(")\n");
					state = 1;
					// En caso de ser palindromo par
				} else if (i < Mitad_Cadena) {
					state = 0;
					resultStringBuilder.append("(q0, ").append(getCadenaFaltante(i)).append(", ").append(pila.estadoPila())
							.append(")\n");
					pila.push(cadena.charAt(i));
					// cambio sin leer simbolo
				} else {
					resultStringBuilder.append("(q0, E, ").append(pila.estadoPila()).append(")\n");
					state = 1;
					i--;
				}
				break;

			case 1:
				
				// q1 sacamos lo que tenemos en la pila
				if (i != cadena.length() && pila.top() == pila.Alphabet(cadena.charAt(i))) {
					resultStringBuilder.append("(q1, ").append(getCadenaFaltante(i)).append(", ").append(pila.estadoPila())
							.append(")\n");
					pila.pop();
					
					// verificar si estamos en S
					if (pila.top() == 'S') {
						resultStringBuilder.append("(q1, ").append("E").append(", ").append(pila.estadoPila()).append(")\n");
					}
					
					// si no tenemos transicion entonces la pila no es valida
				} else if (pila.top() != cadena.charAt(i)) {
					resultStringBuilder.append("No es palíndromo y no existe transición para el símbolo: ")
							.append(cadena.charAt(i)).append("\n");
					this.Transiciones = resultStringBuilder.toString();
					return false;
				}
				
				valid = true;
				break;
			}
		}
		
		this.Transiciones = resultStringBuilder.toString();
		return valid;
	}

	// Funcion para obtener la cadena que falta por leer
	private String getCadenaFaltante(int j) {
		String cad = "";
		while (j < cadena.length()) {
			cad += cadena.charAt(j);
			j++;
		}
		return cad;
	}

	// Función para obtener el resultado como una cadena
	public String getTransitionsResult() {
		return Transiciones;
	}
	
}
