package edu.eci.cvds.samples.services;

public class ServiciosBibliotecaException extends Exception{
	private static final long serialVersionUID = 1L;

	public ServiciosBibliotecaException(String message, Exception e) {
		super(message,e);
	}
	
	public ServiciosBibliotecaException(String message) {
		super(message);
	}
}