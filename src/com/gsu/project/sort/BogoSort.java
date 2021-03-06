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


public class BogoSort{
    
    private void bogoSort(int[] a) {
        while (!isSorted(a)) {
            shuffle(a);
        } 
    }
    
    private boolean isSorted(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] > a[i + 1]) {
                return false;
            }        
        }
        
        return true;
    }
    
    private void shuffle(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            // pick a random index in [i+1, a.length-1]
            int range = a.length - 1 - (i + 1) + 1;
            int j = (int) (Math.random() * range + (i + 1));
            swap(a, i, j);
        }
    }
    
    private void swap(int[] a, int i, int j) {
        if (i != j) {
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }
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

