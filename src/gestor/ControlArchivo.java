package gestor;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ControlArchivo {

	/**
	 * Para leer el archivo
	 */
	public void leerArchivo() {

		String fecha;

		String lugar;

		int precio;

		BufferedReader br = null;
		{
			try {

				br = new BufferedReader(new FileReader("src/gestor/datosTurismo.txt"));

				String linea;

				linea = br.readLine();

				while (linea != null) {

					String[] viaje = linea.split("::");

					lugar = viaje[0];

					fecha = viaje[1];

					precio = Integer.parseInt(viaje[2]);

					new Viaje(lugar, fecha, precio);

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
		}
	}
	
	/**
	 * Para escribir 
	 */
	public void imprimirArchivo() {

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
					bw.write(viaje.getPrecio());
					//Siguiente linea
					bw.newLine();
				}

			} catch (FileNotFoundException e) {

				e.printStackTrace();

			} catch (IOException e) {

				e.printStackTrace();

			} finally {

				try {

					bw.close();
					bw.flush();

				} catch (IOException e) {

					e.printStackTrace();

				}

			}
		}
	}
}