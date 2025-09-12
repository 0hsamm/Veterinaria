package co.edu.unbosque.util.exception;

public class NotValidNameException extends Exception{
	public NotValidNameException() {
		super("El nombre ingresado no es valido");
	}
}
