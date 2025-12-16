package br.com.gmesmo.exercicio;

public class Customer {

    private String gradeRequest;
    private int brandChoice;

    public Customer(String gradeRequest, int brandChoice) {
        this.gradeRequest = gradeRequest;
        this.brandChoice = brandChoice;
    }

    public String getGradeRequest() {
        return gradeRequest;
    }

    public int getBrandChoice() {
        return brandChoice;
    }
}
