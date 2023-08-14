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

public class PedirDniModificacion extends JDialog{
	
	private Hotel hotel;
	
	private JButton aceptarOperacion;
	private JButton denegarOperacion;
	
	private JTextField areaDni;//
	
	
	private JPanel panelDatos;
	private JPanel panelVerificacion;
	private boolean dniCorrecto;
	
	private JLabel labelDni;
	
	public PedirDniModificacion(Hotel hotel) {
		this.hotel = hotel;
		dniCorrecto = false;
		
		labelDni = new JLabel("Introduzca el valor del DNI del cliente: ");
		areaDni = new JTextField();
		
		aceptarOperacion = new JButton("Aceptar");
		denegarOperacion = new JButton("Cancelar");
		
		panelDatos = new JPanel();
		panelVerificacion = new JPanel();
		
		setLayout(new BorderLayout());

		panelDatos.setLayout(new GridLayout(1, 1));
		// setLayout(new GridLayout());
		panelVerificacion.setLayout(new BorderLayout());
		
		panelDatos.add(labelDni);
		panelDatos.add(areaDni);
		

		panelVerificacion.add(aceptarOperacion, BorderLayout.WEST);
		panelVerificacion.add(denegarOperacion, BorderLayout.EAST);

		aceptarOperacion.addActionListener(new PulsarAceptar());
		denegarOperacion.addActionListener(new PulsarDenegar());

		panelDatos.setVisible(true);
		panelVerificacion.setVisible(true);

		// Por ultimo hacemos que los paneles se agregen al JDialog
		add(panelDatos, BorderLayout.CENTER);

		add(panelVerificacion, BorderLayout.SOUTH);

		setTitle("Añadir Cliente");
		setSize(460, 100);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null); // Centrar el JDialog en la pantalla
		setModal(true); // Hacemos que el JDialog sea modal (bloquea interacción con la ventana
						// principal)
		setVisible(true);
	}
	
	
	private class PulsarDenegar implements ActionListener {// Comportamiento al pulsar el boton Denegar

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			dispose();
		}

	}
	

	private class PulsarAceptar implements ActionListener {// Comportamiento al pulsar el boton Aceptar

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

			// Cuando ingreso un cliente primero debo crear como tal a dicho cliente
			// System.out.println("¿Qué DNI tiene el cliente?");
			String dni = areaDni.getText().trim();


			String regexDni = "[0-9]{8}[a-zA-Z]$";

			final Pattern patternDni = Pattern.compile(regexDni, Pattern.MULTILINE);
			final Matcher matcherDni = patternDni.matcher(dni);

			if (!matcherDni.find()) {
				JOptionPane.showMessageDialog(PedirDniModificacion.this,
						"No ha escrito bien el DNI tiene que escribir 8 numeros y una letra");
				dniCorrecto = false;
			}else {
				dniCorrecto = true;
			}

			
			
			
			
			

			if (dni.isEmpty()) {
				JOptionPane.showMessageDialog(PedirDniModificacion.this, "Por favor, complete todos los campos.",
						"Campos incompletos", JOptionPane.ERROR_MESSAGE);
			} else {

				if(dniCorrecto) {
					//Acciones a realizar si el DNI es correcto
					//hotel.eliminarCliente(dni);
					//hotel.buscarCliente(dni);
					
					if(hotel.buscarCliente(dni)) {//Si lo encuentra
						hotel.setClienteEncontrado(false);//Ponemos flag a false para el siguiente cliente
						ModificarClienteDialog modificarDatos = new ModificarClienteDialog(hotel);
						
					}else {
						JOptionPane.showMessageDialog(PedirDniModificacion.this, "El cliente no está registrado en el hotel",
								"Cliente no encontrado", JOptionPane.ERROR_MESSAGE);
					}
					
					
					
					//JOptionPane.showMessageDialog(MostrarDatosDeUno.this, "Se ha eliminado con exito el cliente");
					// dispose();-->Se cierra si ya no quiere añadir ninguno mas
				}
				
			}

		}

	}
	
}
