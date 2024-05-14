package gestor;

import java.util.HashSet;
import java.util.Objects;

public class Gestion {

	HashSet<Viaje> conjunto = new HashSet<>();

	public boolean anyadirViaje(Viaje viajecito) {
		boolean anyadido = true;
		int i = 0;

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

	public boolean borrarViaje(Viaje viajecito) {
		boolean borrado = false;
		int i = 0;

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

	public boolean modPrecio(Viaje viajecito) {
		boolean modificado = true;

		setPrecio(viajecito);

		return modificado;

	}

	public boolean modFecha(Viaje viajecito) {
		boolean modificado = true;

		setFecha(viajecito);

		return modificado;

	}

	public boolean modLugar(Viaje viajecito) {
		boolean modificado = true;
		setLugar(viajecito);
		return modificado;
	}

	public void listar() {
		System.out.print(conjunto);
	}
}
