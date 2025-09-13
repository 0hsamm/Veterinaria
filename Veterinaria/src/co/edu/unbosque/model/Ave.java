package co.edu.unbosque.model;

import java.time.LocalDate;

public class Ave extends Animal implements SerVivo , Mascota{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2923746440812613752L;
	private String tipoDePluma;
	private String tipoDePico;
	
	public Ave() {
		super();
	}

	

	public Ave(String tipoDePluma, String tipoDePico) {
		super();
		this.tipoDePluma = tipoDePluma;
		this.tipoDePico = tipoDePico;
	}



	public Ave(String nombre, String especie, float peso, int edad, char sexo, String habitat,
			String formaDesplazamiento, LocalDate fechaIngreso, String tipoDePluma, String tipoDePico) {
		super(nombre, especie, peso, edad, sexo, habitat, formaDesplazamiento, fechaIngreso);
		this.tipoDePluma = tipoDePluma;
		this.tipoDePico = tipoDePico;
	}



	public Ave(String nombre, String especie, float peso, int edad, char sexo, String habitat,
			String formaDesplazamiento, LocalDate fechaIngreso) {
		super(nombre, especie, peso, edad, sexo, habitat, formaDesplazamiento, fechaIngreso);
		// TODO Auto-generated constructor stub
	}



	public String getTipoDePluma() {
		return tipoDePluma;
	}

	public void setTipoDePluma(String tipoDePluma) {
		this.tipoDePluma = tipoDePluma;
	}

	public String getTipoDePico() {
		return tipoDePico;
	}

	public void setTipoDePico(String tipoDePico) {
		this.tipoDePico = tipoDePico;
	}
	
	@Override
	public String dormir(String d) {
		if (d.equals("jaula")) {
			return "El ave si puede dormir en" + d + " sin problema";
		}
		else {
			return "El ave no puede dormir en " + d;
		}
	}
	
	@Override
	public String alimentarse(String a) {
		if (a.equals("semillas") || a.equals("lombrices")) {
			return "El ave puede comer " + a + " sin problema";
		}
		else {
			return "El ave no puede comer " + a;
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
		return super.toString() + "\n TipoDePluma: " + tipoDePluma + "\n Tipo de pico: " + tipoDePico + "\n------------------------";
	}
	
	
	
}
