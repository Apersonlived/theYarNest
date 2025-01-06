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
public class SelectionSort {
    List<CrochetModel> stockSortList;

    
    public SelectionSort(){
        stockSortList = new LinkedList<>();
    }
    /**
     * Sorts a list of CrochetModel objects by their stock in ascending or
     * descending order.
     *
     * @param productList the list of CrochetModel objects to be sorted
     * @param isDesc specifies the sort order (true for descending, false for
     * ascending)
     * @return the sorted list
     */
    public List<CrochetModel> sortByStock(List<CrochetModel> productList, boolean isDesc) {
        this.stockSortList.clear();
        this.stockSortList.addAll(productList);
        if (stockSortList == null || stockSortList.isEmpty()) {
            throw new IllegalArgumentException("Product list cannot be null or empty.");
        }

        for (int i = 0; i < stockSortList.size() - 1; i++) {
            int extremumIndex = findExtremumIndex(stockSortList, i, isDesc);
            if (i != extremumIndex) {
                swap(stockSortList, i, extremumIndex);
            }
        }

        return stockSortList;
    }

    /**
     * Finds the index of the extremum value (minimum or maximum) in the list
     * from the start index.
     *
     * @param stockSortList the list of CrochetModel objects
     * @param startIndex the index to start searching from
     * @param isDesc specifies whether to find the maximum (true) or minimum
     * (false)
     * @return the index of the extremum value
     */
    private int findExtremumIndex(List<CrochetModel> stockSortList, int startIndex, 
            boolean isDesc) {
        int extremumIndex = startIndex;

        for (int j = startIndex + 1; j < stockSortList.size(); j++) {
            if (shouldSwap(stockSortList.get(j).getStock(), 
                    stockSortList.get(extremumIndex).getStock(), isDesc)) {
                extremumIndex = j;
            }
        }

        return extremumIndex;
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
    private boolean shouldSwap(int current, int extremum, boolean isDesc) {
        return isDesc ? current > extremum : current < extremum;
    }

    /**
     * Swaps two elements in the list.
     *
     * @param stockSortList the list of CrochetModel objects
     * @param i the index of the first element
     * @param j the index of the second element
     */
    private void swap(List<CrochetModel> stockSortList, int i, int j) {
        CrochetModel temp = stockSortList.get(i);
        stockSortList.set(i, stockSortList.get(j));
        stockSortList.set(j, temp);
    }

}
