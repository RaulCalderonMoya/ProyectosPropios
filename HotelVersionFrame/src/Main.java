import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// Hacemos un bucle infinito porque debe funcionar en todo momento
		// Creamos el hotel
		//boolean pulsaSalir = false;// Si pulsa salir se activa este flag que fuerza a salir del do-while y terminar
									// el programa
		
		//Scanner sc = new Scanner(System.in);
		Hotel hotel = new Hotel();
		FramePrincipal frame = new FramePrincipal(hotel);
		//int opcion = -1;
		//System.out.println("Pulse una de las teclas para poder seleccionar una opcion");

		//sc.close();
		// Hotel hotel = new Hotel(numHabitaciones, dni);
	}

	/*
	 * Scanner sc = new Scanner(System.in); System.out.
	 * println("Introduzca datos del numero total de personas que caben en el hotel"
	 * ); int numHabitaciones = sc.nextInt();
	 * 
	 * System.out.println("Ahora introduzca el DNI del cliente"); String dni =
	 * sc.next();
	 * 
	 * System.out.println("Ahora debe indicar que habitacion desea tener"); String
	 * numHabitacion = sc.next();
	 * 
	 * System.out.println("Por ultimo, indique la fecha de reserva"); String
	 * fechaReserva = sc.next();
	 * 
	 * Cliente cliente = new Cliente(dni, dni, fechaReserva, numHabitacion);
	 * 
	 */

//	private static void mostrarMenu() {
//		System.out.println("**********************MENU DE OPCIONES***************************");
//		System.out.println("OPCION 1.--->INGRESAR CLIENTE");
//		System.out.println("OPCION 2.--->DAR DE BAJA CLIENTE");
//		System.out.println("OPCION 3.--->MODIFICAR DATOS RESERVA");
//		System.out.println("OPCION 4.--->SALIR PROGRAMA");
//		System.out.println("OPCION 5.--->GUARDAR DATOS DE RESERVAS");
//		System.out.println("OPCION 6.--->NUMERO DE CLIENTES");
//		System.out.println("OPCION 7.--->MOSTRAR DATOS DE ALGUN CLIENTE");
//		System.out.println("OPCION 8.--->MOSTRAR DATOS DE TODOS LOS CLIENTES");
//		System.out.println("**********************MENU DE OPCIONES***************************");
//	}

}
