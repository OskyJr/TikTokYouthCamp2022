package com.example.tiktokappdev.DataModels;

import java.util.ArrayList;

public class MenuDataModel {
    ArrayList<data> food;
    ArrayList<data> drinks;

    public ArrayList<data> getFood() {
        return food;
    }

    public ArrayList<data> getDrinks() {
        return drinks;
    }

    public static class data {
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

    }
}
