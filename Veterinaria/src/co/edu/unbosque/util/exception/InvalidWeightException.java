package co.edu.unbosque.util.exception;

public class InvalidWeightException extends Exception{

	public InvalidWeightException() {
		super("Peso inválido, ingrese un peso válido");
	}
	
}
