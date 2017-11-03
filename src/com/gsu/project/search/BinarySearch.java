/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.

http://www.geeksforgeeks.org/bucket-sort-2/

 */
package com.gsu.project.search;

/**
 *
 * @author Alexandre
 */
public class BinarySearch {
    
    private int binarySearch(int[] a, int target) {
        int min = 0;
        int max = a.length - 1;

        while (min <= max) {
            int mid = (min + max) / 2;
        
            if (a[mid] < target) {
                min = mid + 1;
            } else if (a[mid] > target) {
                max = mid - 1;
            } else {
                return mid;   // target found
            }
        }

        return -(min + 1);    // target not found
    }
    
    public int run (int[] a, int searchValue) {
        return binarySearch(a, searchValue);
    }

}
