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
	
	public static void verificarPalabra(String i) throws NotValidWordException{
		if(!i.toLowerCase().contains("a") &&
				!i.toLowerCase().contains("b")&&
				!i.toLowerCase().contains("c")&&
				!i.toLowerCase().contains("d")&&
				!i.toLowerCase().contains("e")&&
				!i.toLowerCase().contains("f")&&
				!i.toLowerCase().contains("g")&&
				!i.toLowerCase().contains("h")&&
				!i.toLowerCase().contains("i")&&
				!i.toLowerCase().contains("j")&&
				!i.toLowerCase().contains("k")&&
				!i.toLowerCase().contains("l")&&
				!i.toLowerCase().contains("m")&&
				!i.toLowerCase().contains("n")&&
				!i.toLowerCase().contains("o")&&
				!i.toLowerCase().contains("p")&&
				!i.toLowerCase().contains("q")&&
				!i.toLowerCase().contains("r")&&
				!i.toLowerCase().contains("s")&&
				!i.toLowerCase().contains("t")&&
				!i.toLowerCase().contains("u")&&
				!i.toLowerCase().contains("v")&&
				!i.toLowerCase().contains("w")&&
				!i.toLowerCase().contains("x")&&
				!i.toLowerCase().contains("x")&&
				!i.toLowerCase().contains("y")&&
				!i.toLowerCase().contains("z")) {
	        throw new NotValidWordException();
	    }
	}
	
	
	public static void verificarSexo(char sexo) throws InvalidSexException{
	    if (sexo != 'M' && sexo != 'H' && sexo != 'N' && sexo != 'm' && sexo != 'h' && sexo != 'n') {
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
	public static void verificarFechaVacia(LocalDate fecha) throws InvalidDateNullException{
		   if(fecha == null) {
			   throw new InvalidDateNullException();
		   }
	    }
	
		 
	       public static void verificarRespuesta(boolean r) throws InvalidAnswerException {
	    	   if(!r) {
	    		   throw new InvalidAnswerException();
	    	   }
	       }
	}
	
   
	

