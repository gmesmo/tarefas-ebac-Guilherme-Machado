package br.com.gmesmo.singleton;

public class DemoSingletonPropriedade {
    public void main(String args[]) {
        SingletonPropriedade singleton = SingletonPropriedade.getInstance("Teste");
        System.out.println(singleton);
    }
}
