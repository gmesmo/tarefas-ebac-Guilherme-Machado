package br.com.gmesmo.exercicio;

public abstract class Car {

    private String brand;
    private int horsePower;
    private String fuelSource;
    private String color;
    private String model;

    public Car(String brand, int horsePower, String fuelSource, String color, String model) {
        this.brand = brand;
        this.horsePower = horsePower;
        this.fuelSource = fuelSource;
        this.color = color;
        this.model = model;
    }

    public void separate() {
        System.out.println(brand + " car is now separated and ready for the next steps.");
    }

    public void startEngine() {
        System.out.println("The " + fuelSource + " engine has started, and is ready to utilize " + horsePower + "HP");
    }

    public void clean() {
        System.out.println("Car has been cleaned, and the " + color.toLowerCase() + " color shines");
    }

    public void mechanicCheck() {
        System.out.println("Car has been checked by the mechanic. Everything looks good!");
    }

    public void fuelCar() {
        System.out.println("Car is beeing filled with " + fuelSource.toLowerCase());
    }

    public void placeTires() {
        if (model == "sport") {
            System.out.println(model + " tires placed. This car is ready to race.");
        } else if (model == "luxury") {
            System.out.println(model + " tires placed. This car is looking great!");
        } else {
            System.out.println("Stock tires placed. They're good for every occasion.");
        }

    }
}
