package com.example.arvaria;


import java.io.Serializable;

/**
 * Created by DEEP on 10-11-2019.
 */

public class User implements Serializable{
    private String image;
    private String name;
    private String job;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }
}

