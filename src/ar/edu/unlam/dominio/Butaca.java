package ar.edu.unlam.dominio;

public class Butaca {
	private String nombre;
	private Boolean ocupada;
	
	public Butaca(String nombre) {
		this.nombre=nombre;
		this.ocupada=true;
	}
	public Boolean getOcupada() {
		return ocupada;
	}

}
