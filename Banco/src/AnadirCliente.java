import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AnadirCliente extends JDialog {
	private JLabel labelDni;
	private JTextField textDni;
	private JLabel labelNombre;
	private JTextField textNombre;

	private JButton botonAceptar;
	private JButton botonCancelar;

	private JPanel panelSuperior;
	private JPanel panelInferior;

	private List<Cliente> listado;

	public AnadirCliente(List<Cliente> listadoClientes) {
		setTitle("AñadirCliente");
		setLayout(new GridLayout(2, 1));

		labelDni = new JLabel("Introduzca el valor del DNI: ");
		textDni = new JTextField();

		labelNombre = new JLabel("Introduzca el valor del Nombre: ");
		textNombre = new JTextField();

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
		panelSuperior.add(labelNombre);
		panelSuperior.add(textNombre);

		panelInferior.add(botonAceptar);
		panelInferior.add(botonCancelar);

		add(panelSuperior);
		add(panelInferior);

		// Introducimos un comportamiento a los botones
		botonAceptar.addActionListener(new AceptarAccion());
		botonCancelar.addActionListener(new CancelarAccion());

		setSize(200, 150);
		setModal(true);// La hacemos modal para que nos fuerce a interactuar con la segunda ventana y
						// asi que no se nos olvide su existencia
		setVisible(true);
	}

	private class AceptarAccion implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String dniClienteNuevo = textDni.getText();
			String nombreClienteNuevo = textNombre.getText();

			// Creamos de manera provisional un cliente para que si dicho cliente no estaba
			// agregado previamente en funcion del dni entonces se agrege y
			// de lo contrario no se agregue
			Cliente clienteNuevo = new Cliente(dniClienteNuevo, nombreClienteNuevo);

			// Como no podemos ver los dni directamente debeos recorrer cada elemento
			// cliente de la lista y comparar todos los dni de la lista con el
			// dni del nuevo cliente en cuestion
			boolean clienteExistente = false;
			//En una lista no se puede modificar el contenido mientras realizas la iteracion
			for (Cliente c : listado) {
				if (c.getDni().equalsIgnoreCase(clienteNuevo.getDni())) {
					clienteExistente = true;
					break;
				}
			}

			if (clienteExistente) {
				JOptionPane.showMessageDialog(null, "El DNI que indica ya existe");
			} else {
				listado.add(clienteNuevo);
				JOptionPane.showMessageDialog(null, "Cliente agregado con exito");
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
