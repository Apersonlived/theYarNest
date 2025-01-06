/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.theyarnest.model;

/**
 *
 * @author Ekata Baral
 * LMU ID: 23048589
 */
public class CrochetModel {
    private int prodId;
    private String prodName;
    private String category;
    private String yarnType;
    private boolean repairable;
    private String description;
    private float price;
    private int stock;
    private String dateAdded;

    public CrochetModel(int prodId, String prodName, String category, String yarnType, 
            boolean repairable, String description, float price, int stock, String dateAdded){
        this.prodId = prodId;
        this.prodName = prodName;
        this.category = category;
        this.yarnType = yarnType;
        this.repairable = repairable;
        this.description = description;
        this.price = price;
        this.stock = stock;
        this.dateAdded = dateAdded;
    }

    public int getProdId() {
        return prodId;
    }

    public void setProdId(int prodId) {
        this.prodId = prodId;
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String catageory) {
        this.category = catageory;
    }

    public String getYarnType() {
        return yarnType;
    }

    public void setYarnType(String yarnType) {
        this.yarnType = yarnType;
    }

    public boolean isRepairable() {
        return repairable;
    }

    public void setRepairable(boolean repairable) {
        this.repairable = repairable;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(String dateAdded) {
        this.dateAdded = dateAdded;
    }
}
