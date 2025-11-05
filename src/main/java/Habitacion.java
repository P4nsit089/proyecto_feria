public class Habitacion {
	private int id;
	private int capacidad;
	private int costo;
	private String descripcion;
	private String clase;
	
	private boolean disponible=true;


	public Habitacion (int id,int capacidad,int costo,String descripcion,String clase){
		this.id=id;
		this.capacidad=capacidad;
		this.costo=costo;
		this.descripcion=descripcion;
		this.clase=clase;
		
	}
	public int get_ID(){
		return id;
	}
	public void set_ID (int id2){
		id=id2;
	}
	public int  get_capacidad(){
		return capacidad;
	}
	public void set_capacidad (int capacidad2){
		capacidad=capacidad2;
	}
	public int get_costo(){
		return costo;
	}
	public void set_costo (int costo2){
		costo=costo2;
	}
	public String get_descripcion(){
		return descripcion;
	}
	public void set_descripcion (String descripcion2){
		descripcion=descripcion2;
	}
	public String get_clase(){
		return clase;
	}
	public void set_clase (String clase2){
		clase=clase2;
	}
	public int costoxnoche (int id){
		return costo;
	}
	public boolean disponible_get (){
		return disponible;
		}
	public void set_disponible (boolean di){
		disponible=di;
	}
	
	
}

