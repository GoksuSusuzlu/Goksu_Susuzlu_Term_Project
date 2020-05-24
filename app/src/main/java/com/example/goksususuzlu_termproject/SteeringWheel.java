package com.example.goksususuzlu_termproject;

public class SteeringWheel {

    private String wheelType;
    private int ImageID;

    public SteeringWheel(String wheelType, int imageID) {
        this.wheelType = wheelType;
        ImageID = imageID;
    }

    public String getWheelType() {
        return wheelType;
    }

    public void setWheelType(String wheelType) {
        this.wheelType = wheelType;
    }

    public int getImageID() {
        return ImageID;
    }

    public void setImageID(int imageID) {
        ImageID = imageID;
    }
}
