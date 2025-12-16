package br.com.gmesmo.exercicio;

public class Demo {

    public static void main(String args[]) {
        Customer customerOne = new Customer("LOW", 1);
        Factory factory = getCarFactory(customerOne);
        Car carOne = factory.create(customerOne.getGradeRequest(), customerOne.getBrandChoice());
        carOne.startEngine();
    }

    private static Factory getCarFactory(Customer customer) {
        return new Company();
    }
}
