package gto.talent.tech;

import gto.talent.tech.cars.F1WilliamsCar;

public class Main {
    public static void main(String[] args) {
        F1WilliamsCar car = new F1WilliamsCar();
        car.setColor("red");
        System.out.println("Car: " + car);
    }
}
