package co.edu.unbosque.model.persistence;

import java.time.LocalDate;
import java.util.ArrayList;

import co.edu.unbosque.model.Gato;

public class GatoDAO implements DAO<Gato>{
	private ArrayList<Gato> listaGatos;
	private final String FILE_NAME = "Gato.csv";
	private final String SERIAL_FILE_NAME = "Gatos.bin";
	
	public GatoDAO() {
		listaGatos = new ArrayList<>();
		//leerDesdeArchivoDeTexto(FILE_NAME);
		cargarDesdeArchivoSerializado();
	}
	
	@Override
	public void create(Gato newData) {
		listaGatos.add(newData);
		//escribirEnArchivoDeTexto();
		escribirEnArchivoSerializado();
	}

	@Override
	public boolean delete(int index) {
		index = index - 1;
		if (index <0 || index >= listaGatos.size()) {
			return false;
		}
		else {
			listaGatos.remove(index);
			//escribirEnArchivoDeTexto();
			escribirEnArchivoSerializado();
			return true;
		}
	}

	@Override
	public boolean update(int index, Gato newData) {
		index = index - 1;
		if (index <0 || index >= listaGatos.size()) {
			return false;
		}
		else {
			listaGatos.set(index, newData);
			//escribirEnArchivoDeTexto();
			escribirEnArchivoSerializado();
			return true;
		}
	}
	
	
	@Override
	public String showAll() {
		String content = "";
		int i = 1;
		for (Gato gato : listaGatos) {
			content+= "\n Gato " + i + ". " + gato.toString();
			i++;
		}
		return content + "\n";
	}

	@Override
	public int count() {
		return listaGatos.size();
	}
	public boolean isEmpty() {
		return listaGatos.isEmpty();
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
			Gato temp = new Gato();
			temp.setNombre(columnas[0]);
			temp.setEspecie(columnas[1]);
			temp.setPeso(Float.parseFloat(columnas[2]));
			temp.setEdad(Integer.parseInt(columnas[3]));
			temp.setSexo(columnas[4].charAt(0));
			temp.setHabitat(columnas[5]);
			temp.setFormaDesplazamiento(columnas[6]);
			temp.setColorPelaje(columnas[7]);
			temp.setTamanoOreja(columnas[8]);
			
			listaGatos.add(temp);
		}
		}
	}
	@Override
	public void escribirEnArchivoDeTexto() {
		StringBuilder  sb = new StringBuilder();
		for (Gato gato : listaGatos) {
			sb.append(gato.getNombre() + ";");
			sb.append(gato.getEspecie() + ";");
			sb.append(gato.getPeso() + ";");
			sb.append(gato.getEdad() + ";");
			sb.append(gato.getSexo() + ";");
			sb.append(gato.getHabitat() + ";");
			sb.append(gato.getFormaDesplazamiento() + ";");
			sb.append(gato.getColorPelaje() + ";");
			sb.append(gato.getTamanoOreja() + "\n");
		}
		FileHandler.escribirEnArchivoTexto(FILE_NAME, sb.toString());
	}

	@Override
	public void cargarDesdeArchivoSerializado() {
		Object contenido = FileHandler.leerDesdeArchivoSerializado(SERIAL_FILE_NAME);
		if (contenido != null) {
			listaGatos = (ArrayList<Gato>) contenido;
		}
		else {
			listaGatos = new ArrayList<>();
		}
	}

	@Override
	public void escribirEnArchivoSerializado() {
		FileHandler.escribirEnArchivoSerializado(SERIAL_FILE_NAME, listaGatos);
		
	}

	@Override
	public String generarReporteDiaActual() {
		LocalDate fechaActual = LocalDate.now();
		StringBuilder sb = new StringBuilder();
		for (Gato gato : listaGatos) {
			if (fechaActual.equals(gato.getFechaIngreso())) {
				sb.append(gato.toString()).append("\n");
			}
		}
		return sb.toString();
	}
	
}
