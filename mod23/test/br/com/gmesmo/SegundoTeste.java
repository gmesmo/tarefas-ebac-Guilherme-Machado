package br.com.gmesmo.testes;

import org.junit.Assert;
import org.junit.Test;

public class SegundoTeste {

    @Test
    public void test2() {
        String nome = "Guilherme";
        Assert.assertEquals("Guilherme", nome);
    }
}
