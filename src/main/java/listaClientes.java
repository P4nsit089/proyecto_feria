import java.util.ArrayList;
import java.util.List;
public class listaClientes {

	List<Cliente> cliente = new ArrayList<>();
	
	
	public void AgregarCliente(Cliente cliente) {
		this.cliente.add(cliente);
	}
	
	public void MostrarCliente(int idcliente) {
		for (int i=0;i<=cliente.size();i++) {
			Cliente clientito = cliente.get(i);
		if (clientito.getId()==idcliente) {
			clientito.InfoCliente();
		} else {
			System.out.println("Cliente no encontrado X");
		}
		}
	}
	
	public void EliminarCliente (int idcliente) {
		for (int i=0;i<=cliente.size();i++) {
			Cliente clientito = cliente.get(i);
			if (clientito.getId()==idcliente) {
				cliente.remove(cliente.get(i));
			} else {
				System.out.println("Cliente no encontrado X");
			}
		}
			
	}
}