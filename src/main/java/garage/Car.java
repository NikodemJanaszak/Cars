package garage;

import java.util.Date;

public class Car {
    String make, model;
    int power;
    Date inspection;
    double weight;


    public Car(){}

    public Car(String make, String model, int power){
        this.make=make;
        this.model=model;
        this.power=power;
    }

    public Date getInspection() {
        return inspection;
    }

    public void setInspection(Date inspection) {
        this.inspection = inspection;
    }

    public String carData() {
        return this.make + " " + this.model + " power: " + this.power + " kW"+". Masa: "+this.weight+"t, przegląd od: "+this.inspection+", ważny przez rok";
    }

    public void setMake(String make) {
        this.make = make;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getPower() {
        return power;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
