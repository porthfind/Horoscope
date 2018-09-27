package com.rdev.horoscopemvvm.vo;

/**
 * Created by ritacf on 08/09/18.
 */

public class Horoscopo {

    private String name;
    private String type;
    private String description;

    public Horoscopo(){}

    public Horoscopo(String name, String type, String description) {
        this.name = name;
        this.type = type;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
