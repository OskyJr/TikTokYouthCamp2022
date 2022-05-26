package com.example.tiktokappdev.Network;

import java.util.ArrayList;

public class Model {
    ArrayList<data> food;
    ArrayList<data> drinks;

    public ArrayList<data> getFood() {
        return food;
    }

    public void setFood(ArrayList<data> food) {
        this.food = food;
    }

    public ArrayList<data> getDrinks() {
        return drinks;
    }

    public void setDrinks(ArrayList<data> drinks) {
        this.drinks = drinks;
    }

    public class data {
        String id;
        String name;
        String price;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }
    }
}
