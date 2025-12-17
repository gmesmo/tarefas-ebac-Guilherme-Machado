package br.com.gmesmo.exercicio;

import java.util.*;
import java.util.stream.Collectors;

public class Exercicio {
    private static String pessoas;
    private static List<String> listaM;
    private static List<String> listaF;

    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        String pessoas = getPessoas();

        System.out.println("Informe as pessoas separadas por vírgula, com sexo após o traço (Ex.: Guilherme-M,Judy-F): ");
        setPessoas(scanner.nextLine());

        setListaM();
        setListaF();

        System.out.println("Homens\n");
        System.out.println(getListaM());
        System.out.println("\n\nMulheres\n");
        System.out.println(getListaF());
    }

    public static String getPessoas() {
        return pessoas;
    }

    public static void setPessoas(String pessoas) {
        Exercicio.pessoas = pessoas;
    }

    public static List<String> getListaM() {
        return listaM;
    }

    public static void setListaM() {
        Exercicio.listaM = Arrays.stream(getPessoas().split(","))
                .filter(pessoa -> pessoa.endsWith("M"))
                .map(pessoa -> pessoa.substring(0, pessoa.length() -2))
                .sorted()
                .toList();
    }

    public static List<String> getListaF() {
        return listaF;
    }

    public static void setListaF() {
        Exercicio.listaF = Arrays.stream(getPessoas().split(","))
                .filter(pessoa -> pessoa.endsWith("F"))
                .map(pessoa -> pessoa.substring(0, pessoa.length() -2))
                .sorted()
                .toList();
    }
}
