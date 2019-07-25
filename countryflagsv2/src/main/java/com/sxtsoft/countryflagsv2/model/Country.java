package com.sxtsoft.countryflagsv2.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Country {

    private String name;
    private String alpha2Code;
    private String capital;

    //otros 3 atributos
    private String nativeName;
    private long population;
    private double area;

    @SerializedName("languages")
    private List<Language> lenguas;

    private List<String> borders;
    private String region;

    public Country(){

    }

    public Country(String name, String alpha2Code, String capital, String nativeName, long population, double area, List<Language> lenguas, List<String> borders, String region) {
        this.name = name;
        this.alpha2Code = alpha2Code;
        this.capital = capital;
        this.nativeName = nativeName;
        this.population = population;
        this.area = area;
        this.lenguas = lenguas;
        this.borders = borders;
        this.region = region;
    }

    public List<Language> getLenguas() {
        return lenguas;
    }

    public void setLenguas(List<Language> lenguas) {
        this.lenguas = lenguas;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAlpha2Code() {
        return alpha2Code;
    }

    public void setAlpha2Code(String alpha2Code) {
        this.alpha2Code = alpha2Code;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getNativeName() {
        return nativeName;
    }

    public void setNativeName(String nativeName) {
        this.nativeName = nativeName;
    }

    public long getPopulation() {
        return population;
    }

    public void setPopulation(long population) {
        this.population = population;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public List<String> getBorders() {
        return borders;
    }

    public void setBorders(List<String> borders) {
        this.borders = borders;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    @Override
    public String toString() {
        return "Country{" +
                "name='" + name + '\'' +
                ", alpha2Code='" + alpha2Code + '\'' +
                ", capital='" + capital + '\'' +
                ", nativeName='" + nativeName + '\'' +
                ", population=" + population +
                ", area=" + area +
                ", lenguas=" + lenguas +
                ", borders=" + borders +
                ", region='" + region + '\'' +
                '}';
    }
}
