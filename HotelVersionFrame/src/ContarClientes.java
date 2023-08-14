import javax.swing.JDialog;
import javax.swing.JOptionPane;

public class ContarClientes extends JDialog{
	private Hotel hotel;
	
	public ContarClientes(Hotel hotel) {
		this.hotel = hotel;
		
		if(hotel.getNumeroClientes() == 0) {
			JOptionPane.showMessageDialog(ContarClientes.this,
					"No hay ningún cliente registrado en el hotel");
		}else if(hotel.getNumeroClientes() < 0) {
			JOptionPane.showMessageDialog(ContarClientes.this,
					"ERROR! EL HOTEL CUENTA CON UN NUMERO DE USUARIOS NEGATIVO");
		}else if(hotel.getNumeroClientes() > 0) {
			JOptionPane.showMessageDialog(ContarClientes.this,
					"Hay un total de :"+hotel.getNumeroClientes()+"clientes");
		}
		
	}
	
}
