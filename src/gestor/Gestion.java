package gestor;

import java.util.HashSet;

import excepciones.ExcepcionFecha;
import excepciones.ExcepcionLugar;
import excepciones.ExcepcionPrecio;

/**
 * Clase para gestionar el conjunto de viajes
 */
public class Gestion {
/**
 * Array que guarda en el los viajes
 */
	public static HashSet<Viaje> conjunto = new HashSet<>();

	/**
	 * Metodo para añadir viajes al array
	 * @param lugar Junto con la fecha para referirnos a un viaje
	 * @param fecha Junto con el lugar para referirnos a un viaje
	 * @return Devolvemos un booleano en caso de q ue se añada corectamente
	 * @throws ExcepcionFecha 
	 * @throws ExcepcionLugar 
	 * @throws ExcepcionPrecio
	 */
	public static boolean anyadirViaje(String lugar, String fecha, float precio) throws ExcepcionLugar, ExcepcionFecha, ExcepcionPrecio {
		boolean anyadido = true;
		
		Viaje viajecito=new Viaje(lugar,fecha, precio);
		
		for (Viaje viaje : conjunto) {
			if (viaje.equals(viajecito)) {
				anyadido = false;
			}
		}

		if (anyadido) {
			conjunto.add(viajecito);
		}
		
		return anyadido;
	}

	/**
	 * Metodo para borrar el viaje del array
	 * @param lugar Junto con la fecha para referirnos a un viaje
	 * @param fecha Junto con el lugar para referirnos a un viaje
	 * @return Devolvemos un booleano en caso de que se borre corectamente
	 * @throws ExcepcionFecha 
	 * @throws ExcepcionLugar 
	 */
	public static boolean borrarViaje(String lugar, String fecha) throws ExcepcionLugar, ExcepcionFecha {
		boolean borrado = false;
		
		Viaje viajecito=new Viaje(lugar,fecha);
		
		for (Viaje viaje : conjunto) {
			if (viaje.equals(viajecito)) {
				borrado = true;
			}
		}

		if (borrado) {
			conjunto.remove(viajecito);
		}
		
		return borrado;
	}

	/**
	 * Para modificar el precio
	 * @param lugar Junto con la fecha para referirnos a un viaje
	 * @param fecha Junto con el lugar para referirnos a un viaje
	 * @param newPrecio en nuevo valor
	 * @return Boolean en caso de que la accion se ha realizado sin problemas
	 * @throws ExcepcionFecha 
	 * @throws ExcepcionLugar 
	 */
	public static boolean modPrecio(String lugar, String fecha, float newPrecio) throws ExcepcionLugar, ExcepcionFecha {
		boolean modificado = false;
		
		Viaje viajecito = new Viaje(lugar, fecha);
		
		for (Viaje viaje : conjunto) {
			if (viaje.equals(viajecito)) {
				viaje.setPrecio(newPrecio);
				modificado=true;
			}
		}
		
		return modificado;

	}
	/**
	 * Para modificar la Fecha
	 * @param lugar Junto con la fecha antigua para referirnos a un viaje
	 * @param oldFecha Junto con el lugar para referirnos a un viaje
	 * @param newFecha el nuevo valor
	 * @return Boolean en caso de que la accion se ha realizado sin problemas
	 * @throws ExcepcionFecha 
	 * @throws ExcepcionLugar 
	 */
	public static boolean modFecha(String lugar, String oldFecha , String newFecha) throws ExcepcionLugar, ExcepcionFecha {
		boolean modificado = false;
		
		Viaje viajecito = new Viaje(lugar, oldFecha);
		
		for (Viaje viaje : conjunto) {
			if (viaje.equals(viajecito)) {
				viajecito.setFecha(newFecha);
				modificado=true;
			}
		}
		
		return modificado;

	}

	/**
	 * Para comprobar si está todo bien
	 */
	public static void listar() {
		for (Viaje viaje : conjunto) {
			System.out.println(viaje);
		}
	}
}
