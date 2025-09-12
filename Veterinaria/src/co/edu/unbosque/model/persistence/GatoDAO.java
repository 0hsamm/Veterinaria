package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.Gato;

public class GatoDAO implements DAO<Gato>{
	private ArrayList<Gato> listaGatos;
	private final String FILE_NAME = "Gato.csv";
	
	public GatoDAO() {
		listaGatos = new ArrayList<>();
		leerDesdeArchivoDeTexto(FILE_NAME);
		
	}
	
	@Override
	public void create(Gato newData) {
		listaGatos.add(newData);
		escribirEnArchivoDeTexto();
		
	}

	@Override
	public boolean delete(int index) {
		if (index <0 || index >= listaGatos.size()) {
			return false;
		}
		else {
			listaGatos.remove(index);
			escribirEnArchivoDeTexto();
			return true;
		}
	}

	@Override
	public boolean update(int index, Gato newData) {
		if (index <0 || index >= listaGatos.size()) {
			return false;
		}
		else {
			listaGatos.set(index, newData);
			escribirEnArchivoDeTexto();
			return true;
		}
	}
	
	
	@Override
	public String showAll() {
		String content = "";
		for (Gato gato : listaGatos) {
			content += gato.toString() + "\n";
		}
		return content;
	}

	@Override
	public int count() {
		return listaGatos.size();
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
	
}
