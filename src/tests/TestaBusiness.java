package tests;
import junit.framework.*;
import persistence.Clientes;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import business.Business;

public class TestaBusiness extends TestCase {
	
	@Test
	public void TestaAdd() {
		Business a = new Business();
		Clientes b = new Clientes("Felipe","00033322243",23,'M');
		a.addCliente(b);
		assertEquals(a.getListaDia().size(),1);
	}
	
	@Test
	public void TestaRemove() {
		Business a = new Business();
		Clientes b = new Clientes("Felipe","00033322243",23,'M');
		a.addCliente(b);
		a.removeCliente(b.getCpf());
		assertEquals(a.getListaDia().size(),0);
	}
	
	@Test
	public void TestaPesquisaNome() {
		Business a = new Business();
		Clientes b = new Clientes("Felipe","00033322243",23,'M');
		a.addCliente(b);
		Clientes c = a.pesquisaPorNome(b.getNome());
		assertEquals(b,c);
	}
	
	@Test
	public void TestaPesquisaCPF() {
		Business a = new Business();
		Clientes b = new Clientes("Felipe","00033322243",23,'M');
		a.addCliente(b);
		Clientes c = a.pesquisaPorCpf(b.getCpf());
		assertEquals(b,c);
	}
	
	@Test
	public void TestaNumeroClientes() {
		Business a = new Business();
		Clientes b = new Clientes("Felipe","00033322243",23,'M');
		Clientes c = new Clientes("Felpe","00032222243",21,'M');
		a.addCliente(c);
		a.addCliente(b);
		assertEquals(a.numeroClientes(),a.getListaBar().size());
	}

	
	

}
