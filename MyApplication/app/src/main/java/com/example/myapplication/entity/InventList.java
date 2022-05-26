package com.example.myapplication.entity;

import com.example.myapplication.Saved;

public class InventList {
    public String name;
    public int numb;

    public InventList(String name) {
        this.name = name;
    }

    public InventList() {
    }

    public InventList(String name, int numb) {
        this.name = name;
        this.numb = numb;
    }
}

