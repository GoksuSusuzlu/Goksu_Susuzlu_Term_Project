package com.example.goksususuzlu_termproject;

class Furnishing {
    private String name;
    private int ImageID;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImageID() {
        return ImageID;
    }

    public void setImageID(int imageID) {
        ImageID = imageID;
    }

    public Furnishing(String name, int imageID) {
        this.name = name;
        ImageID = imageID;
    }
}
