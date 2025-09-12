package co.edu.unbosque.model;

import java.time.LocalDate;

public class Reptil extends Animal implements SerVivo , Mascota{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6306397420414076691L;
	private boolean esVenenoso;
	private boolean tieneEscama;
	
	public Reptil() {
		super();
	}

	public Reptil(boolean esVenenoso, boolean tieneEscama) {
		super();
		this.esVenenoso = esVenenoso;
		this.tieneEscama = tieneEscama;
	}

	

	

	public Reptil(String nombre, String especie, float peso, int edad, char sexo, String habitat,
			String formaDesplazamiento, LocalDate fechaIngreso, boolean esVenenoso, boolean tieneEscama) {
		super(nombre, especie, peso, edad, sexo, habitat, formaDesplazamiento, fechaIngreso);
		this.esVenenoso = esVenenoso;
		this.tieneEscama = tieneEscama;
	}
	

	public Reptil(String nombre, String especie, float peso, int edad, char sexo, String habitat,
			String formaDesplazamiento, LocalDate fechaIngreso) {
		super(nombre, especie, peso, edad, sexo, habitat, formaDesplazamiento, fechaIngreso);
		// TODO Auto-generated constructor stub
	}

	public boolean isEsVenenoso() {
		return esVenenoso;
	}

	public void setEsVenenoso(boolean esVenenoso) {
		this.esVenenoso = esVenenoso;
	}

	public boolean isTieneEscama() {
		return tieneEscama;
	}

	public void setTieneEscama(boolean tieneEscama) {
		this.tieneEscama = tieneEscama;
	}
	
	@Override
	public String dormir(String d) {
		if (d.equals("jaula") || d.equals("terrario")) {
			return "El reptil puede dormir en " + d + " sin problema";
		}
		else {
			return "El reptil no puede dormir en " + d;
		}
	}
	
	@Override
	public String alimentarse(String a) {
		if (a.equals("roedor") || a.equals("fruta")) {
			return "El reptil puede comer " + a + " sin problema";
		}
		else {
			return "El reptil no puede comer " + a;
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
		return super.toString() + "\n Es venenoso: " + esVenenoso + "\n Tiene escamas: " + tieneEscama;
	}
	
	
	
	
}
