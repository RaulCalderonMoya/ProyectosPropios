import java.util.Map.Entry;

import javax.swing.JDialog;
import javax.swing.JTextArea;

public class MostrarDatosTodosLosClientes extends JDialog {
	
	private Hotel hotel;
	//private JTextArea textArea;
	
	public MostrarDatosTodosLosClientes(Hotel hotel) {
		this.hotel = hotel;
		//textArea = new JTextArea();
		hotel.mostrarInformacionClientes();
	}
}
