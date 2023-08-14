import java.awt.GridLayout;
import java.util.Iterator;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class DatosTodosLosClientes extends JDialog {
	// private JLabel labelDni;
	// private JTextField textDni;

	// private JButton botonAceptar;
	// private JButton botonCancelar;

	// private JPanel panelSuperior;
	// private JPanel panelInferior;

	private JTextArea areaTexto;

	private List<Cliente> listado;

	public DatosTodosLosClientes(List<Cliente> listadoClientes) {
		setTitle("Datos de todos los Clientes");
		setLayout(new GridLayout(1, 1));

//		labelDni = new JLabel("Introduzca el valor del DNI: ");
//		textDni = new JTextField();
//
//		botonAceptar = new JButton("Aceptar");
//		botonCancelar = new JButton("Cancelar");
//
//		panelSuperior = new JPanel();
//		panelInferior = new JPanel();

		this.listado = listadoClientes;
		areaTexto = new JTextArea();
		// **************************MODIFICACION DEL PANEL
		// SUPERIOR**********************//
//		panelSuperior.setLayout(new GridLayout(4, 1));
//		panelInferior.setLayout(new GridLayout(1, 2));
//
//		// Añadimos todos los elementos
//		panelSuperior.add(labelDni);
//		panelSuperior.add(textDni);
//
//		panelInferior.add(botonAceptar);
//		panelInferior.add(botonCancelar);
//
//		add(panelSuperior);
//		add(panelInferior);
		
		add(areaTexto);

		Iterator<Cliente> iterator = listado.iterator();
		int numClientes = 0;
		while (iterator.hasNext()) {
			Cliente c = iterator.next();
			numClientes++;
			// iterator.remove(); // Eliminamos el cliente existente usando el iterador
			areaTexto.append("**********CLIENTE*************\nDNI DEL CLIENTE: " + c.getDni() + "\nNOMBRE DEL CLIENTE: "
					+ c.getNombre() + "\nDINERO DEL CLIENTE: " + c.getDineroEnCaja() + "\n*********************");
			//NOTA: CON append concatenas y con setText modificas el texto, por eso salia con setText solo la ultima entrada introducida
			//setText ---> Modifica texto  ---> Texto 1(eliminado) --> Texto 2(eliminado)--> Texto 3(Texto no eliminado)
			//append ---> Concatena texto --> Texto 1 + Texto 2 + Texto 3

		}

		if (numClientes == 0) {// Existe el cliente que se desea eliminar
			JOptionPane.showMessageDialog(null, "No hay clientes agregados en la base de datos");
			dispose();
		} else if (numClientes != 0) {
			JOptionPane.showMessageDialog(null, "Hay un total de " + numClientes + " agregados en la base de datos");
			pack();
		}

//
//		// Introducimos un comportamiento a los botones
//		botonAceptar.addActionListener(new AceptarAccion());
//		botonCancelar.addActionListener(new CancelarAccion());

		setModal(true);// La hacemos modal para que nos fuerce a interactuar con la segunda ventana y
						// asi que no se nos olvide su existencia
		setVisible(true);
	}

}
