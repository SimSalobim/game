package com.example.myapplication.entity;

import java.util.Date;

public class PriceUpdate {
    private int id;
    private Date date;

    public int getId() { return id; }

    public Date getDate() {
        return date;
    }


    public PriceUpdate(int id, Date date) {
        this.id = id;
        this.date = date;

    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDate(Date date) { this.date = date; }

}