package co.edu.unbosque.model.persistence;

import java.time.LocalDate;
import java.util.ArrayList;

import co.edu.unbosque.model.Perro;

public class PerroDAO implements DAO<Perro> {
	private ArrayList<Perro> listaPerros;
	private final String FILE_NAME = "Perro.csv";
	private final String SERIAL_FILE_NAME = "Perros.bin";
	
	
	
	public PerroDAO() {
		listaPerros = new ArrayList<>();
		//leerDesdeArchivoDeTexto(FILE_NAME);
		cargarDesdeArchivoSerializado();
	}

	@Override
	public void create(Perro newData) {
		listaPerros.add(newData);
		//escribirEnArchivoDeTexto();
		escribirEnArchivoSerializado();
	}

	@Override
	public boolean delete(int index) {
		if (index < 0 || index >= listaPerros.size()) {
			return false;
		} else {
			listaPerros.remove(index);
			//escribirEnArchivoDeTexto();
			escribirEnArchivoSerializado();
			return true;
		}
	}

	@Override
	public boolean update(int index, Perro newData) {
		if (index < 0 || index >= listaPerros.size()) {
			return false;
		} else {
			listaPerros.set(index, newData);
			//escribirEnArchivoDeTexto();
			escribirEnArchivoSerializado();
			return true;
		}
	}

	@Override
	public int count() {
		return listaPerros.size();
	}

	@Override
	public String showAll() {
		String content = "";
		for (Perro perro : listaPerros) {
			content += perro.toString() + "\n";
		}
		return content;
	}

	@Override
	public void leerDesdeArchivoDeTexto(String url) {
		String contenido;
		contenido = FileHandler.leerDesdeArchivoDeTexto(url);
		if (contenido == "" || contenido.isBlank()) {
			return;
		} else {
			String[] filas = contenido.split("\n");
			for (int i = 0; i < filas.length; i++) {
				String[] columnas = filas[i].split(";");
				Perro temp = new Perro();
				temp.setNombre(columnas[0]);
				temp.setEspecie(columnas[1]);
				temp.setPeso(Float.parseFloat(columnas[2]));
				temp.setEdad(Integer.parseInt(columnas[3]));
				temp.setSexo(columnas[4].charAt(0));
				temp.setHabitat(columnas[5]);
				temp.setFormaDesplazamiento(columnas[6]);
				temp.setColorPelaje(columnas[7]);
				temp.setTamanoOreja(columnas[8]);

				listaPerros.add(temp);
			}
		}
	}

	@Override
	public void escribirEnArchivoDeTexto() {
		StringBuilder  sb = new StringBuilder();
		for (Perro perro : listaPerros) {
			sb.append(perro.getNombre() + ";");
			sb.append(perro.getEspecie() + ";");
			sb.append(perro.getPeso() + ";");
			sb.append(perro.getEdad() + ";");
			sb.append(perro.getSexo() + ";");
			sb.append(perro.getHabitat() + ";");
			sb.append(perro.getFormaDesplazamiento() + ";");
			sb.append(perro.getColorPelaje() + ";");
			sb.append(perro.getTamanoOreja() + "\n");
		}
		FileHandler.escribirEnArchivoTexto(FILE_NAME, sb.toString());
		
	}
	
	public void cargarDesdeArchivoSerializado() {
		Object contenido = FileHandler.leerDesdeArchivoSerializado(SERIAL_FILE_NAME);
		if (contenido != null) {
			listaPerros = (ArrayList<Perro>) contenido;
		}
		else {
			listaPerros = new ArrayList<>();
		}
	}
	
	public void escribirEnArchivoSerializado() {
		FileHandler.escribirEnArchivoSerializado(SERIAL_FILE_NAME, listaPerros);
	}

	public String generarReporteDiaActual() {
	    LocalDate fechaActual = LocalDate.now();
	    StringBuilder sb = new StringBuilder();
	    
	    for (Perro perro : listaPerros) {
		    if (fechaActual.equals(perro.getFechaIngreso())) {
				sb.append(perro.toString()).append("\n");
			}
		}
	    return sb.toString();
	}

}
