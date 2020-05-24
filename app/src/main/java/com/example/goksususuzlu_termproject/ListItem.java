package com.example.goksususuzlu_termproject;



public class ListItem {
    private int id;
    private String model, motor;

    public ListItem(int id, String model, String motor) {
        this.id = id;
        this.model = model;
        this.motor = motor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getMotor() {
        return motor;
    }

    public void setMotor(String motor) {
        this.motor = motor;
    }

    public String toString(){
        return this.model + " " + this.motor;
    }
}
