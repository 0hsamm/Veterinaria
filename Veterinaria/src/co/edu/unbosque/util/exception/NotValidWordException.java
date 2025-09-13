package co.edu.unbosque.util.exception;

public class NotValidWordException extends Exception{
	public NotValidWordException() {
		super("El nombre ingresado no es valido");
	}
}
