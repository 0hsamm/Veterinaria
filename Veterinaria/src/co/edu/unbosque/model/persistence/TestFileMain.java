package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.*;


public class TestFileMain {

	public static void main(String[] args) {
		Object contenido = FileHandler.leerDesdeArchivoSerializado("Perros.bin");
		String content = "";
		if (contenido != null) {
			ArrayList<Perro> listaPerros = (ArrayList<Perro>) contenido;
			for (Perro perro : listaPerros) {
				content += perro.toString() + "\n";
			}
		}
		else {
			ArrayList<Perro> listaPerros = new ArrayList<>();
			
		}
		System.out.println(content);
	}
	
	
}
