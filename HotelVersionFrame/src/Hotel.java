import java.awt.Dimension;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Hotel {
	// Un hotel cuenta con un sistema que almacena todos los registros de clientes
	// que tiene dicho hotel
	// con lo cual si buscamos al cliente por DNI, se debe encontrar todos los datos
	// asociados a dicho cliente,
	// ademas se puede saber si dicho cliente esta o no hospedado en el hotel
	private Map<String, Cliente> mapaClientesHotel;// La clave es el dni del cliente
	// private final int MAX_HABITACIONES ;
	// private String dniActual;
	private boolean clienteEncontrado;

	public Hotel() {
		// MAX_HABITACIONES = numHabitaciones;
		mapaClientesHotel = new HashMap<String, Cliente>();
		// dniActual = new String();
		clienteEncontrado = false;
	}

	public void registrarCliente(Cliente cliente) {
		if (!mapaClientesHotel.containsKey(cliente.getDni())) {// Verificamos que no esta agregado de antes
			mapaClientesHotel.put(cliente.getDni(), cliente);
			System.out.println("");
		} else {
			System.out.println("Este cliente ya habia sido agregado antes");
		}

	}

	public void eliminarCliente(String dni) {

		// Recorremos el mapa para comprobar si alguno de los cliente
		for (Entry entry : mapaClientesHotel.entrySet()) {
			if (entry.getKey().equals(dni)) {
				System.out.println("Se ha encontrado el cliente que desea eliminar");
				mapaClientesHotel.remove(entry.getKey());

			} else {
				System.out.println("No se encuentra dicho cliente en nuestros datos");
			}

		}
	}

	public void datosCliente(Cliente cliente) {
		System.out.println("Datos del cliente: ");
		System.out.println("DNI : " + cliente.getDni());
		System.out.println("Nombre :" + cliente.getNombre());
		System.out.println("Fecha de reserva: " + cliente.getFechaReserva());
		System.out.println("Numero de habitacion: " + cliente.getNumeroHabitacion());
	}

	public int getNumeroClientes() {
		System.out.println("El numero de clientes del hotel es de: " + mapaClientesHotel.size() + " clientes totales");
		return mapaClientesHotel.size();
	}

	public void modificarDatosCliente(String dni, Cliente clienteNuevo) {
		if (mapaClientesHotel.containsKey(dni)) {
			System.out.println("Se ha encontrado el cliente que desea modificar");
			// Reemplazar el cliente existente con el nuevo cliente
			mapaClientesHotel.put(dni, clienteNuevo);
		} else if (mapaClientesHotel.size() < 1) {
			System.out.println("No hay clientes con lo cual no se puede modificar nada");
		} else {
			System.out.println("No encontramos nada de lo que busca");
		}

	}

	public boolean buscarCliente(String dni) {
		//boolean encontrado = false;
		Cliente cliente = mapaClientesHotel.get(dni);
		for (Entry entry : mapaClientesHotel.entrySet()) {
			if (entry.getKey().equals(dni)) {
				System.out.println("Se ha encontrado el cliente que desea buscar");
				//datosCliente(cliente);
				clienteEncontrado = true;//Aqui lo ponemos a true
				String mensaje = "DNI: " + cliente.getDni() +
                        "\nNombre: " + cliente.getNombre() +
                        "\nFecha de reserva: " + cliente.getFechaReserva() +
                        "\nNúmero de habitación: " + cliente.getNumeroHabitacion();
				
				//Cambiar en cuanto se pueda hace lo que tiene que hacer pero queda un poco cutre
				JOptionPane.showInputDialog(Hotel.this, mensaje);
			}

		}
       return clienteEncontrado;
	}

	/*public void mostrarInformacionClientes() {
		int i = 0;
		for (Entry entry : mapaClientesHotel.entrySet()) {
			i++;
			System.out.println("\n***************************Informacion del cliente::: " + i + "\n");
			System.out.println("DNI: " + entry.getKey());
			Cliente clienteActual = (Cliente) entry.getValue();
			System.out.println("NOMBRE: " + clienteActual.getNombre());
			System.out.println("FECHA: " + clienteActual.getFechaReserva());
			System.out.println("NUMERO HABITACION: " + clienteActual.getNumeroHabitacion());
		}

	}*/
	


	public void mostrarInformacionClientes() {
        StringBuilder mensaje = new StringBuilder();
        int i = 0;
        for (Entry entry : mapaClientesHotel.entrySet()) {
            i++;
            mensaje.append("\n***************************Informacion del cliente::: ").append(i).append("\n");
            mensaje.append("DNI: ").append(entry.getKey()).append("\n");
            Cliente clienteActual = (Cliente) entry.getValue();
            mensaje.append("NOMBRE: ").append(clienteActual.getNombre()).append("\n");
            mensaje.append("FECHA: ").append(clienteActual.getFechaReserva()).append("\n");
            mensaje.append("NUMERO HABITACION: ").append(clienteActual.getNumeroHabitacion()).append("\n");
        }

        if (mensaje.length() > 0) {
            // Crear un JTextArea para contener el mensaje
            JTextArea textArea = new JTextArea(mensaje.toString());
            textArea.setEditable(false);

            // Crear un JScrollPane para agregar el JTextArea
            JScrollPane scrollPane = new JScrollPane(textArea);
            scrollPane.setPreferredSize(new Dimension(500, 300));

            // Mostrar la información de los clientes en un JOptionPane con JScrollPane
            JOptionPane.showMessageDialog(null, scrollPane, "Información de Clientes", JOptionPane.INFORMATION_MESSAGE);
        } else {
            System.out.println("No hay clientes registrados en el hotel.");
            JOptionPane.showMessageDialog(null, "No hay clientes registrados en el hotel.", "Información de Clientes", JOptionPane.INFORMATION_MESSAGE);
        }
    }
	

	public void crearArchivoGuardado() {

		try {
			FileWriter fileWriter = new FileWriter("guardado.txt");

			// Crear un objeto BufferedWriter
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

			// Recorrer el mapa y escribir los elementos en el archivo
			for (Map.Entry<String, Cliente> entry : mapaClientesHotel.entrySet()) {
				String clave = entry.getKey();
				Cliente cliente = entry.getValue();
				String linea = clave + ": " + cliente.toString(); // Adaptar cómo se desea guardar el cliente
				bufferedWriter.write(linea);
				bufferedWriter.newLine(); // Agregar una nueva línea para el siguiente elemento
			}

			// Cerrar el BufferedWriter
			bufferedWriter.close();

			System.out.println("Mapa guardado en el archivo exitosamente.");
		} catch (IOException e) {
			System.out.println("Ocurrió un error al guardar el archivo: " + e.getMessage());
		}

	}

	public List<String> guardarClavesMapa() {

		List<String> listadoClaves = new ArrayList<String>();
		for (Entry entry : mapaClientesHotel.entrySet()) {
			listadoClaves.add((String) entry.getKey());

		}
		return listadoClaves;
	}
	
	
    public boolean isClienteEncontrado() {
		return clienteEncontrado;
	}

	public void setClienteEncontrado(boolean clienteEncontrado) {
		this.clienteEncontrado = clienteEncontrado;
	}

}
