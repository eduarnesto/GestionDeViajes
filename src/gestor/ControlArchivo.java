package gestor;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ControlArchivo {
	
	
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