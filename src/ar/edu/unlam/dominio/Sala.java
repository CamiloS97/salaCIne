package ar.edu.unlam.dominio;

public class Sala {
	
	private Pelicula pelicula;
	private Integer filas;
	private Integer asientos;
	private Butaca[][] butacas;
	
	public Sala(Integer filas, Integer asientos) {
		this.filas=filas;
		this.asientos=asientos;
		this.butacas=new Butaca[filas][asientos];
	}

	public Sala( Pelicula pelicula, Integer filas, Integer asientos) {
		this.pelicula=pelicula;
		this.filas=filas;
		this.butacas=new Butaca[filas][asientos];
		this.asientos=asientos;
	}

	public Pelicula getPelicula() {
		return pelicula;
	}

	public void setPelicula(Pelicula pelicula) {
		this.pelicula = pelicula;
	}

	public Boolean venderTicket(Cliente cliente, Integer filaTicket, Integer asientoTicket) {
		Butaca butaca=new Butaca(cliente.getNombre());
		if(cliente.getEdad()>=this.pelicula.getEdadMinima()) {
			if(butacas[filaTicket][asientoTicket]==null) {
				butacas[filaTicket][asientoTicket]=butaca;
				return true;
			}
		}
		return false;
	}

	public Integer getOcupadas() {
		Integer ocupadas=0;
		for(Butaca[] fila:butacas) {
			for(Butaca butaca:fila) {
				if(butaca!=null) {
					ocupadas++;
				}
			}
		}
		return ocupadas;
		
	}

	public void cambiarPelicula(Pelicula pelicula) {
		this.setPelicula(pelicula);
		this.butacas=new Butaca[this.filas][this.asientos];
		
	}
	
}
