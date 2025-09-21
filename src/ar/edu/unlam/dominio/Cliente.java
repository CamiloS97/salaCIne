package ar.edu.unlam.dominio;

public class Cliente {
	
	private String nombre;
	private Integer edad;
	
	public Cliente(String nombre, Integer edad) {
		this.nombre=nombre;
		this.edad=edad;
	}

	public String getNombre() {
		return nombre;
	}

	public Integer getEdad() {
		return edad;
	}
	
	
	
}
