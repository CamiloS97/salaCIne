package ar.edu.unlam.dominio;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class testCine {
	
	//Clase Butaca
	@Test
	public void dadoQueNoTengoUnaButacaAlCrearlaObtengoQueEstaOcupada() {
		String nombre="Camilo";
		Butaca butaca=new Butaca(nombre);
		
		
		Boolean resultadoObtenido=butaca.getOcupada();
		
		assertTrue(resultadoObtenido);

	}
	//Clase Pelicula
	@Test
	public void dadoQueNoTengoUnaPeliculaAlCrearlaObtengoQueSuNombre() {
		//Crea pelicula DeAccion
		String nombre="John Wick";
		Double duracion=2D;
		Integer edadMinima=18;
		DeAccion peliculaAccion = new DeAccion(nombre,duracion,edadMinima);
		
		String resultadoEsperado=nombre;
		String resultadoObtenido=peliculaAccion.getNombre();
		String sinopsisEsperada="Muchos tiros";
		String sinopsisObtenida=peliculaAccion.getSinopsis();
		
		assertTrue(resultadoEsperado.equals(resultadoObtenido));
		assertTrue(sinopsisEsperada.equals(sinopsisObtenida));
		
		//Crea pelicula Comedia
		nombre="Zoolander";
		duracion=1.5;
		edadMinima=16;
		Comedia peliculaComedia = new Comedia(nombre,duracion,edadMinima);
		
		resultadoEsperado=nombre;
		resultadoObtenido=peliculaComedia.getNombre();
		sinopsisEsperada="Muchas risas";
		sinopsisObtenida=peliculaComedia.getSinopsis();
		
		assertTrue(resultadoEsperado.equals(resultadoObtenido));
		assertTrue(sinopsisEsperada.equals(sinopsisObtenida));
		
		//Crea pelicula ATP
		nombre="Toy Story";
		duracion=1.2;
		edadMinima=3;
		ATP peliculaATP = new ATP(nombre,duracion,edadMinima);
		
		resultadoEsperado=nombre;
		resultadoObtenido=peliculaATP.getNombre();
		sinopsisEsperada="Muchos dibujitos";
		sinopsisObtenida=peliculaATP.getSinopsis();
		
		assertTrue(resultadoEsperado.equals(resultadoObtenido));
		assertTrue(sinopsisEsperada.equals(sinopsisObtenida));
		
		//Crea pelicula Romantica
		nombre="Orgullo y prejuicio";
		duracion=1.9;
		edadMinima=12;
		Romantica peliculaRomantica = new Romantica(nombre,duracion,edadMinima);
		
		resultadoEsperado=nombre;
		resultadoObtenido=peliculaRomantica.getNombre();
		sinopsisEsperada="Mucho amor";
		sinopsisObtenida=peliculaRomantica.getSinopsis();
		
		assertTrue(resultadoEsperado.equals(resultadoObtenido));
		assertTrue(sinopsisEsperada.equals(sinopsisObtenida));
		
		

	}
	//Clase Sala
	@Test
	public void dadoQueTengoUnaSalaObtengoQuePeliculaSeEstaProyectando(){
		Integer filas = 10;
		Integer asientos=10;
		String nombre="John Wick";
		Double duracion=2D;
		Integer edadMinima=18;
		DeAccion peliculaAccion = new DeAccion(nombre,duracion,edadMinima);
//		Sala sala = new Sala(filas, asientos);
//		sala.setPelicula(peliculaAccion);
		Sala sala = new Sala(peliculaAccion,filas, asientos);
		
		Pelicula peliculaEsperada=peliculaAccion;
		Pelicula peliculaObtenida=sala.getPelicula();
		
		assertTrue(peliculaEsperada.equals(peliculaObtenida));
		
	}
	
	@Test
	public void dadoQueTengoUnaSalaAlConsultarPorLasButacasObtengoCualesEstanOcupadas() {
		Integer filas = 10;
		Integer asientos=10;
		String nombre="John Wick";
		Double duracion=2D;
		Integer edadMinima=18;
		DeAccion peliculaAccion = new DeAccion(nombre,duracion,edadMinima);
		Sala sala = new Sala(peliculaAccion,filas, asientos);
		
		Integer butacasObtenidas=sala.getOcupadas();
		Integer butacasEsperadas=0;
		
		assertTrue(butacasEsperadas.equals(butacasObtenidas));
	}
	
	@Test
	public void dadoQueTengoUnClienteConEdadLeVendoUnaEntradaSiEsMayorYLaButacaEsteVacia() {
		Integer filas = 10;
		Integer asientos=10;
		String pelicula="John Wick";
		Double duracion=2D;
		Integer edadMinima=18;
		DeAccion peliculaAccion = new DeAccion(pelicula,duracion,edadMinima);
		Sala sala = new Sala(peliculaAccion,filas, asientos);
		String nombre="Camilo";
		Integer edad=27;
		Integer filaTicket=5;
		Integer asientoTicket=5;
		
		Cliente cliente=new Cliente(nombre, edad);
		
		Boolean seVendio=sala.venderTicket(cliente,filaTicket,asientoTicket);
		
		assertTrue(seVendio);
		
		//Se prueba un cliente menor de la edad minima;
		edad=17;
		Cliente clienteDos=new Cliente(nombre, edad);
		seVendio=sala.venderTicket(clienteDos,1,1);
		
		assertFalse(seVendio);
		
		//Se prueba una butaca ocupada
		edad=50;
		Cliente clienteTres=new Cliente(nombre, edad);
		seVendio=sala.venderTicket(clienteTres,filaTicket,asientoTicket);
		
		assertFalse(seVendio);
		
		Integer butacasObtenidas=sala.getOcupadas();
		Integer butacasEsperadas=1;
		
		assertTrue(butacasEsperadas.equals(butacasObtenidas));
		
	}
	@Test
	public void dadoQueTengoUnaSalaProyectandoAlCambiarlaPeliculaObtengoQueLaNuevaPelicula() {
		Integer filas = 10;
		Integer asientos=10;
		String pelicula="John Wick";
		Double duracion=2D;
		Integer edadMinima=18;
		DeAccion peliculaAccion = new DeAccion(pelicula,duracion,edadMinima);
		pelicula="Zoolander";
		duracion=1.5;
		edadMinima=16;
		Comedia peliculaComedia = new Comedia(pelicula,duracion,edadMinima);
		Sala sala = new Sala(peliculaAccion,filas, asientos);	
		String nombre="Camilo";
		Integer edad=27;
		Integer filaTicket=5;
		Integer asientoTicket=5;
		Cliente cliente=new Cliente(nombre, edad);
		sala.venderTicket(cliente,filaTicket,asientoTicket);

		Integer butacasObtenidas=sala.getOcupadas();
		Integer butacasEsperadas=1;
		
		assertTrue(butacasEsperadas.equals(butacasObtenidas));
	
		sala.cambiarPelicula(peliculaComedia);
		Pelicula peliculaEsperada=peliculaComedia;
		Pelicula peliculaObtenida=sala.getPelicula();
		
		assertTrue(peliculaEsperada.equals(peliculaObtenida));
		
		//Se prueba que la sala esté vacia
		butacasObtenidas=sala.getOcupadas();
		butacasEsperadas=0;
		
		assertTrue(butacasEsperadas.equals(butacasObtenidas));
		
		//Se prueba que la sala se pueda seguir vendiendo
		sala.venderTicket(cliente,filaTicket,asientoTicket);
		butacasObtenidas=sala.getOcupadas();
		butacasEsperadas=1;
		
		assertTrue(butacasEsperadas.equals(butacasObtenidas));
	}
}
