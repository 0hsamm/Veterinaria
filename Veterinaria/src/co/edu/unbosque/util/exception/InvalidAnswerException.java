package co.edu.unbosque.util.exception;

public class InvalidAnswerException extends Exception{

	public InvalidAnswerException() {
		super("Respuesta inválida, ingrese una respuesta válida\n");
	}
	
}
