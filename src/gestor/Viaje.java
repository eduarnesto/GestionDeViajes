package gestor;

import excepciones.ExcepcionFecha;
import excepciones.ExcepcionLugar;
import excepciones.ExcepcionPrecio;

public class Viaje {
	/**
	 * Destino del viaje
	 */
	private String lugar = "";

	/**
	 * Fecha del viaje
	 */
	private String fecha = "";

	/**
	 * Precio del viaje
	 */
	private float precio;

	/**
	 * Constructor con parametros de la clase viajes
	 * 
	 * @param lugar  Destino del viaje
	 * @param fecha  Fecha del viaje
	 * @param precio Precio del viaje
	 * @throws ExcepcionLugar  Excepcion si el lugar no es correcto
	 * @throws ExcepcionFecha  Excepcion si la fecha no es correcta
	 * @throws ExcepcionPrecio Excepcion si el precio no es correcto
	 */
	public Viaje(String lugar, String fecha, float precio) throws ExcepcionLugar, ExcepcionFecha, ExcepcionPrecio {
		// Comprobamos que el precio es valido
		if (precio > 0) {
			this.precio = precio;
		} else {
			throw new ExcepcionPrecio();
		}

		// Comprobamos que el lugar es valido
		if (lugar != null && !lugar.equals("")) {
			this.lugar = lugar;
		} else {
			throw new ExcepcionLugar();
		}

		// Comprobamos que la fecha es valida
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
	}

	/**
	 * Constructor con parametros de la clase viajes sin precio
	 * 
	 * @param lugar Destino del viaje
	 * @param fecha Fecha del viaje
	 * @throws ExcepcionLugar Excepcion si el lugar no es correcto
	 * @throws ExcepcionFecha Excepcion si la fecha no es correcta
	 */
	public Viaje(String lugar, String fecha) throws ExcepcionLugar, ExcepcionFecha {
		// Comprobamos que el lugar es valido
		if (lugar != null && lugar.equals("")) {
			this.lugar = lugar;
		} else {
			throw new ExcepcionLugar();
		}

		// Comprobamos que la fecha es valida
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
	}

	/**
	 * Metodo para obtener el destino de un viaje
	 * 
	 * @return Destino del viaje
	 */
	public String getLugar() {
		return lugar;
	}

	/**
	 * Metodo para obtener la fecha de un viaje
	 * 
	 * @return Fecha de un viaje
	 */
	public String getFecha() {
		return fecha;
	}

	/**
	 * Metodo para cambiar la fecha de un viaje
	 * 
	 * @param fecha Fecha del viaje
	 */
	public void setFecha(String fecha) {
		if (fecha != null && !fecha.equals("")) {
			this.fecha = fecha;
		}
	}

	/**
	 * Metodo para obtener el precio de un viaje
	 * 
	 * @return Precio de un viaje
	 */
	public float getPrecio() {
		return precio;
	}

	/**
	 * Metodo para cambiar el precio de un viaje
	 * 
	 * @param fecha Precio del viaje
	 */
	public void setPrecio(float precio) {
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
