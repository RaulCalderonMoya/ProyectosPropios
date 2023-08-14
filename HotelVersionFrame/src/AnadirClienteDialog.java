import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AnadirClienteDialog extends JDialog {
	// Clase que se encarga de agregar los clientes al hotel con los campos
	// necesarios que nos sirven para poder
	// pedir dichos datos
	private JTextField areaDni;//
	private JTextField areaNombre;//
	private JTextField fechaReserva;//
	private JTextField habitacion;//

	private JLabel labelDni;//
	private JLabel labelNombre;//
	private JLabel labelFecha;//
	private JLabel labelNumHab;//

	private JPanel panelDatos;
	private JPanel panelVerificacion;

	private JButton aceptarOperacion;
	private JButton denegarOperacion;

	private Hotel hotel;// Le pasamos el hotel del FramePrincipal para que tenga acceso al contenido del
						// FramePrincipal
	private boolean dniCorrecto;
	private boolean nombreCorrecto;
	private boolean fechaCorrecta;
	private boolean habitacionCorrecta;

	public AnadirClienteDialog(Hotel hotel) {
		labelDni = new JLabel("Introduzca el valor del DNI del cliente: ");
		areaDni = new JTextField();
		labelNombre = new JLabel("Introduzca el valor del nombre del cliente: ");
		areaNombre = new JTextField();
		labelFecha = new JLabel("Introduzca el valor de la fecha del cliente: ");
		fechaReserva = new JTextField();
		labelNumHab = new JLabel("Introduzca el valor de la habitacion del cliente: ");
		habitacion = new JTextField();

		this.hotel = hotel;
	
		dniCorrecto = false;
		nombreCorrecto = false;
		fechaCorrecta = false;
		habitacionCorrecta = false;

		panelDatos = new JPanel();
		panelVerificacion = new JPanel();

		setLayout(new BorderLayout());

		panelDatos.setLayout(new GridLayout(8, 1));
		// setLayout(new GridLayout());
		panelVerificacion.setLayout(new BorderLayout());

		// Primero metemos los datos de la ventana de panelDatos
		panelDatos.add(labelDni);
		panelDatos.add(areaDni);
		panelDatos.add(labelNombre);
		panelDatos.add(areaNombre);
		panelDatos.add(labelFecha);
		panelDatos.add(fechaReserva);
		panelDatos.add(labelNumHab);
		panelDatos.add(habitacion);

		// Ahora nos encargamos del panel de Verificacion
		aceptarOperacion = new JButton("Aceptar");
		denegarOperacion = new JButton("Cancelar");

		panelVerificacion.add(aceptarOperacion, BorderLayout.WEST);
		panelVerificacion.add(denegarOperacion, BorderLayout.EAST);

		aceptarOperacion.addActionListener(new PulsarAceptar());
		denegarOperacion.addActionListener(new PulsarDenegar());

		panelDatos.setVisible(true);
		panelVerificacion.setVisible(true);

		// Por ultimo hacemos que los paneles se agregen al JDialog
		add(panelDatos, BorderLayout.NORTH);

		add(panelVerificacion, BorderLayout.CENTER);

		setTitle("Añadir Cliente");
		setSize(400, 300);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null); // Centrar el JDialog en la pantalla
		setModal(true); // Hacemos que el JDialog sea modal (bloquea interacción con la ventana
						// principal)
		setVisible(true);

	}

	private class PulsarAceptar implements ActionListener {// Comportamiento al pulsar el boton Aceptar

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

			// Cuando ingreso un cliente primero debo crear como tal a dicho cliente
			// System.out.println("¿Qué DNI tiene el cliente?");
			String dni = areaDni.getText().trim();

			// System.out.println("¿Qué nombre tiene el cliente?");
			String nombre = areaNombre.getText().trim();

			// System.out.println("¿Qué fecha de reserva tiene el cliente?");
			String fecha = fechaReserva.getText().trim();

			// System.out.println("¿Qué habitacion tiene el cliente?");
			String numHabitacion = habitacion.getText().trim();

			//***********************COMPROBACION DNI***********************************//
			String regexDni = "[0-9]{8}[a-zA-Z]$";

			final Pattern patternDni = Pattern.compile(regexDni, Pattern.MULTILINE);
			final Matcher matcherDni = patternDni.matcher(dni);

			if (!matcherDni.find()) {
				JOptionPane.showMessageDialog(AnadirClienteDialog.this,
						"No ha escrito bien el DNI tiene que escribir 8 numeros y una letra");
				dniCorrecto = false;
			}else {
				dniCorrecto = true;
			}
			//***********************COMPROBACION NOMBRE***********************************//
			
			String regexNombre = "^[\\p{L} .'-]+$";

			final Pattern patternNombre = Pattern.compile(regexNombre, Pattern.MULTILINE);
			final Matcher matcherNombre = patternNombre.matcher(nombre);

			if (!matcherNombre.find()) {
				JOptionPane.showMessageDialog(AnadirClienteDialog.this,
						"No ha escrito bien el Nombre");
				nombreCorrecto  = false;
			}else {
				nombreCorrecto = true;
			}
			
			
			String regexFecha = "[0-9]{2}\\/[0-9]{2}\\/[0-9]{4}";
			
			final Pattern patternFecha = Pattern.compile(regexFecha, Pattern.MULTILINE);
			final Matcher matcherFecha = patternFecha.matcher(fecha);

			if (!matcherFecha.find()) {
				JOptionPane.showMessageDialog(AnadirClienteDialog.this,
						"No ha escrito bien la fecha Formato : DD/MM/YYYY");
				fechaCorrecta = false;
			}else {
				fechaCorrecta = true;
			}
			
			String regexHab = "[0-9]";
			
			final Pattern patternHab = Pattern.compile(regexHab, Pattern.MULTILINE);
			final Matcher matcherHab = patternHab.matcher(numHabitacion);

			if (!matcherHab.find()) {
				JOptionPane.showMessageDialog(AnadirClienteDialog.this,
						"No se encuentra dicha habitacion error expresion regular");
				habitacionCorrecta = false;
			}else {
				habitacionCorrecta = true;
			}
			
			
			
			
			

			if (dni.isEmpty() || nombre.isEmpty() || fecha.isEmpty() || numHabitacion.isEmpty()) {
				JOptionPane.showMessageDialog(AnadirClienteDialog.this, "Por favor, complete todos los campos.",
						"Campos incompletos", JOptionPane.ERROR_MESSAGE);
			} else {

				if(dniCorrecto && nombreCorrecto && fechaCorrecta && habitacionCorrecta) {

					Cliente cliente = new Cliente(dni, nombre, fecha, numHabitacion);

					hotel.registrarCliente(cliente);
					// System.out.println("Se ha añadido con exito");
					JOptionPane.showMessageDialog(AnadirClienteDialog.this, "Se ha agregado con exito el cliente");
					// dispose();-->Se cierra si ya no quiere añadir ninguno mas
				}
				
			}

		}

	}

	private class PulsarDenegar implements ActionListener {// Comportamiento al pulsar el boton Denegar

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			dispose();
		}

	}

}
