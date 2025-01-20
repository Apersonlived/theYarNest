/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.theyarnest.controllers;

import java.util.regex.Pattern;

/**
 *
 * @author Ekata Baral
 * LMU ID: 23048589
 */
public class ValidationUtil {
    private static final Pattern ID_PATTERN = Pattern.compile("^\\d$");
    private static final Pattern PRODUCT_NAME_PATTERN = Pattern.compile("^[a-zA-Z]+(['-][a-zA-Z]+)*$");
    private static final Pattern CATEGORY_PATTERN = Pattern.compile("^(Sweater|Scarf|Cardigan)$");
    private static final Pattern YARN_TYPE_PATTERN = Pattern.compile("^(Cotton|Wool|Acrylic|Chunky|Cashmere)$");
    private static final Pattern PRICE_PATTERN = Pattern.compile("[+]?([0-9]*\\.[0-9]+|[0-9]+)");
    
    public static boolean isNullOrEmpty(String text){
        return text ==null || text.trim().isEmpty();
    }
    
    public static boolean isValidId(String prodId){
        return ID_PATTERN.matcher(prodId).matches();
    }
    
    public static boolean isValidProdName(String prodName){
        prodName = prodName.trim();//remove leading or trailing space
        prodName = prodName.replaceAll("\\s+"," ");//remove extra whitespace
        return PRODUCT_NAME_PATTERN.matcher(prodName).matches();
    }
    
    public static boolean isValidCategory(String category){
        return CATEGORY_PATTERN.matcher(category).matches();
    }
    
    public static boolean isValidYarnType(String yarnType){
        return YARN_TYPE_PATTERN.matcher(yarnType).matches();
    }
    
    public static boolean isValidStock(int stock){
        return stock<100 && stock>=0;
    }
    
    public static boolean isValidPrice(String price){
        return PRICE_PATTERN.matcher(price).matches();
    }    
}
