package tests;
import junit.framework.*;
import persistence.Clientes;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;



public class TestaClientes extends TestCase {
	
	@Test
	public void testaConstrutor() {
		Clientes a = new Clientes("Felipe","00033322243",23,'M');
		assertEquals(a,new Clientes("Felipe","00033322243",23,'M'));
	}
	
	@Test
	public void testaNome() {
		Clientes a = new Clientes("Felipe","00033322243",23,'M');
		assertEquals(a.getNome(),"Felipe");
	}
	
	@Test
	public void testaCpf() {
		Clientes a = new Clientes("Felipe","00033322243",23,'M');
		assertEquals(a.getCpf(),"00033322243");
	}
	
	@Test
	public void testaIdade() {
		Clientes a = new Clientes("Felipe","00033322243",23,'M');
		assertEquals(a.getIdade(),23);
	}
	
	@Test
	public void testaGenero() {
		Clientes a = new Clientes("Felipe","00033322243",23,'M');
		assertEquals(a.getGenero(),'M');
	}

}
