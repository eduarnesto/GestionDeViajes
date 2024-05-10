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

	public boolean modPrecio(Viaje viajecito) {
		boolean modificado=true;
		
		setViaje(viajecito);
		
		return modificado;
		
	}
	

}
