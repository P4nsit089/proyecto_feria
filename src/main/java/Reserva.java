import java.time.LocalDate;

public class Reserva {
	private int ReservaId; 
	private int ClienteId;
	private int HabitacionId;
	private LocalDate FechaIngreso;
	private LocalDate FechaSalida;
	private String MetodoPago;

	public Reserva (int ReservaId, int ClienteId , int HabitacionId, LocalDate FechaIngreso, LocalDate FechaSalida, String MetodoPago) {
		this.ReservaId=ReservaId;
		this.ClienteId=ClienteId;
		this.HabitacionId=HabitacionId;
		this.FechaIngreso=FechaIngreso;
		this.FechaSalida=FechaSalida;
		this.MetodoPago=MetodoPago;
	}

	public int getReservaId() {
		return ReservaId;
	}

	public void setReservaId(int reservaId) {
		ReservaId = reservaId;
	}

	public int getClienteId() {
		return ClienteId;
	}

	public void setClienteId(int clienteId) {
		ClienteId = clienteId;
	}

	public int getHabitacionId() {
		return HabitacionId;
	}

	public void setHabitacionId(int habitacionId) {
		HabitacionId = habitacionId;
	}

	public LocalDate getFechaIngreso() {
		return FechaIngreso;
	}

	public void setFechaIngreso(LocalDate fechaIngreso) {
		FechaIngreso = fechaIngreso;
	}

	public LocalDate getFechaSalida() {
		return FechaSalida;
	}

	public void setFechaSalida(LocalDate fechaSalida) {
		FechaSalida = fechaSalida;
	}

	public String getMetodoPago() {
		return MetodoPago;
	}

	public void setMetodoPago(String metodoPago) {
		MetodoPago = metodoPago;
	}
}
 