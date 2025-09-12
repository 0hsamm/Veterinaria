package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.Pez;

public class PezDAO implements DAO<Pez>{
	private ArrayList<Pez> listaPeces;
	private final String FILE_NAME = "Pez.csv";
	
	public PezDAO() {
		listaPeces = new ArrayList<>();
		leerDesdeArchivoDeTexto(FILE_NAME);
	}
	
	@Override
	public void create(Pez newData) {
		listaPeces.add(newData);
		
	}

	@Override
	public boolean delete(int index) {
		if (index <0 || index >= listaPeces.size()) {
			return false;
		}
		else {
			listaPeces.remove(index);
			return true;
		}
	}

	@Override
	public boolean update(int index, Pez newData) {
		if (index <0 || index >= listaPeces.size()) {
			return false;
		}
		else {
			listaPeces.set(index, newData);
			return true;
		}
	}
	
	
	@Override
	public String showAll() {
		String content = "";
		for (Pez pez : listaPeces) {
			content += pez.toString() + "\n";
		}
		return content;
	}

	@Override
	public int count() {
		return listaPeces.size();
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
			Pez temp = new Pez();
			temp.setNombre(columnas[0]);
			temp.setEspecie(columnas[1]);
			temp.setPeso(Float.parseFloat(columnas[2]));
			temp.setEdad(Integer.parseInt(columnas[3]));
			temp.setSexo(columnas[4].charAt(0));
			temp.setHabitat(columnas[5]);
			temp.setFormaDesplazamiento(columnas[6]);
			temp.setTieneEscama(Boolean.valueOf(columnas[7]));
			temp.setTamanoAleta(columnas[8]);

			
			listaPeces.add(temp);
		}
		}
	}
	@Override
	public void escribirEnArchivoDeTexto() {
		StringBuilder  sb = new StringBuilder();
		for (Pez pez : listaPeces) {
			sb.append(pez.getNombre() + ";");
			sb.append(pez.getEspecie() + ";");
			sb.append(pez.getPeso() + ";");
			sb.append(pez.getEdad() + ";");
			sb.append(pez.getSexo() + ";");
			sb.append(pez.getHabitat() + ";");
			sb.append(pez.getFormaDesplazamiento() + ";");
			sb.append(pez.isTieneEscama() + ";");
			sb.append(pez.getTamanoAleta() + "\n");
		}
		FileHandler.escribirEnArchivoTexto(FILE_NAME, sb.toString());
	}
	
}
