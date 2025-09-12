package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.Reptil;

public class ReptilDAO implements DAO<Reptil>{
	private ArrayList<Reptil> listaReptiles;
	private final String FILE_NAME = "Reptil.csv";
	private final String SERIAL_FILE_NAME = "Reptiles.bin";
	
	public ReptilDAO() {
		listaReptiles = new ArrayList<>();
		//leerDesdeArchivoDeTexto(FILE_NAME);
		cargarDesdeArchivoSerializado();
	}
	
	
	@Override
	public void create(Reptil newData) {
		listaReptiles.add(newData);
		//escribirEnArchivoDeTexto();
		escribirEnArchivoSerializado();
	}

	@Override
	public boolean delete(int index) {
		if (index <0 || index >= listaReptiles.size()) {
			return false;
		}
		else {
			listaReptiles.remove(index);
//			escribirEnArchivoDeTexto();
			escribirEnArchivoSerializado();
			return true;
		}
	}

	@Override
	public boolean update(int index, Reptil newData) {
		if (index <0 || index >= listaReptiles.size()) {
			return false;
		}
		else {
			listaReptiles.set(index, newData);
//			escribirEnArchivoDeTexto();
			escribirEnArchivoSerializado();
			return true;
		}
	}
	@Override
	public String showAll() {
		String content = "";
		for (Reptil reptil : listaReptiles) {
			content += reptil.toString() + "\n";
		}
		return content;
	}

	@Override
	public int count() {
		return listaReptiles.size();
	}


	@Override
	public void leerDesdeArchivoDeTexto(String url) {
		String contenido;
		contenido = FileHandler.leerDesdeArchivoDeTexto(url);
		if (contenido == "" || contenido.isBlank()) {
			return;
		}
		else {
			String[] filas = contenido.split("\n");
			for (int i = 0; i < filas.length; i++) {
				String[] columnas = filas[i].split(";");
				Reptil temp = new Reptil();
				temp.setNombre(columnas[0]);
				temp.setEspecie(columnas[1]);
				temp.setPeso(Float.parseFloat(columnas[2]));
				temp.setEdad(Integer.parseInt(columnas[3]));
				temp.setSexo(columnas[4].charAt(0));
				temp.setHabitat(columnas[5]);
				temp.setFormaDesplazamiento(columnas[6]);
				temp.setTieneEscama(Boolean.valueOf(columnas[7]));
				temp.setEsVenenoso(Boolean.valueOf(columnas[8]));

				
				listaReptiles.add(temp);
			}
		}

	}
	@Override
	public void escribirEnArchivoDeTexto() {
		StringBuilder  sb = new StringBuilder();
		for (Reptil reptil : listaReptiles) {
			sb.append(reptil.getNombre() + ";");
			sb.append(reptil.getEspecie() + ";");
			sb.append(reptil.getPeso() + ";");
			sb.append(reptil.getEdad() + ";");
			sb.append(reptil.getSexo() + ";");
			sb.append(reptil.getHabitat() + ";");
			sb.append(reptil.getFormaDesplazamiento() + ";");
			sb.append(reptil.isTieneEscama() + ";");
			sb.append(reptil.isEsVenenoso() + "\n");
		}
		FileHandler.escribirEnArchivoTexto(FILE_NAME, sb.toString());
	}


	@Override
	public void cargarDesdeArchivoSerializado() {
		Object contenido = FileHandler.leerDesdeArchivoSerializado(SERIAL_FILE_NAME);
		if (contenido != null) {
			listaReptiles = (ArrayList<Reptil>) contenido;
		}
		else {
			listaReptiles = new ArrayList<>();
		}
	}


	@Override
	public void escribirEnArchivoSerializado() {
		FileHandler.escribirEnArchivoSerializado(SERIAL_FILE_NAME, listaReptiles);
		
	}
	
}
