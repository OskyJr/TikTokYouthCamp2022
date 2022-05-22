package com.example.tiktokappdev.DataModels;

public class MyCatsDataModel {

    private String CatID;
    private String Name;
    private String Age;
    private String Breed;
    private String Description;
    private Integer Image;


    public MyCatsDataModel(String catID, String name, String age, String breed, String description, Integer image) {
        CatID = catID;
        this.Name = name;
        this.Age = age;
        this.Breed = breed;
        this.Image = image;
        this.Description = description;
    }


    public String getCatID() {
        return CatID;
    }

    public void setCatID(String catID) {
        CatID = catID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAge() {
        return Age;
    }

    public void setAge(String age) {
        Age = age;
    }

    public String getBreed() {
        return Breed;
    }

    public void setBreed(String breed) {
        Breed = breed;
    }

    public Integer getImage() {
        return Image;
    }

    public void setImage(Integer image) {
        Image = image;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

}
