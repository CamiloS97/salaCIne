package ar.edu.unlam.dominio;

abstract class Pelicula {
	private String nombre;
	private Double duracion;
	private Integer edadMinima;
	private String sinopsis;
	
	public Pelicula( String nombre, Double duracion, Integer edadMinima) {
		this.nombre=nombre;
		this.duracion=duracion;
		this.edadMinima=edadMinima;
	}

	public void setSinopsis(String sinopsis) {
		this.sinopsis = sinopsis;
	}

	public String getNombre() {
		return nombre;
	}

	public String getSinopsis() {
		return sinopsis;
	}

	public Integer getEdadMinima() {
		return edadMinima;
	}
	
	
	
}
