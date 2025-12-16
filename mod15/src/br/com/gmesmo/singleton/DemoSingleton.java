package br.com.gmesmo.singleton;

public class DemoSingleton {

    public void main(String args[]) {
        Singleton singleton = Singleton.getInstance();
        System.out.println(singleton);
    }
}
