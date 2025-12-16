package br.com.gmesmo.exercicio;

public class Company extends Factory{

    @Override
    Car retrieveCar(String requestGrade, int brandChoice) {
        if (requestGrade == "HIGH") {
            if(brandChoice == 1) {
                return new Tesla("Tesla", 1300, "electric", "gray", "luxury");
            } else if (brandChoice == 2) {
                return new Porsche("Porsche", 1500, "gas", "yellow", "sport");
            }
        } else if (requestGrade == "LOW") {
            if(brandChoice == 1) {
                return new BYD("BYD", 900, "electric", "white", "default");
            } else if (brandChoice == 2) {
                return new Ford("Ford", 750, "gas", "black", "sport");
            }
        }

        System.out.println("No available car with this selection.");
        return null;
    }
}
