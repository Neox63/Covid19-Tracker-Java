/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.covid19tracker.models;

import org.json.simple.JSONObject;

/**
 *
 * @author Neox
 */
public class Data {
    private String newCase;
    private String totalCase;
    private String newDeaths;
    private String totalDeaths;
    private String newRecovered;
    private String totalRecovered;

    public Data(JSONObject jsono) {
        this.newCase = jsono.get("NewConfirmed").toString();
        this.newCase = jsono.get("TotalConfirmed").toString();
        this.newCase = jsono.get("NewDeaths").toString();
        this.newCase = jsono.get("TotalDeaths").toString();
        this.newCase = jsono.get("NewRecovered").toString();
        this.newCase = jsono.get("TotalRecovered").toString();
    }

    public String getNewCase() {
        return newCase;
    }

    public void setNewCase(String newCase) {
        this.newCase = newCase;
    }

    public String getTotalCase() {
        return totalCase;
    }

    public void setTotalCase(String totalCase) {
        this.totalCase = totalCase;
    }

    public String getNewDeaths() {
        return newDeaths;
    }

    public void setNewDeaths(String newDeaths) {
        this.newDeaths = newDeaths;
    }

    public String getTotalDeaths() {
        return totalDeaths;
    }

    public void setTotalDeaths(String totalDeaths) {
        this.totalDeaths = totalDeaths;
    }

    public String getNewRecovered() {
        return newRecovered;
    }

    public void setNewRecovered(String newRecovered) {
        this.newRecovered = newRecovered;
    }

    public String getTotalRecovered() {
        return totalRecovered;
    }

    public void setTotalRecovered(String totalRecovered) {
        this.totalRecovered = totalRecovered;
    }

    @Override
    public String toString() {
        return "Cas totaux : " + totalCase;
    }
}
