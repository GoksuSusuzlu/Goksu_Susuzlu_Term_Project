package com.example.goksususuzlu_termproject;

import java.util.ArrayList;
import java.util.List;

public class Car {

    private String model, motor,bodyColor;
    private boolean smartphoneInterface,virtualCockpit,parkAssistant,hillStartAssist;
    private int imageId;
    static Car currentCar = new Car();
    private Rim rims;
    private Headlight headlights;
    private Seat seat;
    private SteeringWheel steeringWheel;
    private DecorativeElements decorativeElements;
    private boolean bodyColorSelected = false, rimsSelected = false, headlightsSelected = false,seatConfigured = false, steeringWheelSelected = false, decorativeElementsCustomized = false;
    private int selectedCarInteriorImageID;

    public int getSelectedCarInteriorImageID() {
        return selectedCarInteriorImageID;
    }


    public void setSelectedCarInteriorImageID(int modelNum) {
       switch (modelNum){
           case 0:
               selectedCarInteriorImageID = R.drawable.a1_interior;
               break;
           case 1:
               selectedCarInteriorImageID = R.drawable.a3_interior;
               break;
           case 2:
               selectedCarInteriorImageID = R.drawable.a4_interior;
               break;
           case 3:
               selectedCarInteriorImageID = R.drawable.a5_interior;
               break;

       }
    }

    public Headlight getHeadlights() {
        return headlights;
    }

    public void setHeadlights(Headlight headlights) {
        headlightsSelected = true;
        this.headlights = headlights;
    }
    public boolean exteriorComplete(){
        return bodyColorSelected && rimsSelected && headlightsSelected;
    }

    public boolean interiorComplete(){
        return seatConfigured && steeringWheelSelected && decorativeElementsCustomized;
    }

    public DecorativeElements getDecorativeElements() {
        return decorativeElements;
    }

    public void setDecorativeElements(DecorativeElements decorativeElements) {
        decorativeElementsCustomized = true;
        this.decorativeElements = decorativeElements;
    }

    public SteeringWheel getSteeringWheel() {
        return steeringWheel;
    }

    public void setSteeringWheel(SteeringWheel steeringWheel) {
        steeringWheelSelected = true;
        this.steeringWheel = steeringWheel;
    }

    public Seat getSeat() {
        seatConfigured = true;
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }

    static final Seat[] availableSeats = {
            new Seat("Standard seats",R.drawable.standardseats),
            new Seat("Sport seats", R.drawable.sportseats)

    };
    static final Furnishing[] availableSeatFurnishings = {
            new Furnishing("Standard Furnishing",R.drawable.standardfurnishing),
            new Furnishing("Black-Black Leather Furnishing",R.drawable.blackblackfurnishing),
            new Furnishing("Brown-Black Leather Furnishing",R.drawable.brownblackfurnishing),
            new Furnishing("Grey-Black Leather Furnishing",R.drawable.greyblackfurnishing)
    };

    public void setRims(Rim rims) {
        rimsSelected = true;
        this.rims = rims;
    }

    static final Car[] cars = {
          new Car("A1 Sportback",R.drawable.a1),
          new Car("A3 Sedan",R.drawable.a3),
          new Car("A4 Sedan",R.drawable.a4),
          new Car("A5 Sportback",R.drawable.a5)
    };
    static final Rim[] availableRims = {
           new Rim("16 inch",R.drawable.smallrims),
           new Rim("17 inch",R.drawable.mediumrims),
           new Rim("17 inch",R.drawable.mediumrims2),
           new Rim("18 inch",R.drawable.largerims),
           new Rim("18 inch",R.drawable.largerims2)
    };
    static final DecorativeElements[] availableDecorativeInserts = {
            new DecorativeElements("Decorative inserts in grey 3D Optic Titanium",R.drawable.three_d_optic_titanium_decorations),
            new DecorativeElements("Decorative inserts in Aluminium Mistral",R.drawable.aluminium_minstral_decorations),
            new DecorativeElements("Decorative inserts in Carbon Twill",R.drawable.carbon_twill_decorations),
            new DecorativeElements("Decorative inserts in silver micro metallic",R.drawable.micro_metallic_silver_decorations)
    };

    static final Headlight[] availableHeadlights = {
            new Headlight("LED Headlights",R.drawable.ledheadlights),
            new Headlight("Xenon Plus Headlights",R.drawable.xenonplusheadlights)
    };

    static final SteeringWheel[] availableSteeringWheels = {
            new SteeringWheel("Multifunctional sport leather wheel",R.drawable.cheapsteeringwheel),
            new SteeringWheel("Multifunctional sport leather wheel with tiptronic gear controller",R.drawable.expensivesteeringwheel)
    };
    private static final String [] A1Motors ={
            "1.0 TSI 95 HP","1.4 TSI 200 HP"
    };
    private static final String [] A3Motors = {
            "1.5 TFSI 150 HP", "2.0 TDI 116 HP",
            "2.0 TDI 150 HP"
    };
    private static final String[] A4Motors = {
            "40 TDI 190 hp", "40 TDI quattro 190 hp",
            "45 Turbo FSI quattro 245 hp"
    } ;
    private static final String[] A5Motors = {
        "40 TDI quattro 190 hp", "45 Turbo FSI quattro 245 hp",

    };
    private  String[] selectedCarMotors;
    public void resetCarMotor(){
        motor = null;
    }

    void setSelectedCarMotors(int modelNum) {
        switch (modelNum){
            case 0:

                selectedCarMotors = A1Motors;
                break;
            case 1:

                selectedCarMotors = A3Motors;
                break;
            case 2:

                selectedCarMotors = A4Motors;
                break;
            case 3:

                selectedCarMotors = A5Motors;
                break;
        }
    }

    String[] getSelectedCarMotors() {
        return selectedCarMotors;
    }

    int getImageId() {
        return imageId;
    }

    private Car(String model, int imageId) {
        this.model = model;
        this.imageId = imageId;
        smartphoneInterface = false;
        virtualCockpit = false;
        parkAssistant = false;
        hillStartAssist = false;
    }

    public Rim getRims() {
        return rims;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public Car() {
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

    public String getBodyColor() {
        return bodyColor;
    }

    public void setBodyColor(String bodyColor) {
        bodyColorSelected = true;
        this.bodyColor = bodyColor;
    }

    public boolean isParkAssistant() {
        return parkAssistant;
    }

    public void setParkAssistant(boolean parkAssistant) {
        this.parkAssistant = parkAssistant;
    }

    public boolean isHillStartAssist() {
        return hillStartAssist;
    }

    public void setHillStartAssist(boolean hillStartAssist) {
        this.hillStartAssist = hillStartAssist;
    }

    public boolean isSmartphoneInterface() {
        return smartphoneInterface;
    }

    public void setSmartphoneInterface(boolean smartphoneInterface) {
        this.smartphoneInterface = smartphoneInterface;
    }


    public boolean isVirtualCockpit() {
        return virtualCockpit;
    }

    public void setVirtualCockpit(boolean virtualCockpit) {
        this.virtualCockpit = virtualCockpit;
    }
}
