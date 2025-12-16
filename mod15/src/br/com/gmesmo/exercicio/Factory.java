package br.com.gmesmo.exercicio;

public abstract class Factory {

    public Car create(String requestGrade, int brandChoice) {
        Car car = retrieveCar(requestGrade, brandChoice);
        car = prepareCar(car);
        return(car);
    }

    private Car prepareCar(Car car) {
        car.separate();
        car.clean();
        car.placeTires();
        car.mechanicCheck();
        car.fuelCar();
        return(car);
    }

    abstract Car retrieveCar(String requestGrade, int brandChoice);
}
