/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gsu.project.sort;

/**
 *
 * @author Alexandre
 */
public class InsertionSort {
    
    private void sort(int arr[]) {
        int n = arr.length;
        
        for (int i=1; i<n; ++i) {
            int key = arr[i];
            int j = i-1;
 
            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            while (j>=0 && arr[j] > key) {
                arr[j+1] = arr[j];
                j = j-1;
            }
            
            arr[j+1] = key;
        }
    }
    
    public void run (int[] a) {
        sort(a);
    }    
    
    
}
