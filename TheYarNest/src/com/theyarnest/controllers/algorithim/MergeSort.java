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
public class MergeSort {
    List<CrochetModel> priceSortList;
    
    public MergeSort(){
        priceSortList = new LinkedList<>();
    }
    
    
        /**
     * Sorts a list of CrochetModel objects by their price in ascending or
     * descending order using the merge sort algorithm.
     *
     * @param productList the list of CrochetModel objects is sorted according to their prices
     * @param isDesc specifies the sort order (true for descending, false for
     * ascending)
     * @return the sorted list
     */
    public List<CrochetModel> sortByPrice(List<CrochetModel> productList, boolean isDesc) {
        if (productList == null || productList.isEmpty()) {
            throw new IllegalArgumentException("Product list cannot be null or empty.");
        }

        this.priceSortList = new LinkedList<>(productList);
        mergeSort(0, priceSortList.size() - 1, isDesc);
        return priceSortList;
    }

    /**
     * Recursively divides and merges the list for sorting.
     *
     * @param left the starting index
     * @param right the ending index
     * @param isDesc specifies the sort order (true for descending, false for ascending)
     */
    private void mergeSort(int left, int right, boolean isDesc) {
        if (left < right) {
            int mid = left + (right - left) / 2;

            mergeSort(left, mid, isDesc);
            mergeSort(mid + 1, right, isDesc);
            merge(left, mid, right, isDesc);
        }
    }

    /**
     * Merges two lists into a sorted list.
     *
     * @param left the starting index of the left list
     * @param mid the ending index of the left list
     * @param right the ending index of the right list
     * @param isDesc specifies the sort order (true for descending, false for ascending)
     */
    private void merge(int left, int mid, int right, boolean isDesc) {
        List<CrochetModel> tempList = new LinkedList<>();

        int i = left, j = mid + 1;

        while (i <= mid && j <= right) {
            if (shouldSwap(priceSortList.get(j).getPrice(), 
                    priceSortList.get(i).getPrice(), isDesc)) {
                tempList.add(priceSortList.get(j));
                j++;
            } else {
                tempList.add(priceSortList.get(i));
                i++;
            }
        }

        while (i <= mid) {
            tempList.add(priceSortList.get(i));
            i++;
        }

        while (j <= right) {
            tempList.add(priceSortList.get(j));
            j++;
        }

        for (int k = 0; k < tempList.size(); k++) {
            priceSortList.set(left + k, tempList.get(k));
        }
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
    private boolean shouldSwap(double current, double extremum, boolean isDesc) {
        return isDesc ? current > extremum : current < extremum;
    }
}
