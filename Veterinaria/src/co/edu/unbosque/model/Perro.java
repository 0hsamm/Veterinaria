package co.edu.unbosque.model;

import java.time.LocalDate;

public class Perro extends Animal implements SerVivo , Mascota{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1149620495545725621L;
	private String colorPelaje;
	private String tamanoOreja;
	
	public Perro() {
		super();
	}

	public Perro(String colorPelaje, String tamanoOreja) {
		super();//constructor vacio de la superclase
		this.colorPelaje = colorPelaje;
		this.tamanoOreja = tamanoOreja;
	}

	

	

	public Perro(String nombre, String especie, float peso, int edad, char sexo, String habitat,
			String formaDesplazamiento, LocalDate fechaIngreso, String colorPelaje, String tamanoOreja) {
		super(nombre, especie, peso, edad, sexo, habitat, formaDesplazamiento, fechaIngreso);
		this.colorPelaje = colorPelaje;
		this.tamanoOreja = tamanoOreja;
	}
	
	

	public Perro(String nombre, String especie, float peso, int edad, char sexo, String habitat,
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
	
	@Override//anotaciones java que dan capacidades en su tiempo de ejecucion
	public String dormir(String d) {
		if (d.equals("guacal") || d.equals("huacal") || d.equals("jaula")) {
			return "El perro si puede dormir en " + d + " sin problema";
		}
		else {
			return "El perro no puede dormir en " + d;
		}
	}
	
	@Override
	public String alimentarse(String a) {
		if (a.equals("concentrado")) {
			return "El perro si puede comer" + a + " sin problema";
		}
		else {
			return "El perro no puede comer" + a;
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
