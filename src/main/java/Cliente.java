public class Cliente {
    private int Id;
	private String Dni;
	private String Nombre;
	private String Apellido;
	private String Email;
	private String Telefono;
	
	public Cliente(int Id, String Dni, String Nombre, String Apellido, String Email, String Telefono) {
		
		this.Id=Id;
		this.Dni=Dni;
		this.Nombre=Nombre;
		this.Apellido=Apellido;
		this.Email=Email;
		this.Telefono=Telefono;
		
	}
	
	
		
	public int getId(){
		return Id;
	}
	public void setId(int nuevoValor) {
		Id = nuevoValor;
	}
	
	public String getDni(){
		return Dni;
	}
	public void setDni(String nuevoValor) {
		Dni = nuevoValor;
	}
	
	public String getNombre(){
		return Nombre;
	}
	public void setNombre(String nuevoValor) {
		Nombre = nuevoValor;
	}
	
	public String getApellido(){
		return Apellido;
	}
	public void setApellido(String nuevoValor) {
		Apellido = nuevoValor;
	}
	
	public String getEmail(){
		return Email;
	}
	public void setEmail(String nuevoValor) {
		Email = nuevoValor;
	}
	
	public String getTelefono(){
		return Telefono;
	}
	
	public  void setTelefono(String nuevoValor) {
		Telefono = nuevoValor;
	}

	public void InfoCliente() {
		System.out.println("DNI: "+Dni+" Nombre: "+Nombre+" Apellido: "+Apellido+" Email: "+Email+" Telefono: "+Telefono);
	}
}
