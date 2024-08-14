package com.ejercicio.exception;

public class ServiceException extends Exception {
    private static final long serialVersionUID = 1642549856906849256L;

    private String codigoError;
	private String mensaje;

    public ServiceException(){
		super(); 
	}

	public ServiceException(String codigoError, String mensaje) {
		super();
		this.codigoError = codigoError;
		this.mensaje = mensaje;
	}

	public String getCodigoError() {
		return codigoError;
	}

	public void setCodigoError(String codigoError) {
		this.codigoError = codigoError;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
}
