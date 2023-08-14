
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class FramePrincipal extends JFrame { // Al hacer esto no hay que crear un objeto JFrame
	private JButton[] arrayBotones;
	private JLabel labelFoto;
	private JPanel panelBotones;

	private List<Cliente> listadoClientes;

	public FramePrincipal() {
		arrayBotones = new JButton[8];
		ImageIcon imagenPalmeras = new ImageIcon("img_50742.jpg");
		Image imagenEscalada = imagenPalmeras.getImage().getScaledInstance(400, 400, Image.SCALE_SMOOTH);
		ImageIcon imagenPalmerasEscalada = new ImageIcon(imagenEscalada);

		setLayout(new BorderLayout());

		labelFoto = new JLabel(imagenPalmerasEscalada);
		panelBotones = new JPanel();

		listadoClientes = new ArrayList<Cliente>();

		// JPanel panelContenido = (JPanel) getContentPane();
		// panelContenido.setLayout(new BorderLayout());

		panelBotones.setLayout(new GridLayout(8, 1));

		// Agregar el JLabel con la imagen de fondo al panel de contenido
		// panelContenido.add(labelFondo, BorderLayout.CENTER);

		// Añadimos los botones en el Frame
		for (int i = 0; i < arrayBotones.length; i++) {
			switch (i) {
			case 0:
				arrayBotones[i] = new JButton("OPCION 1.--->INGRESAR CLIENTE");
				break;
			case 1:
				arrayBotones[i] = new JButton("OPCION 2.--->DAR DE BAJA CLIENTE");
				break;
			case 2:
				arrayBotones[i] = new JButton("OPCION 3.--->INGRESAR DINERO");
				break;
			case 3:
				arrayBotones[i] = new JButton("OPCION 4.--->SACAR DINERO");
				break;
			case 4:
				arrayBotones[i] = new JButton("OPCION 5.--->HACER TRANSFERENCIA");
				break;
			case 5:
				arrayBotones[i] = new JButton("OPCION 6.--->MOSTRAR DATOS DE ALGUN CLIENTE");
				break;
			case 6:
				arrayBotones[i] = new JButton("OPCION 7.--->MOSTRAR DATOS DE TODOS LOS CLIENTES");
				break;
			case 7: 
				arrayBotones[i] = new JButton("OPCION 8.--->SALIR DEL PROGRAMA");
				break;
			}

			panelBotones.add(arrayBotones[i], BorderLayout.CENTER);
			add(panelBotones);
		}

		add(labelFoto, BorderLayout.SOUTH);

		// Damos el comportamiento necesario para los botones
		for (int i = 0; i < arrayBotones.length; i++) {
			arrayBotones[i].addActionListener(new ActionBoton());

		}

		// Configurar el JFrame
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setLocationRelativeTo(null); // Centrar el JFrame en la pantalla
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// Al pulsar la X se sale del programa
	}
	
	
	private class ActionBoton implements ActionListener {
		// Clase que se encarga de gestionar la pulsacion de los botones del menu de
		// opciones

		@Override
		public void actionPerformed(ActionEvent e) {
			JButton botonPulsado = (JButton) e.getSource();

			// Obtener el texto del botón para saber cuál de ellos se ha pulsado
			String textoBoton = botonPulsado.getText();


			if (textoBoton.equals("OPCION 1.--->INGRESAR CLIENTE")) {
				System.out.println("Ha pulsado la opcion ingresar cliente");
				AnadirCliente anadirCliente = new AnadirCliente(listadoClientes);
				
			} else if (textoBoton.equals("OPCION 2.--->DAR DE BAJA CLIENTE")) {
				System.out.println("Ha pulsado la opcion dar baja a cliente");
				EliminarCliente eliminar = new EliminarCliente(listadoClientes);
			} else if (textoBoton.equals("OPCION 3.--->INGRESAR DINERO")) {
				System.out.println("Ha pulsado la opcion de ingresar dinero");
				Ingresar ingresar = new Ingresar(listadoClientes);
			} else if (textoBoton.equals("OPCION 4.--->SACAR DINERO")) {
				System.out.println("Ha pulsado la opcion de sacar dinero");
				SacarDinero sacar = new SacarDinero(listadoClientes);
			} else if (textoBoton.equals("OPCION 5.--->HACER TRANSFERENCIA")) {
				System.out.println("Ha pulsado la opcion de hacer transferencia");
				Transacciones transaccion = new Transacciones(listadoClientes);
			} else if (textoBoton.equals("OPCION 6.--->MOSTRAR DATOS DE ALGUN CLIENTE")) {
				System.out.println("Ha pulsado la opcion mostrar datos de algun cliente");
				DatosUnCliente datos = new DatosUnCliente(listadoClientes);
			} else if (textoBoton.equals("OPCION 7.--->MOSTRAR DATOS DE TODOS LOS CLIENTES")) {
				System.out.println("Ha pulsado la opcion mostrar datos de todos los clientes");
				DatosTodosLosClientes datosTotales = new DatosTodosLosClientes(listadoClientes);
			}else if(textoBoton.equals("OPCION 8.--->SALIR DEL PROGRAMA")) {
				System.out.println("Ha pulsado la opcion salir del programa");
				System.exit(0);
			}

			

		}

	}

}
