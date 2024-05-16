package gestor;

import java.util.HashSet;

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
	 * @param viajecito metemos el viaje que añadiremos al array
	 * @return Devolvemos un booleano en caso de q ue se añada corectamente
	 */
	public static boolean anyadirViaje(Viaje viajecito) {
		boolean anyadido = true;
		
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
	 *@param viajecito metemos el viaje que borraremos al array
	 * @return Devolvemos un booleano en caso de que se borre corectamente
	 */
	public static boolean borrarViaje(Viaje viajecito) {
		boolean borrado = false;
		
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
	 */
	public static boolean modPrecio(String lugar, String fecha, int newPrecio) {
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
	 */
	public static boolean modFecha(String lugar, String oldFecha , String newFecha) {
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
