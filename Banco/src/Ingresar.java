import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Ingresar extends JDialog {
	private JLabel labelDni;
	private JTextField textDni;
	private JLabel labelDinero;
	private JTextField textDinero;


	private JButton botonAceptar;
	private JButton botonCancelar;

	private JPanel panelSuperior;
	private JPanel panelInferior;

	private List<Cliente> listado;
	
	

	public Ingresar(List<Cliente> listadoClientes) {
		setTitle("Ingresar Dinero a una cuenta");
		setLayout(new GridLayout(2, 1));

		labelDni = new JLabel("Introduzca el valor del DNI: ");
		textDni = new JTextField();
		labelDinero = new JLabel("Introduzca el valor de la cantidad a ingresar");
		textDinero = new JTextField();
		

		botonAceptar = new JButton("Aceptar");
		botonCancelar = new JButton("Cancelar");

		panelSuperior = new JPanel();
		panelInferior = new JPanel();

		this.listado = listadoClientes;

		// **************************MODIFICACION DEL PANEL
		// SUPERIOR**********************//
		panelSuperior.setLayout(new GridLayout(4, 1));
		panelInferior.setLayout(new GridLayout(1, 2));

		// Añadimos todos los elementos
		panelSuperior.add(labelDni);
		panelSuperior.add(textDni);
		panelSuperior.add(labelDinero);//Añade el texto que indica que debe introducir cierta cantidad de dinero
		panelSuperior.add(textDinero);
		
		
		panelInferior.add(botonAceptar);
		panelInferior.add(botonCancelar);

		add(panelSuperior);
		add(panelInferior);

		// Introducimos un comportamiento a los botones
		botonAceptar.addActionListener(new AceptarAccion());
		botonCancelar.addActionListener(new CancelarAccion());

		setSize(280, 200);
		setModal(true);// La hacemos modal para que nos fuerce a interactuar con la segunda ventana y
						// asi que no se nos olvide su existencia
		setVisible(true);
	}

	private class AceptarAccion implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String dniClienteNuevo = textDni.getText();

			// Creamos de manera provisional un cliente para que si dicho cliente no estaba
			// agregado previamente en funcion del dni entonces se agrege y
			// de lo contrario no se agregue
			Cliente clienteRef = new Cliente(dniClienteNuevo, null); //Creamos un cliente con dicho dni que nos sirva para recorrer dicho array pero no nos sirve para nada mas

			// Como no podemos ver los dni directamente debeos recorrer cada elemento
			// cliente de la lista y comparar todos los dni de la lista con el
			// dni del nuevo cliente en cuestion
	        boolean clienteExistente = false;
	        // Utilizamos un iterador para recorrer la lista y eliminar el cliente existente
	        // si se encuentra
	        Iterator<Cliente> iterator = listado.iterator();
	        while (iterator.hasNext()) {
	            Cliente c = iterator.next();
	            if (c.getDni().equalsIgnoreCase(clienteRef.getDni())) {
	                //iterator.remove(); // Eliminamos el cliente existente usando el iterador
	            	//Cuando encuentra a dicho cliente debe realizar el ingreso que le pida en el campo de TextField
	            	//TODO Expresiones regulares para asegurarnos que es un numero double
	            	String dineroAIngresar =  textDinero.getText();//Obtengo el diero que el cliente desea ingresar
	            	double dinero = Double.parseDouble(dineroAIngresar);
	            	c.ingresarDinero(dinero);
	            	
	            	
	                clienteExistente = true;
	                break;
	            }
	        }
	        
	        
			if (clienteExistente) {//Existe el cliente que se desea eliminar
				JOptionPane.showMessageDialog(null, "Cliente con transferencia realizada");
			} else {
				JOptionPane.showMessageDialog(null, "El DNI no esta registrado");
			}
		}

	}

	private class CancelarAccion implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			dispose();
		}

	}

}
