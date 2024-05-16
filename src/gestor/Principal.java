package gestor;

import java.util.Scanner;

import excepciones.ExcepcionFecha;
import excepciones.ExcepcionLugar;
import excepciones.ExcepcionPrecio;

public class Principal {
//Creamos el scanner para poder leer por consola
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		// Creamos la variable donde guardaremos la opcion elegida por el usuario
		int opcion;
		// Creamos la entrada al programa
		System.out.println("Hola");
		do {
			System.out.println("Hola");
			ControlArchivo.leerArchivo();
			System.out.println("Hola");
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

				System.out.print("Lugar del viaje a modificar: ");

				String lugarModificar = scanner.nextLine();

				System.out.print("Nuevo precio del viaje: ");

				double nuevoPrecio = scanner.nextDouble();

				break;
			// el siguiente llama a la funcion que los elimina
			case 4:

				System.out.print("Lugar del viaje a eliminar: ");

				lugar = scanner.nextLine();

				Gestion.borrarViaje(lugar);

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

		} while (opcion != 9);
		// cerramosel scanner para terminar el main
		scanner.close();
	}

	// esta funcion es la que nos ayuda a añadir nuevos viajes
	public static void anyadirViaje() {
		// variable que guarda el lugar del nuevo viaje
		String lugar;
		// variable que guarda la fecha del nuevo viaje
		String fecha;
		// variable que guarda el precio del nuevo viaje
		int precio;
		// variable para comprobar si ese viaje ya existe
		Viaje viaje = null;
		// ahora le pedimos por consola los datos al usuario
		System.out.print("Lugar del viaje: ");

		lugar = scanner.nextLine();

		System.out.print("Fecha del viaje (DD/MM/AAAA): ");

		fecha = scanner.nextLine();

		System.out.print("Precio del viaje: ");

		precio = scanner.nextInt();
		// comprobamos si el viaje ya existe y si se ha podido añadir
		try {
			viaje = new Viaje(lugar, fecha, precio);
		} catch (ExcepcionLugar | ExcepcionFecha | ExcepcionPrecio e) {
			System.out.println("Datos introducidos no válidos");
		}

		if (Gestion.anyadirViaje(viaje)) {
			System.out.println("Viaje añadido correctamente");
		} else {
			System.out.println("No se ha podido añadir el viaje");
		}

	}

	// funcion para imprimir el menu por consola
	public static void menu() {
		System.out.println("Bienvenido al gestor de viajes Volando Voy");
		System.out.println("1. Ver viajes disponibles");
		System.out.println("2. Añadir un nuevo viaje");
		System.out.println("3. Modificar un viaje existente");
		System.out.println("4. Eliminar un viaje existente");
		System.out.println("5. Guardar cambios");
		System.out.println("6. Salir");
		System.out.print("Seleccione una opción: ");
	}

}
