package gestor;

import java.util.Scanner;

import excepciones.ExcepcionFecha;
import excepciones.ExcepcionLugar;
import excepciones.ExcepcionPrecio;

public class Principal {
//Creamos el scanner para poder leer por consola
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws ExcepcionLugar, ExcepcionFecha {
		// Creamos la variable donde guardaremos la opcion elegida por el usuario
		int opcion;
		
		System.out.println("Bienvenido al gestor de viajes Volando Voy");
		
		// Creamos la entrada al programa
		do {
			ControlArchivo.leerArchivo();
			// Llamamos al menu
			menu();
			// Guardamos la opcion dada por el usuario
			opcion = scanner.nextInt();
			// Limpiamos el scanner
			scanner.nextLine();
			// Creamos una funcion para realizar las diferentes operaciones dependiendo de
			// lo que elija el usuario
			switch (opcion) {
			// en el primer caso llamamos a la funcion donde tenemos los viajes
			case 1:
				Gestion.listar();
				break;
			// aqui llamamos a la funcion que añade viajes y le pedirá mas datos al usuario
			case 2:
				anyadirViaje();
				break;

			// el siguiente modifica viajes
			case 3:
				modificaViaje();

				break;
			// el siguiente llama a la funcion que los elimina
			case 4:
				borrarViaje();

				break;
			// este llama a la funcion que almacena y actualiza todos los cambios
			case 5:

				ControlArchivo.imprimirArchivo();

				break;
			// con este ultimo sales del programa
			case 6:
				System.out.println("Has salido del programa");
				break;
			// el default avisa de que es una opcion no valida ya sea por introducir algo
			// que no sea un numero o un numero que no aparezca en la casuistica
			default:

				System.out.println("Opción no valida.");

			}

		} while (opcion != 6);
		
		// cerramosel scanner para terminar el main
		scanner.close();
	}

	private static void borrarViaje() {
		String lugar;
		String fecha;

		lugar = preguntarLugar();
		fecha = preguntarFecha();

		try {
			Gestion.borrarViaje(lugar, fecha);
		} catch (ExcepcionLugar | ExcepcionFecha e) {
			System.out.println("Datos añadidos no válidos");
		}
	}

	private static void modificaViaje() {
		String lugar;
		String fecha;
		int opc;

		lugar = preguntarLugar();

		fecha = preguntarFecha();

		menuModificar();
		opc = scanner.nextInt();
		scanner.nextLine();

		switch (opc) {
		case 1: {
			modificarFecha(lugar, fecha);
			break;
		}
		case 2: {
			modificarPrecio(lugar, fecha);
			break;
		}
		default:
			System.out.println("Opción no válida");
		}
	}

	public static void modificarFecha(String lugar, String fecha) {
		boolean modificado;
		String fechaNueva;

		fechaNueva = preguntarFecha();

		try {
			modificado = Gestion.modFecha(lugar, fecha, fechaNueva);
		} catch (ExcepcionLugar | ExcepcionFecha e) {
			modificado = false;
		}

		if (modificado) {
			System.out.println("Se ha modificado la fecha");
		} else {
			System.out.println("No se ha podido modificar la fecha");
		}
	}

	public static void modificarPrecio(String lugar, String fecha) {
		boolean modificado;
		float precioNuevo;

		precioNuevo = preguntarPrecio();

		try {
			modificado = Gestion.modPrecio(lugar, fecha, precioNuevo);
		} catch (ExcepcionLugar | ExcepcionFecha e) {
			modificado = false;
		}

		if (modificado) {
			System.out.println("Se ha modificado el precio");
		} else {
			System.out.println("No se ha podido modificar el precio");
		}
	}

	public static void menuModificar() {
		System.out.println("¿Qué parametro quieres modificar?");
		System.out.println("1.- Fecha");
		System.out.println("2.- precio");
		System.out.println("Elija una opción");
	}

	// esta funcion es la que nos ayuda a añadir nuevos viajes
	public static void anyadirViaje() {
		// variable que guarda el lugar del nuevo viaje
		String lugar;
		// variable que guarda la fecha del nuevo viaje
		String fecha;
		// variable que guarda el precio del nuevo viaje
		float precio;

		// Ahora le pedimos por consola los datos al usuario
		lugar = preguntarLugar();

		fecha = preguntarFecha();

		precio = preguntarPrecio();

		// Comprobamos si el viaje ya existe y si se ha podido añadir
		try {
			if (Gestion.anyadirViaje(lugar, fecha, precio)) {
				System.out.println("Viaje añadido correctamente");
			} else {
				System.out.println("No se ha podido añadir el viaje");
			}
		} catch (ExcepcionLugar | ExcepcionFecha | ExcepcionPrecio e) {
			System.out.println("Datos introducidos no validos");
		}

	}

	public static float preguntarPrecio() {
		float precio;
		
		System.out.print("Precio del viaje: ");
		precio = scanner.nextInt();
		
		while (precio <= 0) {
			System.out.print("Precio no válido, introduzca otro: ");
			precio = scanner.nextInt();
		}
		return precio;
	}

	public static String preguntarFecha() {
		String fecha;
		boolean correcto = false;

		do {
			System.out.print("Fecha del viaje (DD/MM/AAAA): ");
			fecha = scanner.nextLine();

			if (fecha != null && !fecha.equals("") && fecha.length() == 10) {
				String dia = fecha.substring(0, 2);
				if (Integer.valueOf(dia) > 0 && Integer.valueOf(dia) < 32) {
					String mes = fecha.substring(3, 5);
					if (Integer.valueOf(mes) > 0 && Integer.valueOf(mes) < 13) {
						correcto = true;
					}
				}
			}
			
			if (!correcto) {
				System.out.println("Fecha introducida no válida");
			}
			
		} while (!correcto);

		return fecha;
	}

	public static String preguntarLugar() {
		String lugar;
		
		System.out.print("Lugar del viaje: ");
		lugar = scanner.nextLine();
		
		while (lugar != null && lugar.equals("")) {
			System.out.print("Destino no válido, introduzca otro: ");
			lugar = scanner.nextLine();
		}
		return lugar;
	}

	// funcion para imprimir el menu por consola
	public static void menu() {
		System.out.println("Seleccione una opción: ");
		System.out.println("1. Ver viajes disponibles");
		System.out.println("2. Añadir un nuevo viaje");
		System.out.println("3. Modificar un viaje existente");
		System.out.println("4. Eliminar un viaje existente");
		System.out.println("5. Guardar cambios");
		System.out.println("6. Salir");
	}

}
