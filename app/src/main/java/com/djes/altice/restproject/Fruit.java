package com.djes.altice.restproject;

import com.google.gson.annotations.SerializedName;

public class Fruit {

    @SerializedName("id")
    public int Id;
    @SerializedName("name")
    public String Name;
    @SerializedName("description")
    public String Description;
    @SerializedName("image_url")
    public String Image;

    public Fruit(int id, String name, String description,String image)
    {
        this.Id=id;
        this.Name=name;
        this.Description = description;
        this.Image = image;
    }



    public void setName(String name)
    {
        this.Name=name;
    }

    public void setDescription(String description)
    {
        this.Description=description;
    }

    public void setImage(String image)
    {
        this.Image=image;
    }

    public String getName()
    {
        return Name;
    }

    public String getDescription()
    {
        return Description;
    }

    public String getImage()
    {
        return Image;
    }

}
