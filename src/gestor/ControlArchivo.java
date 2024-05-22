package gestor;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import excepciones.ExcepcionFecha;
import excepciones.ExcepcionLugar;
import excepciones.ExcepcionPrecio;

public class ControlArchivo {

	/**
	 * Para leer el archivo
	 */
	static public void leerArchivo() {

		String fecha;

		String lugar;

		float precio;

		BufferedReader br = null;
			try {

				br = new BufferedReader(new FileReader("src/gestor/datosTurismo.txt"));

				String linea;

				linea = br.readLine();

				while (linea != null) {

					String[] viajes = linea.split("::");

					lugar = viajes[0];

					fecha = viajes[1];

					precio = Integer.parseInt(viajes[2]);
					
					try {
						Gestion.anyadirViaje(lugar, fecha, precio);
					} catch (ExcepcionLugar | ExcepcionFecha | ExcepcionPrecio e) {
						
					} finally {
						linea = br.readLine();
					}

				}

			} catch (FileNotFoundException e) {

				e.printStackTrace();

			} catch (IOException e) {

				e.printStackTrace();

			} finally {

				try {

					br.close();

				} catch (IOException e) {

					e.printStackTrace();

				}

			}
	} //Fin leerArchivo
	
	/**
	 * Para escribir 
	 */
	static public void imprimirArchivo() {

		//BufferedWriter para escribir
		BufferedWriter bw = null;
		{
			try {

				//Lo inicializamos
				bw = new BufferedWriter(new FileWriter("src/gestor/datosTurismo.txt"));


				//Recorre el array y va pintando los atributos de cada objeto 
				for(Viaje viaje:Gestion.conjunto) {
					bw.write(viaje.getLugar());
					bw.write("::");
					bw.write(viaje.getFecha());
					bw.write("::");
					bw.write((int) viaje.getPrecio());
					//Siguiente linea
					bw.newLine();
				}

			} catch (FileNotFoundException e) {

				e.printStackTrace();

			} catch (IOException e) {

				e.printStackTrace();

			} finally {

				try {

					bw.flush();
					bw.close();

				} catch (IOException e) {

					e.printStackTrace();

				}

			}
		}
	}
}