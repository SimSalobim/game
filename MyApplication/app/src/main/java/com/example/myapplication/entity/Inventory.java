package com.example.myapplication.entity;

public class Inventory {
    private int id;
    private String Resource;
    private int Numb;

    public int getId() {
        return id;
    }

    public String getResource() {
        return Resource;
    }

    public int getNumb() {
        return Numb;
    }

    public Inventory(int id,String Resource,int Numb) {
        this.id = id;
        this.Resource = Resource;
        this.Numb = Numb;

    }

    public void setId(int id) {
        this.id = id;
    }

    public void setResource(String resource) {
        Resource = resource;
    }

    public void setNumb(int numb) {
        Numb = numb;
    }

}
