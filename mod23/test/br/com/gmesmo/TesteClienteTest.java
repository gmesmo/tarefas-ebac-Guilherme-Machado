package br.com.gmesmo;

import br.com.gmesmo.TesteCliente;
import org.junit.Assert;
import org.junit.Test;

public class TesteClienteTest {

    @Test
    public void testeClasseCliente() {
        TesteCliente cli = new TesteCliente();
        cli.setNome("Guilherme");
        Assert.assertEquals("Guilherme", cli.getNome());
    }
}
