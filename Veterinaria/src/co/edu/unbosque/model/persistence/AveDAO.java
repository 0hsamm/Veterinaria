package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.Ave;

public class AveDAO implements DAO<Ave>{
	private ArrayList<Ave> listaAves;
	private final String FILE_NAME = "Ave.csv";
	private final String SERIAL_FILE_NAME = "Aves.bin";
	
	public AveDAO() {
		listaAves = new ArrayList<>();
		//leerDesdeArchivoDeTexto(FILE_NAME);
		cargarDesdeArchivoSerializado();
	}
	
	
	@Override
	public void create(Ave newData) {
		listaAves.add(newData);
		//escribirEnArchivoDeTexto();
		escribirEnArchivoSerializado();
		
	}

	@Override
	public boolean delete(int index) {
		if (index <0 || index >= listaAves.size()) {
			return false;
		}
		else {
			listaAves.remove(index);
			//escribirEnArchivoDeTexto();
			escribirEnArchivoSerializado();
			return true;
		}
	}

	@Override
	public boolean update(int index, Ave newData) {
		if (index <0 || index >= listaAves.size()) {
			return false;
		}
		else {
			listaAves.set(index , newData);
			//escribirEnArchivoDeTexto();
			escribirEnArchivoSerializado();
			return true;
		}
	}
	
	
	@Override
	public String showAll() {
		String content = "";
		for (Ave ave : listaAves) {
			content += ave.toString() + "\n";
		}
		return content;
	}

	@Override
	public int count() {
		return listaAves.size();
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
			Ave temp = new Ave();
			temp.setNombre(columnas[0]);
			temp.setEspecie(columnas[1]);
			temp.setPeso(Float.parseFloat(columnas[2]));
			temp.setEdad(Integer.parseInt(columnas[3]));
			temp.setSexo(columnas[4].charAt(0));
			temp.setHabitat(columnas[5]);
			temp.setFormaDesplazamiento(columnas[6]);
			temp.setTipoDePluma(columnas[7]);
			temp.setTipoDePico(columnas[8]);

			
			listaAves.add(temp);
		}
		}
	}
	
	@Override
	public void escribirEnArchivoDeTexto() {
		StringBuilder  sb = new StringBuilder();
		for (Ave ave : listaAves) {
			sb.append(ave.getNombre() + ";");
			sb.append(ave.getEspecie() + ";");
			sb.append(ave.getPeso() + ";");
			sb.append(ave.getEdad() + ";");
			sb.append(ave.getSexo() + ";");
			sb.append(ave.getHabitat() + ";");
			sb.append(ave.getFormaDesplazamiento() + ";");
			sb.append(ave.getTipoDePluma() + ";");
			sb.append(ave.getTipoDePico() + "\n");
		}
		FileHandler.escribirEnArchivoTexto(FILE_NAME, sb.toString());
	}


	@Override
	public void cargarDesdeArchivoSerializado() {
		Object contenido = FileHandler.leerDesdeArchivoSerializado(SERIAL_FILE_NAME);
		if (contenido != null) {
			listaAves = (ArrayList<Ave>) contenido;
		}
		else {
			listaAves = new ArrayList<>();
		}
	}


	@Override
	public void escribirEnArchivoSerializado() {
		FileHandler.escribirEnArchivoSerializado(SERIAL_FILE_NAME, listaAves);
		
	}
	
	
}
