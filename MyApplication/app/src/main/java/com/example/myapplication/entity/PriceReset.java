package com.example.myapplication.entity;

import java.util.Date;

public class PriceReset {
    public static final String TABLE_NAME = "RESETPRICE";
    public static final String COLUMN_ID = "ID";
    public static final String COLUMN_DATE = "DATE";
    public static final int NUM_COLUMN_ID = 0;
    public static final int NUM_COLUMN_DATE = 1;

    private int id;
    private Date date;

    public int getId() { return id; }

    public Date getDate() {
        return date;
    }


    public PriceReset(int id, Date date) {
        this.id = id;
        this.date = date;

    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDate(Date date) { this.date = date; }

}
