/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.theyarnest.controllers.algorithim;

import com.theyarnest.model.CrochetModel;
import java.util.List;

/**
 *
 * @author Ekata Baral
 * LMU ID: 23048589
 */
public class BinarySearch {
    public CrochetModel searchByName(String searchValue, List<CrochetModel> productList,
            int top, int bottom) {

        // Base Case
        if (bottom < top) {
            return null;
        }

        // mid value
        int mid = (top + bottom) / 2;

        // checks whether searchValue lies on mid point
        if (searchValue.compareToIgnoreCase(productList.get(mid).getProdName()) == 0) {
            return productList.get(mid);
        } else if (searchValue.compareToIgnoreCase(productList.get(mid).getProdName()) < 0) {
            return searchByName(searchValue, productList, top, mid - 1);
        } else {
            return searchByName(searchValue, productList, mid + 1, bottom);
        }

    }
}
