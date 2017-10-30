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
import java.util.LinkedHashMap;
import java.util.Date;
import java.lang.reflect.Method;
import java.util.Collection;


public class Validator {
    
    private static HashMap sortPerfCounter = new LinkedHashMap();
    private static HashMap searchPerfCounter = new LinkedHashMap();
    
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
        System.out.println ("\t\tSidney Williams");
        System.out.println ("\n");
        System.out.println ("***************************************************************************");
        
        System.out.println("Press Enter key to continue...");
        
        try {
            System.in.read();
        } catch(IOException e)   {}          
    }
    
    private static int[] showSortMenu() {
        final int MIN_SELECTION = 3;
        
        String selection;
        String[] sMap;
        int[] result = new int [MIN_SELECTION];
        
        boolean valid = false;
        Scanner input = new Scanner(System.in);

        System.out.println("+--------------------------------------+");
        System.out.println("Choose THREE  Sorting Algorithms below");        
        System.out.println("+--------------------------------------+");
        System.out.println("\t[1] Bogo");
        System.out.println("\t[2] Bubble");
        System.out.println("\t[3] Bucket");
        
        System.out.println();
        
        do {
            System.out.print ("Your selection []....: ");
            
            selection = input.next();
            sMap = selection.split(",");
            
            if ( sMap.length == MIN_SELECTION) {
                try {
                    result[0] = Integer.parseInt(sMap[0]);
                    result[1] = Integer.parseInt(sMap[1]);
                    result[2] = Integer.parseInt(sMap[2]);
                    
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
        
        final int MIN_RANDOM_INT=10;
        
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
                    
                    if ( result >= MIN_RANDOM_INT) {
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
        final String methodName = "run";
        
        
        System.out.println ("Running Sorting algorithms testing....");
        
        for ( int i = 0; i < sortSelection.length; i++ ) {
            if ( sortSelection[i] == 1) {
                className = "com.gsu.project.BogoSort";
                
            } else if ( sortSelection[i] == 2) {
                className = "com.gsu.project.BubbleSort";
                
            } else if ( sortSelection[i] == 3) {
                className = "com.gsu.project.BucketSort";
            }
            
            a = ArrayUtil.randomIntArray(numberRandom, numberRandom);
            System.out.println ("Running " + className + "....");
            
            if ( runMethod(className, methodName, a) == false ) {
                System.out.println ("Error running performance testing for class " + className);
            }
        }
    }
    
    private static void showMeasurementResults() {
        
        System.out.println ("+--------------------------------------------------------+");
        System.out.println ("Performance results");
        System.out.println ("+--------------------------------------------------------+");
        System.out.println ("\tSort algorithm(s)");
        
        Collection<?> keys = sortPerfCounter.keySet();
        
        for ( Object key: keys) {
            System.out.println ("\t\tAlgorithm........:" + key);
            System.out.println ("\t\tTime taken(ms)...:" + sortPerfCounter.get(key));
            System.out.println ();
        }
        
        System.out.println ("\tFastest sort Algorithm...:" + getPerformanceRecord(sortPerfCounter, "b"));
        System.out.println ("\tSlowest sort Algorithm...:" + getPerformanceRecord(sortPerfCounter, "w"));
        
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
            e.printStackTrace();
            flag = false;
            
        }
        
        return flag;                
    }
    

    private static HashMap getPerformanceRecord (HashMap m, String order) {
        HashMap result = new HashMap();
        
        String mapKey="";
        long mapValue=0;

        Collection<?> keys = m.keySet();
        
        for ( Object key: keys) {            
            if ( mapKey.length() == 0 ) {
                mapKey = (String)key;
                mapValue = (long)m.get(key);
                
            } else {
                if ( order.equals("w")) {
                    if ( (long)m.get(key) > mapValue ) {
                        mapKey = (String)key;
                        mapValue = (long)m.get(key);                    
                    }                    
                } else if ( order.equals("b")) {
                    if ( (long)m.get(key) < mapValue ) {
                        mapKey = (String)key;
                        mapValue = (long)m.get(key);                    
                    }                    
                }
            }                
        }        
        
        result.put (mapKey, mapValue);
        
        return result;
        
    }
    
}
