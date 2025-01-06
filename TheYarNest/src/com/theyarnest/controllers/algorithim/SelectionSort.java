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
    List<CrochetModel> idSortList;

    
    public SelectionSort(){
        idSortList = new LinkedList<>();
    }
    /**
     * Sorts a list of CrochetModel objects by their ID in ascending or
     * descending order.
     *
     * @param productList the list of CrochetModel objects to be sorted
     * @param isDesc specifies the sort order (true for descending, false for
     * ascending)
     * @return the sorted list
     */
    public List<CrochetModel> sortById(List<CrochetModel> productList, boolean isDesc) {
        this.idSortList.clear();
        this.idSortList.addAll(productList);
        if (idSortList == null || idSortList.isEmpty()) {
            throw new IllegalArgumentException("Product list cannot be null or empty.");
        }

        for (int i = 0; i < idSortList.size() - 1; i++) {
            int extremumIndex = findExtremumIndex(idSortList, i, isDesc);
            if (i != extremumIndex) {
                swap(idSortList, i, extremumIndex);
            }
        }

        return idSortList;
    }

    /**
     * Finds the index of the extremum value (minimum or maximum) in the list
     * from the start index.
     *
     * @param idSortList the list of CrochetModel objects
     * @param startIndex the index to start searching from
     * @param isDesc specifies whether to find the maximum (true) or minimum
     * (false)
     * @return the index of the extremum value
     */
    private int findExtremumIndex(List<CrochetModel> idSortList, int startIndex, boolean isDesc) {
        int extremumIndex = startIndex;

        for (int j = startIndex + 1; j < idSortList.size(); j++) {
            if (shouldSwap(idSortList.get(j).getProdId(), idSortList.get(extremumIndex).getProdId(), isDesc)) {
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
     * @param idSortList the list of CrochetModel objects
     * @param i the index of the first element
     * @param j the index of the second element
     */
    private void swap(List<CrochetModel> idSortList, int i, int j) {
        CrochetModel temp = idSortList.get(i);
        idSortList.set(i, idSortList.get(j));
        idSortList.set(j, temp);
    }

}
