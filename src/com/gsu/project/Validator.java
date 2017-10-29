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

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Date;
import java.lang.reflect.Method;


public class Validator {
    
    private static HashMap sortPerfCounter = new HashMap();
    
    public static void main (String args[]) {
        showGroupInfo();

        int[] sortSelection = showSortMenu();
        int numberRandom = showRandomMenu();        
        
        runSortTesting(sortSelection, numberRandom);
        
        showMeasurementResults();
    }
    
    
    private static void showGroupInfo() {
        System.out.println ("***************************************************************************");
        System.out.println ("CSCI 1302: Principles of Computer Science I - Fall 2017");
        System.out.println ("Group Project\n");
        System.out.println ("\t\tAlexandre Geraldo");
        System.out.println ("\t\tSidney William");
        System.out.println ("\n");
        System.out.println ("***************************************************************************");
        
        System.out.println("Press Enter key to continue...");
        
        try {
            System.in.read();
        } catch(IOException e)   {}          
    }
    
    private static int[] showSortMenu() {
        String selection;
        String[] sMap;
        int[] result = new int [2];
        
        boolean valid = false;
        Scanner input = new Scanner(System.in);

        System.out.println("+--------------------------------------+");
        System.out.println("Choose TWO Sorting Algorithms below");        
        System.out.println("+--------------------------------------+");
        System.out.println("[1]....Bogo");
        System.out.println("[2]....Bubble");
        
        do {
            System.out.print ("Your selection [option1, option2]....: ");
            
            selection = input.next();
            sMap = selection.split(",");
            
            if ( sMap.length == 2) {
                try {
                    result[0] = Integer.parseInt(sMap[0]);
                    result[1] = Integer.parseInt(sMap[1]);
                    
                    valid = true;
                } catch (NumberFormatException e ) {
                    System.out.println ("Selection invalid !");
                }
                
            } else { 
                System.out.println ("Selection invalid !");
            }
            
        } while ( valid == false);
        
        return result;
    }
    
    private static int showRandomMenu()  {
        String selection;
        int result = 100000;
        
        boolean valid = false;
        Scanner input = new Scanner(System.in);

        System.out.println("+-------------------------------------------+");
        System.out.println("Enter the number of random integer number");        
        System.out.println("+-------------------------------------------+");
        
        do {
            System.out.print ("Your selection [default = 100000]....: ");
            
            selection = input.next();
            
            if ( selection.length() == 0 ) {
                valid = true;
            } else { 
                try {
                    result = Integer.parseInt(selection);
                    
                    if ( result >= 100000) {
                        valid = true;
                    } else { 
                        System.out.println ("Number of random integers must be greater or equals to 100000");    
                    }
                } catch (NumberFormatException e ) {
                    System.out.println ("Selection invalid !");
                }                
            }            
        } while ( valid == false);
        
        return result;
        
    }
    
    private static void runSortTesting(int[] sortSelection, int numberRandom) {        

        int[] a;
        String className="";
        
        System.out.println ("Running Sorting algorithms testing....");
        
        for ( int i = 0; i < sortSelection.length; i++ ) {
            if ( sortSelection[i] == 1) {
                className = "com.gsu.project.BogoSort";
                
            } else if ( sortSelection[i] == 2) {
                className = "com.gsu.project.BubbleSort";
            }
            
            a = ArrayUtil.randomIntArray(numberRandom, numberRandom);
            System.out.println ("Running " + className + "....");
            
            if ( runMethod("com.gsu.project.BogoSort", "run", a) == false ) {
                System.out.println ("Error running performance testing for class " + className);
            }
        }
    }
    
    private static void showMeasurementResults() {
        System.out.println (sortPerfCounter);
    }
    
    private static boolean runMethod(String className, String methodName, int[] a) {
        
        Class c;
        Method m;
        boolean flag = true;
        Date start;
        Date end;
        
        try {
            c = Class.forName(className);
            m = c.getDeclaredMethod(methodName, new Class[] { int[].class});
            
            start = new java.util.Date();
                m.invoke(c.newInstance(), new Object[]{a});
            end = new java.util.Date();
            
            sortPerfCounter.put (className, end.getTime() - start.getTime());
            
        } catch (ClassNotFoundException | IllegalAccessException | IllegalArgumentException | InstantiationException | NoSuchMethodException | SecurityException | InvocationTargetException e) {
            flag = false;
            
        }
        
        return flag;                
    }
    
    
}
