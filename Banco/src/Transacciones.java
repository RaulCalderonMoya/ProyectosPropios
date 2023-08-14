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

public class Transacciones extends JDialog {
	//Datos del que emite la transaccion
	private JLabel labelDniEmisor;
	private JTextField textDniEmisor;
	//Datos del que recibe la transaccion
	private JLabel labelDniReceptor;
	private JTextField textDniReceptor;
	
	private JLabel cantidadDinero;
	private JTextField textDinero;

	private JButton botonAceptar;
	private JButton botonCancelar;

	private JPanel panelSuperior;
	private JPanel panelInferior;

	private List<Cliente> listado;

	public Transacciones(List<Cliente> listadoClientes) {
		setTitle("AñadirCliente");
		setLayout(new GridLayout(2, 1));

		labelDniEmisor = new JLabel("DNI del que emite la transaccion: ");
		textDniEmisor = new JTextField();

		labelDniReceptor = new JLabel("DNI del que recibe la transaccion: ");
		textDniReceptor = new JTextField();
		
		cantidadDinero = new JLabel("Introduzca Dinero: ");
		textDinero = new JTextField();
		
		botonAceptar = new JButton("Aceptar");
		
		botonCancelar = new JButton("Cancelar");
		
		
		panelSuperior = new JPanel();
		panelInferior = new JPanel();

		this.listado = listadoClientes;

		// **************************MODIFICACION DEL PANEL
		// SUPERIOR**********************//
		panelSuperior.setLayout(new GridLayout(5, 2));
		panelInferior.setLayout(new GridLayout(1, 2));

		// Añadimos todos los elementos
		panelSuperior.add(labelDniEmisor);
		panelSuperior.add(textDniEmisor);
		panelSuperior.add(labelDniReceptor);
		panelSuperior.add(textDniReceptor);
		panelSuperior.add(cantidadDinero);
		panelSuperior.add(textDinero);
		//panelSuperior.setSize(300, 150);

		panelInferior.add(botonAceptar);
		panelInferior.add(botonCancelar);
		//panelInferior.setSize(100, 50);
		add(panelSuperior);
		add(panelInferior);

		// Introducimos un comportamiento a los botones
		botonAceptar.addActionListener(new AceptarAccion());
		botonCancelar.addActionListener(new CancelarAccion());

		setSize(400, 250);
		setModal(true);// La hacemos modal para que nos fuerce a interactuar con la segunda ventana y
						// asi que no se nos olvide su existencia
		setVisible(true);
	}

	private class AceptarAccion implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String dniClienteEmisor = textDniEmisor.getText();
			String dniClienteReceptor = textDniReceptor.getText();
			String cantidadDinero = textDinero.getText();
			
			Cliente emisorProvisional = new Cliente(dniClienteEmisor, null);
			Cliente receptorProvisional = new Cliente(dniClienteReceptor, null);
			//*******************************BUSQUEDA DEL CLIENTE EMISOR**********************//
			 boolean clienteEmisorExiste = false;
		        // Utilizamos un iterador para recorrer la lista y eliminar el cliente existente
		        // si se encuentra
		        Iterator<Cliente> iterator = listado.iterator();
		        while (iterator.hasNext()) {
		            Cliente c = iterator.next();
		            if (c.getDni().equalsIgnoreCase(emisorProvisional.getDni())) {
		            	//Al hacer una transferencia significa perder dinero porque se pasa a otra cuenta con lo cual en la cuenta 1
		            	//restamos cantidadDinero para que en la cuenta 2 se sume dicha cantidadDinero
		            	double dineroATransferir = Double.parseDouble(cantidadDinero);
		            	
		            	if(c.tieneDinero(dineroATransferir)) {
		            		c.retirarDineroCliente(dineroATransferir);
		            	}
		            	
		            	clienteEmisorExiste = true;
		                break;
		            }
		        }
		        
		        
				if (!clienteEmisorExiste) {//Existe el cliente que se desea eliminar
					JOptionPane.showMessageDialog(null, "El DNI del emisor no esta registrado");
				}
			
				//*******************************BUSQUEDA DEL CLIENTE RECEPTOR**********************//
				 boolean clienteReceptorExiste = false;
			        // Utilizamos un iterador para recorrer la lista y eliminar el cliente existente
			        // si se encuentra
			        Iterator<Cliente> iterator2 = listado.iterator();
			        while (iterator2.hasNext()) {
			            Cliente c = iterator2.next();
			            if (c.getDni().equalsIgnoreCase(receptorProvisional.getDni())) {
			            	//Al hacer una transferencia significa perder dinero porque se pasa a otra cuenta con lo cual en la cuenta 1
			            	//restamos cantidadDinero para que en la cuenta 2 se sume dicha cantidadDinero
			            	double dineroATransferir = Double.parseDouble(cantidadDinero);
			            	c.ingresarDinero(dineroATransferir);
			            	clienteReceptorExiste = true;
			                break;
			            }
			        }
			        
			        
					if (!clienteReceptorExiste) {//Existe el cliente que se desea eliminar
						JOptionPane.showMessageDialog(null, "El DNI del receptor no esta registrado");
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
