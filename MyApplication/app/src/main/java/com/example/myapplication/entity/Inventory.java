package com.example.myapplication.entity;

public class Inventory {
    public static final String TABLE_NAME = "INVENTORYS";
    public static final String COLUMN_ID = "ID";
    public static final String COLUMN_RESOURCE = "RESOURCE";
    public static final String COLUMN_NUMB = "NUMB";
    public static final int NUM_COLUMN_ID = 0;
    public static final int NUM_COLUMN_RESOURCE = 1;
    public static final int NUM_COLUMN_NUMB = 2;

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
