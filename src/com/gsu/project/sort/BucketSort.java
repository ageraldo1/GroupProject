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
import java.util.Arrays;

public class BucketSort {
    
    public static void sort(int[] a, int maxVal) {
        int [] bucket=new int[maxVal+1];
 
        for (int i=0; i<bucket.length; i++) {
            bucket[i]=0;
        }
 
        for (int i=0; i<a.length; i++) {
            bucket[a[i]]++;
        }
 
        int outPos=0;
        for (int i=0; i<bucket.length; i++) {
            for (int j=0; j<bucket[i]; j++) {
                a[outPos++]=i;
            }
        }
    }    
   
    public static void run (int[] a) {
         //System.out.println(Arrays.toString(a));
         sort(a, a.length);
         //System.out.println(Arrays.toString(a));
         
    }
    
    public static void main (String[] args) {
        int maxVal=20;
        int [] data= {5,3,0,2,4,1,0,5,2,3,1,4}; 
 
        System.out.println("Before: " + Arrays.toString(data));
        sort(data,data.length);
        System.out.println("After:  " + Arrays.toString(data));        
    }
    
    
    
}
