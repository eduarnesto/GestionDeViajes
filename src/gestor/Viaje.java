package gestor;

public class Viaje {
	private String lugar = "";
	private String fecha = "";
	private int precio = 0;

	public Viaje(String lugar, String fecha, int precio) {
		if (lugar != null && !lugar.equals(fecha)) {
			this.lugar = lugar;
		}
		if (fecha != null && !fecha.equals("")) {
			this.fecha = fecha;
		}
		if (precio > 0) {
			this.precio = precio;
		}
	}

	public String getLugar() {
		return lugar;
	}

	public void setFecha(String fecha) {
		if (fecha != null && !fecha.equals("")) {
			this.fecha = fecha;
		}
	}

	public void setPrecio(int precio) {
		if (precio > 0) {
			this.precio = precio;
		}
	}

	@Override
	public boolean equals(Object obj) {
		boolean igual = false;
		Viaje viaje = (Viaje) obj;
		if (viaje.lugar.equals(this.lugar) && viaje.fecha.equals(this.fecha)) {
			igual = true;
		}
		return igual;
	}

}
