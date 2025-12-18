package br.com.gmesmo;

import org.junit.Assert;
import org.junit.Test;

public class TesteClienteTest {

	@Test
	public void testeClasseCliente() {
		TesteCliente cli = new TesteCliente();
		cli.adicionarNome("Guilherme");
		cli.adicionarNome1("Guilherme");

		Assert.assertEquals("Guilherme", cli.getNome());
	}
}
