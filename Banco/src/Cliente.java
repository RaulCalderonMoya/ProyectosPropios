import javax.swing.JOptionPane;

public class Cliente {
	private final String dni;
	private String nombre;
	private double dineroEnCaja;

	private boolean tieneDinero;// Si dinero es > 0 --> true
								// Si dinero es <= 0 --> false

	public Cliente(String dni, String nombre) {
		this.dni = dni;
		this.nombre = nombre;
		// Cuando un cliente abre una cuenta empieza de cero a menos que ya exista su
		// cuenta con lo cual
		// empieza con cero euros hasta que realice un ingreso
		dineroEnCaja = 0;
		tieneDinero = false; // Al inicio no tiene dinero
	}



	public void ingresarDinero(double cantidadAIngresar) {
		dineroEnCaja = dineroEnCaja + cantidadAIngresar;
	}

	public void retirarDineroCliente(double cantidadARetirar) {
		dineroEnCaja = dineroEnCaja - cantidadARetirar;
	}

	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getDineroEnCaja() {
		return dineroEnCaja;
	}
	
	public void setDineroEnCaja(double dinero) {//Usado para hacer transferencias de dinero
		this.dineroEnCaja = dinero;
	}
	
	
	public String getDni() {
		return dni;
	}
	

	public boolean tieneDinero(double dinero) {//Me pasan por aqui el dinero que se transfiere de una cuenta a otra
		
		if(dineroEnCaja <= 0) {
			tieneDinero = false;
		}else if(dinero > dineroEnCaja && dineroEnCaja > 0){
		    JOptionPane.showMessageDialog(null, "No tiene suficiente dinero la cuenta");
			tieneDinero = false;
		}else if(dinero < dineroEnCaja && dineroEnCaja > 0) {
			JOptionPane.showMessageDialog(null, "El cliente tiene dinero");
			tieneDinero = true;
		}
		
		
		
		return tieneDinero;
	}


}
