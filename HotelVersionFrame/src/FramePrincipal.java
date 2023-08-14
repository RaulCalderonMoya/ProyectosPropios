
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
	private Hotel hotel;

	public FramePrincipal(Hotel hotelParam) {
		arrayBotones = new JButton[8];
		ImageIcon imagenPalmeras = new ImageIcon(
				"Caribbean-palm-trees-beach-sea-clouds-Dominican-Republic_1920x1080.jpg");
		Image imagenEscalada = imagenPalmeras.getImage().getScaledInstance(400, 400, Image.SCALE_SMOOTH);
		ImageIcon imagenPalmerasEscalada = new ImageIcon(imagenEscalada);
		this.hotel = hotelParam;

		setLayout(new BorderLayout());

		labelFoto = new JLabel(imagenPalmerasEscalada);
		panelBotones = new JPanel();

		// JPanel panelContenido = (JPanel) getContentPane();
		// panelContenido.setLayout(new BorderLayout());

		panelBotones.setLayout(new GridLayout(8, 1));

		// Agregar el JLabel con la imagen de fondo al panel de contenido
		// panelContenido.add(labelFondo, BorderLayout.CENTER);

		// Añadimos los botones en el Frame
		for (int i = 0; i < 8; i++) {
			switch (i) {
			case 0:
				arrayBotones[i] = new JButton("OPCION 1.--->INGRESAR CLIENTE");
				break;
			case 1:
				arrayBotones[i] = new JButton("OPCION 2.--->DAR DE BAJA CLIENTE");
				break;
			case 2:
				arrayBotones[i] = new JButton("OPCION 3.--->MODIFICAR DATOS RESERVA");
				break;
			case 3:
				arrayBotones[i] = new JButton("OPCION 4.--->SALIR PROGRAMA");
				break;
			case 4:
				arrayBotones[i] = new JButton("OPCION 5.--->GUARDAR DATOS DE RESERVAS");
				break;
			case 5:
				arrayBotones[i] = new JButton("OPCION 6.--->NUMERO DE CLIENTES");
				break;
			case 6:
				arrayBotones[i] = new JButton("OPCION 7.--->MOSTRAR DATOS DE ALGUN CLIENTE");
				break;
			case 7:
				arrayBotones[i] = new JButton("OPCION 8.--->MOSTRAR DATOS DE TODOS LOS CLIENTES");
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
		Scanner sc = new Scanner(System.in);

		boolean estaRegistrado = false;

		@Override
		public void actionPerformed(ActionEvent e) {
			JButton botonPulsado = (JButton) e.getSource();

			// Obtener el texto del botón para saber cuál de ellos se ha pulsado
			String textoBoton = botonPulsado.getText();

//	    if (!pulsaSalir) {
//	    	
//	    	
//	    }else {
//	    	
//	    }

			if (textoBoton.equals("OPCION 1.--->INGRESAR CLIENTE")) {
				System.out.println("Ha pulsado la opcion ingresar cliente");
				AnadirClienteDialog anadirCLiente = new AnadirClienteDialog(hotel);

			} else if (textoBoton.equals("OPCION 2.--->DAR DE BAJA CLIENTE")) {
				System.out.println("Ha pulsado la opcion dar baja a cliente");

				EliminarClienteDialog eliminarCliente = new EliminarClienteDialog(hotel);

			} else if (textoBoton.equals("OPCION 3.--->MODIFICAR DATOS RESERVA")) {
				System.out.println("Ha pulsado la opcion modificar datos de cliente");
				PedirDniModificacion pedirDatos = new PedirDniModificacion(hotel);
				
				/*
				 * System.out.println("Ha pulsado la opcion modificar datos cliente");
					// Para modificar lo que hacemos es basico decimos lo siguiente: primero
					// buscamos por DNI y volvemos a poner los datos de nuevo salvo DNI
					System.out.println("¿Qué DNI tiene el cliente que quiere modificar los datos?");
					

					String dniBusqueda = sc.next();

					List<String> listadoDnis = hotel.guardarClavesMapa();
					// Debemos comprobar que ese DNI esta de lo contrario no tiene sentido que
					// sigamos ejecutando
					if (listadoDnis.contains(dniBusqueda)) {
						estaRegistrado = true;
					}

					if (estaRegistrado) { // Si esta registrado habra que modificar los valores de lo contrario no hay que
											// hacer nada mas

						System.out.println("Ahora introduzca los nuevos valores.................");
						System.out.println("¿Qué nombre tiene el cliente?");
						String nombreNuevo = sc.next();

						System.out.println("¿Qué fecha de reserva tiene el cliente?");
						String fechaNueva = sc.next();

						System.out.println("¿Qué habitacion tiene el cliente?");
						String numHabitacionNueva = sc.next();

						Cliente clienteDatosNuevos = new Cliente(dniBusqueda, nombreNuevo, fechaNueva, numHabitacionNueva);

						// Hacemos una forma de que el cliente pueda verificar los cambios antes de
						// realizarlos por si se arrepiente o se ha equivocado al decir
						// que quiere modificar los datos

						System.out.println(
								"Indique si esta seguro de realizar la modificacion pertinente[SI/NO][En Mayúsculas]");
						String decision = sc.next();

						if (decision.equalsIgnoreCase("SI")) {
							hotel.modificarDatosCliente(dniBusqueda, clienteDatosNuevos);
						} else {
							System.out.println("De acuerdo los valores seguiran como estaban");
						}

					}

				 * */
				
				//ModificarClienteDialog modificarDatos = new ModificarClienteDialog(hotel); //Esto se pide una vez que se ha encontrado el DNI en la base de datos
			} else if (textoBoton.equals("OPCION 4.--->SALIR PROGRAMA")) {
				System.out.println("Ha pulsado la opcion salir del programa");
				System.exit(0);
			} else if (textoBoton.equals("OPCION 5.--->GUARDAR DATOS DE RESERVAS")) {
				System.out.println("Ha pulsado la opcion guardar datos del hotel");

				String ruta = "./guardado.txt";// Lo almacena en Raiz

				/** TERMINAR **/
				// TODO
			} else if (textoBoton.equals("OPCION 6.--->NUMERO DE CLIENTES")) {
				//hotel.getNumeroClientes();
				ContarClientes mostrarDatos = new ContarClientes(hotel);
			} else if (textoBoton.equals("OPCION 7.--->MOSTRAR DATOS DE ALGUN CLIENTE")) {
				// Para ver los datos del cliente se debe saber a que cliente se desean ver los
				// datos
				//System.out.println("¿Qué DNI tiene el cliente que quiere modificar los datos?");
				//String DNI = sc.next();
				MostrarDatosDeUno mostrarUno = new MostrarDatosDeUno(hotel);
				//hotel.buscarCliente(DNI);
			} else if (textoBoton.equals("OPCION 8.--->MOSTRAR DATOS DE TODOS LOS CLIENTES")) {
				//System.out.println("Se van a mostrar todos los datos de todos los clientes");
				//hotel.mostrarInformacionClientes();
				
				MostrarDatosTodosLosClientes mostrarTodos = new MostrarDatosTodosLosClientes(hotel);
			}

			// System.out.println("Botón pulsado: " + textoBoton);

		}

	}

}
