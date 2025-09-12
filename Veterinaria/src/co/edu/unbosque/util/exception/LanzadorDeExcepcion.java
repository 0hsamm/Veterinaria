package co.edu.unbosque.util.exception;

import java.time.LocalDate;

public class LanzadorDeExcepcion {
	
	public static void verificarNumeroNegativo(int n) throws NegativeNumberException {
		if (n < 0) {
			throw new NegativeNumberException();
		}
	}
	
	public static void verificarNumeroNegativo(float n) throws NegativeNumberException {
		if (n < 0) {
			throw new NegativeNumberException();
		}
	}
	
	public static void verificarNombre(String s) throws NotValidNameException{
	    for (char c : s.toCharArray()) {
	        if (Character.isLetter(c) && s.contains(" ")) {
	        	return;
	        }
	        throw new NotValidNameException();
	    }
	}
	
	public static void verificarSexo(char sexo) throws InvalidSexException{
	    if (sexo != 'M' && sexo != 'H' && sexo != 'N') {
	        throw new InvalidSexException();
	    }
	}
	
	public static void verificarTamanio(String t)throws InvalidSizeException {
		if (t.toLowerCase().contains("grande")||t.toLowerCase().contains("mediano")||t.toLowerCase().contains("pequeño")) {
			return;
		} 
		throw new InvalidSizeException();
	}
	public static void verificarFecha(LocalDate fechaIngresada) throws InvalidDateException {
		if(fechaIngresada.isAfter(LocalDate.now()))
		throw new InvalidDateException();
	}
	
}
