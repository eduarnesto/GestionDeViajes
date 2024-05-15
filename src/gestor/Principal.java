package gestor;

import java.util.Scanner;

import excepciones.ExcepcionFecha;
import excepciones.ExcepcionLugar;
import excepciones.ExcepcionPrecio;

public class Principal {

	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		int opcion;
		System.out.println("Hola");
		do {
			System.out.println("Hola");
			ControlArchivo.leerArchivo();
			System.out.println("Hola");
			menu();

			opcion = scanner.nextInt();

			scanner.nextLine();

			switch (opcion) {

			case 1:
				Gestion.listar();
				break;

			case 2:
				anyadirViaje();
				break;
				/*
			case 3:

				System.out.print("Lugar del viaje a modificar: ");

				String lugarModificar = scanner.nextLine();

				System.out.print("Nuevo precio del viaje: ");

				double nuevoPrecio = scanner.nextDouble();


				break;

			case 4:

				System.out.print("Lugar del viaje a eliminar: ");

				lugar = scanner.nextLine();

				Gestion.borrarViaje(lugar);

				break;

			case 5:

				ControlArchivo.imprimirArchivo();

				break;
*/
			case 6:
				System.out.println("Has salido del programa");
				break;

			default:

				System.out.println("Opción no valida.");

			}

		} while (opcion != 9);

		scanner.close();
	}

	public static void anyadirViaje() {
		String lugar;
		String fecha;
		int precio;
		Viaje viaje = null;
		System.out.print("Lugar del viaje: ");

		lugar = scanner.nextLine();

		System.out.print("Fecha del viaje (DD/MM/AAAA): ");

		fecha = scanner.nextLine();

		System.out.print("Precio del viaje: ");

		precio = scanner.nextInt();

		try {
			viaje = new Viaje (lugar, fecha, precio);
		} catch (ExcepcionLugar | ExcepcionFecha | ExcepcionPrecio e) {
			System.out.println("Datos introducidos no válidos");
		}
		
		if (Gestion.anyadirViaje(viaje)) {
			System.out.println("Viaje anyadido correctamente");
		} else {
			System.out.println("No se ha podido añadir el viaje");
		}
		
	}

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
