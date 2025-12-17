package br.com.gmesmo;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class PrimeiroTests {

    @Test
    public void test() {
        String nome = "Guilherme";
        Assert.assertEquals("Guilherme", nome);
    }

    @Test
    public void test1() {
        String nome = "Guilherme";
        Assert.assertNotEquals("GMesmo", nome);
    }
}