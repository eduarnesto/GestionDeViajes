package gestor;

import excepciones.ExcepcionFecha;
import excepciones.ExcepcionLugar;
import excepciones.ExcepcionPrecio;

public class Viaje {
	private String lugar = "";
	private String fecha = "";
	private int precio = 0;

	public Viaje(String lugar, String fecha, int precio) throws ExcepcionLugar, ExcepcionFecha, ExcepcionPrecio {
		if (lugar != null && !lugar.equals(fecha)) {
			this.lugar = lugar;
		} else {
			throw new ExcepcionLugar();
		}

		if (fecha != null && !fecha.equals("") && fecha.length() == 10) {
			String dia = fecha.substring(0, 2);
			if (Integer.valueOf(dia) > 0 && Integer.valueOf(dia) < 32) {
				String mes = fecha.substring(3, 5);
				if (Integer.valueOf(mes) > 0 && Integer.valueOf(mes) < 13) {
					this.fecha = fecha;
				} else {
					throw new ExcepcionFecha();
				}
			} else {
				throw new ExcepcionFecha();
			}
		} else {
			throw new ExcepcionFecha();
		}

		if (precio > 0) {
			this.precio = precio;
		} else {
			throw new ExcepcionPrecio();
		}
	}

	public String getLugar() {
		return lugar;
	}

	public String getFecha() {
		return fecha;
	}
	
	public void setFecha(String fecha) {
		if (fecha != null && !fecha.equals("")) {
			this.fecha = fecha;
		}
	}

	public int getPrecio() {
		return precio;
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

	@Override
	public String toString() {
		String res = "";

		res += "Lugar: " + this.lugar + "\n";
		res += "Fecha: " + this.fecha + "\n";
		res += "Precio: " + this.precio + "\n";

		return res;
	}

}
