package gestor;

public class Viaje {

	private String lugar;
	private String fecha;
	private int precio;



	public Viaje(String lugar, String fecha, int precio) {
		super();
		this.lugar = lugar;
		this.fecha = fecha;
		this.precio = precio;
	}

	
	public String getFecha() {
		return fecha;
	}


	public void setFecha(String fecha) {
		this.fecha = fecha;
	}


	public int getPrecio() {
		return precio;
	}


	public void setPrecio(int precio) {
		this.precio = precio;
	}


	public String getLugar() {
		return lugar;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}

	
	}

	
	
}
