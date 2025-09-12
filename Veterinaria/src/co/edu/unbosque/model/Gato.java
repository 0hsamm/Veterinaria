package co.edu.unbosque.model;

import java.time.LocalDate;

public class Gato extends Animal implements SerVivo , Mascota{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2496402915321110107L;
	private String colorPelaje;
	private String tamanoOreja;
	
	public Gato() {
		super();
	}

	public Gato(String colorPelaje, String tamanoOreja) {
		super();
		this.colorPelaje = colorPelaje;
		this.tamanoOreja = tamanoOreja;
	}

	

	

	public Gato(String nombre, String especie, float peso, int edad, char sexo, String habitat,
			String formaDesplazamiento, LocalDate fechaIngreso, String colorPelaje, String tamanoOreja) {
		super(nombre, especie, peso, edad, sexo, habitat, formaDesplazamiento, fechaIngreso);
		this.colorPelaje = colorPelaje;
		this.tamanoOreja = tamanoOreja;
	}

	public Gato(String nombre, String especie, float peso, int edad, char sexo, String habitat,
			String formaDesplazamiento, LocalDate fechaIngreso) {
		super(nombre, especie, peso, edad, sexo, habitat, formaDesplazamiento, fechaIngreso);
		// TODO Auto-generated constructor stub
	}

	public String getColorPelaje() {
		return colorPelaje;
	}

	public void setColorPelaje(String colorPelaje) {
		this.colorPelaje = colorPelaje;
	}

	public String getTamanoOreja() {
		return tamanoOreja;
	}

	public void setTamanoOreja(String tamanoOreja) {
		this.tamanoOreja = tamanoOreja;
	}
	
	
	
	@Override
	public String dormir(String d) {
		if (d.equals("guacal") || d.equals("huacal") || d.equals("jaula")) {
			return "El gato si puede dormir en " + d + " sin problema";
		}
		else {
			return "El gato no puede dormir en " + d;
		}
	}
	
	@Override
	public String alimentarse(String a) {
		if (a.equals("concentrado")) {
			return "El gato si puede comer" + a + " sin problema";
		}
		else {
			return "El gato no puede comer" + a;
		}
	}
	
	@Override
	public String consentir(String c) {
		if (c.equals("Si")) {
			return "Se deja consentir sin problema";
		}
		else {
			return "No se dejo consentir";
		}
	}
	
	@Override
	public String toString() {
		return super.toString() + "\n Color del pelaje: " + colorPelaje + "\n Tamaño de la oreja: " + tamanoOreja;
	}
	
	
	
}
