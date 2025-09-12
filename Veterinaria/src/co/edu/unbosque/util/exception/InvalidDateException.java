package co.edu.unbosque.util.exception;

public class InvalidDateException extends Exception{
	
	public InvalidDateException() {
		super("Ingrese una fecha válida o que entre en el formato solicitado");
	}

}
