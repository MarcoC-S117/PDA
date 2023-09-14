import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextPane;

@SuppressWarnings("serial")
public class GUI_PDA extends JFrame {

	private JPanel contentPane;
	private JTextField ExpresionField;
	private String cadena;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_PDA frame = new GUI_PDA();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GUI_PDA() {
		setTitle("1_3 PDA mejorado");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//añadir imagen del PDA
		JLabel ImgPda = new JLabel("");
		ImgPda.setBounds(424, 41, 354, 221);
		ImageIcon icon = new ImageIcon(getClass().getResource("/PDA.png"));
		ImgPda.setIcon(icon);
		contentPane.add(ImgPda);
		
		//Lenguaje formal
		JLabel Texto1 = new JLabel("PDA para el lenguaje : L = {w | w is a palindrome of a's and b's}");
		Texto1.setBounds(12, 12, 481, 17);
		contentPane.add(Texto1);
		
		//Imagen de la definicion formal
		JLabel ImgDefFormal = new JLabel("");
		ImgDefFormal.setBounds(12, 41, 236, 145);
		ImageIcon icon1 = new ImageIcon(getClass().getResource("/Formal.png"));
		ImgDefFormal.setIcon(icon1);
		contentPane.add(ImgDefFormal);

		//Transiciones del PDA
		JLabel ImgTransiciones = new JLabel("");
		ImgTransiciones.setBounds(260, 41, 152, 259);
		ImageIcon icon2 = new ImageIcon(getClass().getResource("/Transicion.png"));
		ImgTransiciones.setIcon(icon2);
		contentPane.add(ImgTransiciones);
		
		//Panel de texto donde se imprimen las transiciones
		JTextPane textPane = new JTextPane();
		textPane.setEditable(false);
		textPane.setBounds(12, 312, 766, 181);
		contentPane.add(textPane);

		// boton con llamada al PDA
		JButton btnNewButton = new JButton("Comprobar cadena");
		btnNewButton.setBounds(434, 273, 344, 27);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cadena = ExpresionField.getText();
				
				if (!cadena.isEmpty()) {
					// si los simbolos son validos y no esta vacia, entonces se evalua 
					if(contieneSoloAB(cadena)) {
						
						PDA pda = new PDA(cadena);
						String resultado = pda.Transitions() ? "Es palíndromo" : "No es palíndromo";
						String transiciones = pda.getTransitionsResult();
						textPane.setText(resultado + "\n" + transiciones);
						
					}else {
						textPane.setText("La cadena contiene un simbolo no valido");
					}
				} else {
					textPane.setText("La cadena no puede estar vacía");
				}
			}
		});
		
		contentPane.add(btnNewButton);
		
		//Panel donde se ingresa el texto
		ExpresionField = new JTextField();
		ExpresionField.setBounds(12, 214, 236, 86);
		contentPane.add(ExpresionField);
		ExpresionField.setColumns(10);
		
		JLabel lblIngreseUnaCadena = new JLabel("Ingrese una cadena");
		lblIngreseUnaCadena.setBounds(12, 185, 236, 17);
		contentPane.add(lblIngreseUnaCadena);

	}
	//funcion para comprobar que los simbolos son validos
	 public static boolean contieneSoloAB(String cadena) {
	        for (int i = 0; i < cadena.length(); i++) {
	            char caracter = cadena.charAt(i);
	            if (caracter != 'a' && caracter != 'b') {
	                return false;
	            }
	        }
	        return true;
	    }
}
