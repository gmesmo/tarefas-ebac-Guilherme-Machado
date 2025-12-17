package br.com.gmesmo;

import br.com.gmesmo.exercicio.Exercicio;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TesteExercicio {

    @Test
    public void ExercicioTest() {
        List<String> expectedList = Arrays.asList("Ciça", "Judy");
        Exercicio exerc = new Exercicio();
        exerc.setPessoas("Judy-F,Guilherme-M,Ciça-F,Vilson-M");
        exerc.setListaF();
        Assert.assertEquals("Judy-F,Guilherme-M,Ciça-F,Vilson-M", exerc.getPessoas());
        Assert.assertEquals(expectedList, exerc.getListaF());
    }
}
