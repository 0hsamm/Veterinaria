package co.edu.unbosque.model;

import java.io.Serializable;
import java.time.LocalDate;

public abstract class Animal implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3679142107518547371L;
	private String nombre;
	private String especie;
	private float peso;
	private int edad;
	private char sexo;
	private String habitat;
	private String formaDesplazamiento;
	private LocalDate fechaIngreso;
	
	public Animal() {
		super();	
	}

	public Animal(String nombre, String especie, float peso, int edad, char sexo, String habitat,
			String formaDesplazamiento, LocalDate fechaIngreso) {
		super();
		this.nombre = nombre;
		this.especie = especie;
		this.peso = peso;
		this.edad = edad;
		this.sexo = sexo;
		this.habitat = habitat;
		this.formaDesplazamiento = formaDesplazamiento;
		this.fechaIngreso = fechaIngreso;
	}



	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEspecie() {
		return especie;
	}

	public void setEspecie(String especie) {
		this.especie = especie;
	}

	public float getPeso() {
		return peso;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public String getHabitat() {
		return habitat;
	}

	public void setHabitat(String habitat) {
		this.habitat = habitat;
	}
	
	
	
	public String getFormaDesplazamiento() {
		return formaDesplazamiento;
	}

	public void setFormaDesplazamiento(String formaDesplazamiento) {
		this.formaDesplazamiento = formaDesplazamiento;
	}

	
	
	public LocalDate getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(LocalDate fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	@Override
	public String toString() {
		return "\n------------------------" + "\n Nombre: " + nombre + "\n Especie: " + especie + "\n Peso: " + peso + "\n Edad: " + edad + "\n Sexo: "
				+ sexo + "\n Habitat: " + habitat + "\n Forma de desplazamiento: " + formaDesplazamiento + "\n Fecha de ingreso: " + fechaIngreso;
	}

	
	
	
	
}
