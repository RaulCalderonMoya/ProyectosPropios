import java.util.Objects;

public class Cliente {
	//Un cliente tiene una clave que le identifica de manera univoca y es su DNI, que tiene  un valor: [0-9]{8}[A-Z]{1}
	private String dni;
	private String nombre;
	private String fechaReserva;
	private String numeroHabitacion;
	
	public Cliente(String dni, String nombre, String fecha, String numeroHabitacion) {
		this.dni = dni;
		this.nombre = nombre;
		this.fechaReserva = fecha;
		this.numeroHabitacion = numeroHabitacion;
	}
	
	public String getNumeroHabitacion() {
		return numeroHabitacion;
	}

	public void setNumeroHabitacion(String numeroHabitacion) {
		this.numeroHabitacion = numeroHabitacion;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dni);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(dni, other.dni);
	}
	
	
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getFechaReserva() {
		return fechaReserva;
	}
	public void setFechaReserva(String fechaReserva) {
		this.fechaReserva = fechaReserva;
	}
	
	
	
	
	
}
