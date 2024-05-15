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
	public boolean anyadirViaje(Viaje viajecito) {
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
	public boolean borrarViaje(Viaje viajecito) {
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
	 * @param viajecito De que viaje lo queremos modificar
	 * @param newPrecio en nuevo valor
	 * @return Boolean en caso de que la accion se ha realizado sin problemas
	 */
	public boolean modPrecio(Viaje viajecito, int newPrecio) {
		boolean modificado = true;

		viajecito.setPrecio(newPrecio);

		return modificado;

	}
	/**
	 * Para modificar la Fecha
	 * @param viajecito De que viaje lo queremos modificar
	 * @param newFecha el nuevo valor
	 * @return Boolean en caso de que la accion se ha realizado sin problemas
	 */
	public boolean modFecha(Viaje viajecito, String newFecha) {
		boolean modificado = true;

		viajecito.setFecha(newFecha);

		return modificado;

	}

	/**
	 * Para modificar el Lugar
	 * @param viajecito De que viaje lo queremos modificar
	 * @param newLugar el nuevo valor
	 * @return Boolean en caso de que la accion se ha realizado sin problemas
	 */
	public boolean modLugar(Viaje viajecito, String newLugar) {
		boolean modificado = true;
		viajecito.setLugar(newLugar);
		return modificado;
	}

	/**
	 * Para comprobar si está todo bien
	 */
	public void listar() {
		System.out.print(conjunto);
	}
}
