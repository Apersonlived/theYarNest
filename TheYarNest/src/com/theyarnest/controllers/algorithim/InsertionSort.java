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
    List<CrochetModel> nameSortList;
    
    public InsertionSort(){
        nameSortList = new LinkedList<>();
    }
    
    public List<CrochetModel> sortByName(List<CrochetModel> productList, boolean isDesc) {
        this.nameSortList.clear();
        this.nameSortList.addAll(productList);

        if (nameSortList == null || nameSortList.isEmpty()) {
            throw new IllegalArgumentException("Product list cannot be null or empty.");
        }

        for (int i = 1; i < nameSortList.size(); i++) {
            CrochetModel key = nameSortList.get(i);
            int j = i - 1;

            // Move elements that are greater (or smaller)
            // than the key to one position ahead of their current position
            while (j >= 0 && shouldSwap(key.getProdName(), nameSortList.get(j).getProdName(), isDesc)) {
                nameSortList.set(j + 1, nameSortList.get(j));
                j--;
            }

            nameSortList.set(j + 1, key);
        }

        return nameSortList;
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
