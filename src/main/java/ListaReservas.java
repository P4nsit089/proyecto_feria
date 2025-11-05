import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class ListaReservas {
    private List<Reserva> reserva = new ArrayList<>();
	private List<Habitacion> habitaciones;
	
	public ListaReservas(){
		habitaciones = new ArrayList<>();
		habitaciones.add(new Habitacion(1, 2, 15000," para 2 personas con 2 camas individuales", "estandar"));
		habitaciones.add(new Habitacion(2, 2, 15000," para 2 persona con 2 camas individuales", "estandar"));
		habitaciones.add(new Habitacion(3, 2, 15000," para 2 personas con 2 cama inidividuales", "estandar"));
		habitaciones.add(new Habitacion(4, 3, 25000," para 3 personas con 1 una matrimonial y 2 individuales ", "suite"));
		habitaciones.add(new Habitacion(5, 3, 25000," para 3 personas con  1 cama matrimonial y 2 individuales", "suite"));
		habitaciones.add(new Habitacion(6, 4, 30000," para 4 personas con 4 camas individuales", "king"));
		habitaciones.add(new Habitacion(7, 4, 30000," para 4 persona con 4 camas individuales", "king"));
		habitaciones.add(new Habitacion(8, 4, 30000," para 4 personas con 4 camas individuales", "king"));
		habitaciones.add(new Habitacion(9, 5, 35000," para 5 persona con cama matrimonial y 4 individuales", "presidencial"));
		habitaciones.add(new Habitacion(10, 5, 35000," para 5 personas con cama matrimonial y 4 individuales", "presidencial"));
	}

	public void CrearReserva(int ReservaId, int ClienteId , int HabitacionId, LocalDate FechaIngreso, LocalDate FechaSalida, String MetodoPago){
		Reserva reserva = new Reserva(ReservaId,ClienteId,HabitacionId,FechaIngreso,FechaSalida,MetodoPago);
	    this.reserva.add(reserva);
	}


	public void AgregarReserva(Reserva reserva) {
		this.reserva.add(reserva);
	}
	
		
	public void CancelacionReserva (int reservitaId){
		for (int i=0; i<=reserva.size();i++) {
			Reserva reservita = reserva.get(i);
			if (reservita.getReservaId()==reservitaId) {
				reserva.remove(reserva.get(i));
			}
		}
	}
	
	public void HistorialReservaClientes(int clienteId) {
		for (int i=0; i<=reserva.size();i++) {
			Reserva reservita = reserva.get(i);
			if (reservita.getClienteId()==clienteId)  {
				System.out.println(reserva);
			}
		}
	}
	public void TiempoReservado (int ReservaId) {
		for (int i=0; i<=reserva.size();i++) {
			Reserva reservita = reserva.get(i);
			if (reservita.getReservaId()==ReservaId)  {
				System.out.println("Tiempo Reservado" +
				  ChronoUnit.DAYS.between(reservita.getFechaIngreso(), reservita.getFechaSalida())
				  + " dias.");
	        }
	    }
	}
	
}
