/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gsu.project;

/**
 *
 * @author Alexandre
 */


import java.util.Random;

public class BogoSort{
    
    private static final Random generator = new Random();  
    
    public static void bogoSort(int[] array)  {
        while (!isSorted(array)) {
            for (int i = 0; i < array.length; i++) {                
                int randomPosition = generator.nextInt(array.length);  
                int temp = array[i];  
                array[i] = array[randomPosition];  
                array[randomPosition] = temp;  
            }  
        }  
    }    
    
    private static boolean isSorted(int[] array)  {
        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[i - 1]) {
                return false;  
            }
        }
        
        return true;  
    }  
    
    public void run(int[] a) {
        bogoSort(a);
    }    
    
}



/*
public class BogoSort {
        // https://rosettacode.org/wiki/Sorting_algorithms/Bogosort#Java

	public static void main(String[] args)
	{
		//Enter array to be sorted here
		int[] arr={4,5,6,0,7,8,9,1,2,3};
 
		BogoSort now=new BogoSort();
		System.out.print("Unsorted: ");
		now.display1D(arr);
 
		now.bogo(arr);
 
		System.out.print("Sorted: ");
		now.display1D(arr);
	}
        
        public static void run (int[] array) {
            BogoSort s =new BogoSort();
            
            s.bogo (array);
            
        }
        
        
	void bogo(int[] arr)
	{
		//Keep a track of the number of shuffles
		int shuffle=1;
		for(;!isSorted(arr);shuffle++)
			shuffle(arr);
		//Boast
		//System.out.println("This took "+shuffle+" shuffles.");
	}
	void shuffle(int[] arr)
	{
		//Standard Fisher-Yates shuffle algorithm
		int i=arr.length-1;
		while(i>0)
			swap(arr,i--,(int)(Math.random()*i));
	}
	void swap(int[] arr,int i,int j)
	{
		int temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}
	boolean isSorted(int[] arr)
	{
 
		for(int i=1;i<arr.length;i++)
			if(arr[i]<arr[i-1])
				return false;
		return true;
	}
	void display1D(int[] arr)
	{
		for(int i=0;i<arr.length;i++)
			System.out.print(arr[i]+" ");
		System.out.println();
	}
 
}
*/

