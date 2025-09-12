package co.edu.unbosque.model;

import java.time.LocalDate;

public class Pez extends Animal implements SerVivo , Mascota{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6427369053566093475L;
	private boolean tieneEscama;
	private String tamanoAleta;
	
	public Pez() {
		super();
	}

	public Pez(boolean tieneEscama, String tamanoAleta) {
		super();
		this.tieneEscama = tieneEscama;
		this.tamanoAleta = tamanoAleta;
	}

	

	

	public Pez(String nombre, String especie, float peso, int edad, char sexo, String habitat,
			String formaDesplazamiento, LocalDate fechaIngreso, boolean tieneEscama, String tamanoAleta) {
		super(nombre, especie, peso, edad, sexo, habitat, formaDesplazamiento, fechaIngreso);
		this.tieneEscama = tieneEscama;
		this.tamanoAleta = tamanoAleta;
	}
	
	

	public Pez(String nombre, String especie, float peso, int edad, char sexo, String habitat,
			String formaDesplazamiento, LocalDate fechaIngreso) {
		super(nombre, especie, peso, edad, sexo, habitat, formaDesplazamiento, fechaIngreso);
		// TODO Auto-generated constructor stub
	}

	public boolean isTieneEscama() {
		return tieneEscama;
	}

	public void setTieneEscama(boolean tieneEscama) {
		this.tieneEscama = tieneEscama;
	}

	public String getTamanoAleta() {
		return tamanoAleta;
	}

	public void setTamanoAleta(String tamanoAleta) {
		this.tamanoAleta = tamanoAleta;
	}
	
	@Override
	public String dormir(String d) {
		if (d.equals("pecera") || d.equals("estanque")) {
			return "El pez puede dormir en " + d + " sin problema";
		}
		else {
			return "El pez no puede dormir en " +d;
		}
	}
	
	@Override
	public String alimentarse(String a) {
		if (a.equals("algas") || a.equals("hojuelas")) {
			return "El alimento " + a + " es apropiador para el pez";
		}
		else {
			return "El pez no deb de comer " + a;
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
		return super.toString() + "\n Tiene escamas: " + tieneEscama + "\n Tamaño de la aleta: " + tamanoAleta;
	}
	
	
	
}
