package tests;
import junit.framework.*;
import persistence.Clientes;
import persistence.Socios;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;



public class TestaSocios extends TestCase {
	
	@Test
	public void testaConstrutor() {
		Socios a = new Socios("Felipe","00033322243",23,'M',0001);
		assertEquals(a,new Socios("Felipe","00033322243",23,'M',0001));
	}
	
	@Test
	public void testaConstrutor2() {
		Clientes a = new Clientes("Felipe","00033322243",23,'M');
		Socios b = new Socios(a,0001);
		assertEquals(b,new Socios("Felipe","00033322243",23,'M',0001));
	}
	
	@Test
	public void testaMatricula() {
		Socios a = new Socios("Felipe","00033322243",23,'M',0001);
		assertEquals(a.getMatricula(),0001);
	}
	
	}