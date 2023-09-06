public class PDA {

    private int Mitad_Cadena=0;
    private String cadena;
    private int state=0;
    PDAPila pila;

    PDA(String Cadena){
        Mitad_Cadena = Cadena.length()/2;
        this.cadena = Cadena;
        this.pila = new PDAPila(Mitad_Cadena+1);
    }

    boolean Transitions(){
        boolean valid = false;        
        for(int i=0; i<cadena.length();i++){        
            switch (state){
                case 0:
                    if(i<Mitad_Cadena){                        
                        state=0;
                        pila.push(cadena.charAt(i));       
                    }else {state = 1; i--;}
                break;
                case 1:                    
                    if(pila.empty()){
                        System.out.println("Es palindromo");
                    }
                    else if(i!=cadena.length() && pila.top()== cadena.charAt(i)){
                        state=1;                        
                        pila.pop();
                    } else if (pila.top()!= cadena.charAt(i)){
                        System.out.println("No es palindromo y no existe transicion para el simbolo: " + cadena.charAt(i));
                        return false;
                    } 
                    valid=true;
                    break;
                    }                   
            }         
        return valid;
    }
}
