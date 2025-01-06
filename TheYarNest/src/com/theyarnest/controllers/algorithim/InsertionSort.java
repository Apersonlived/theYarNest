/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.theyarnest.controllers.algorithim;

import com.theyarnest.model.CrochetModel;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Ekata Baral
 * LMU ID: 23048589
 */
public class InsertionSort {
    List<CrochetModel> categorySortList;
    
    public InsertionSort(){
        categorySortList = new LinkedList<>();
    }
    
    public List<CrochetModel> sortByCategory(List<CrochetModel> productList, boolean isDesc) {
        this.categorySortList.clear();
        this.categorySortList.addAll(productList);

        if (categorySortList == null || categorySortList.isEmpty()) {
            throw new IllegalArgumentException("Product list cannot be null or empty.");
        }

        for (int i = 1; i < categorySortList.size(); i++) {
            CrochetModel key = categorySortList.get(i);
            int j = i - 1;

            // Move elements that are greater (or smaller)
            // than the key to one position ahead of their current position
            while (j >= 0 && shouldSwap(key.getCategory(), categorySortList.get(j).getCategory(), isDesc)) {
                categorySortList.set(j + 1, categorySortList.get(j));
                j--;
            }

            categorySortList.set(j + 1, key);
        }

        return categorySortList;
    }

    /**
     * Determines whether the current value should replace the current extremum
     * based on sort order.
     *
     * @param current the current value
     * @param extremum the current extremum value
     * @param isDesc specifies the sort order (true for descending, false for
     * ascending)
     * @return true if the current value should replace the extremum; false
     * otherwise
     */
    private boolean shouldSwap(String current, String extremum, boolean isDesc) {
        return isDesc ? current.compareTo(extremum) > 0 : current.compareTo(extremum) < 0;
    }
    
}
