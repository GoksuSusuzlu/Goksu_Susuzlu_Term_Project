package com.example.goksususuzlu_termproject;

public class Seat {
    private String seatType;
    private int seatTypeImageID;
    private Furnishing furnishing;

    public Seat(String seatType, int seatTypeImageID) {
        this.seatType = seatType;
        this.seatTypeImageID = seatTypeImageID;

    }

    public String getSeatType() {
        return seatType;
    }

    public void setSeatType(String seatType) {
        this.seatType = seatType;
    }

    public int getSeatTypeImageID() {
        return seatTypeImageID;
    }

    public void setSeatTypeImageID(int seatTypeImageID) {
        this.seatTypeImageID = seatTypeImageID;
    }

    public Furnishing getFurnishing() {
        return furnishing;
    }

    public void setFurnishing(Furnishing furnishing) {
        this.furnishing = furnishing;
    }
}
