/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gsu.project.util;

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
import java.util.Arrays;
import java.util.Collection;
import java.util.Random;


public class CommandLineHandler {
    
    private final int MIN_RANDOM_INT = 100000;
    private final HashMap sortPerfCounter = new HashMap();
    private final HashMap searchPerfCounter = new HashMap();
    
    
    public void showGroupInfo() {
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
    
    public int[] showSortMenu() {
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
        System.out.println("\t[4] Insertion");
        
        
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
    
    public int[] showSearchMenu() {
        final int MIN_SELECTION = 2;
        
        String selection;
        String[] sMap;
        int[] result = new int [MIN_SELECTION];
        
        boolean valid = false;
        Scanner input = new Scanner(System.in);

        System.out.println("+--------------------------------------+");
        System.out.println("Choose TWO Searching Algorithms below");        
        System.out.println("+--------------------------------------+");
        System.out.println("\t[1] Binary Search");
        System.out.println("\t[2] Linear Search");
        System.out.println("\t[3] Jump Search");
        
        System.out.println();
        
        do {
            System.out.print ("Your selection []....: ");
            
            selection = input.next();
            sMap = selection.split(",");
            
            if ( sMap.length == MIN_SELECTION) {
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
    
    public int showRandomMenu()  {
        String selection;
        int result = 0;
        
        boolean valid = false;
        Scanner input = new Scanner(System.in);

        System.out.println("+--------------------------------------------------------------+");
        System.out.println("Additional Parameters");        
        System.out.println("+--------------------------------------------------------------+");
        System.out.println("a) Enter the number of elements of the random array of integers"); 
        
        do {
            System.out.print ("\tYour selection [minimum of " + MIN_RANDOM_INT + " element(s)]....: ");
            
            selection = input.next();
            
            if ( selection.length() == 0 ) {
                valid = true;
            } else { 
                try {
                    result = Integer.parseInt(selection);
                    
                    if ( result >= MIN_RANDOM_INT) {
                        valid = true;
                    } else { 
                        System.out.println ("\tNumber of random integers must be greater or equals to " + MIN_RANDOM_INT);    
                    }
                } catch (NumberFormatException e ) {
                    System.out.println ("\tSelection invalid !");
                }                
            }            
        } while ( valid == false);
        
        return result;
        
    }
    
    public int showSearchValueMenu() {
        String selection;
        int result = 0;
        
        boolean valid = false;
        Scanner input = new Scanner(System.in);

        System.out.println("b) Enter the number value to be seached into the array or type r for a random number");        
        
        do {
            System.out.print ("\tYour selection []....: ");
            
            selection = input.next();
            
            if ( selection.equals("r")) {
                Random randomGenerator = new Random();
                result = randomGenerator.nextInt(MIN_RANDOM_INT);
                
                valid = true;
                
            } else {
                try {
                    result = Integer.parseInt(selection);
                    valid = true;
                    
                } catch (NumberFormatException e ) {
                    System.out.println ("\tSelection invalid !");
                }       
            }
        } while ( valid == false);
        
        System.out.println ("\tSearching for the number value...: " + result);
        System.out.println("+--------------------------------------------------------------+");
        return result;
        
        
    }
    
    public void runSortTesting(int[] sortSelection, int numberRandom) {        

        int[] a;
        String className="";
        final String methodName = "run";
        
        
        System.out.println ("Running Sorting algorithms testing....");
        
        for ( int i = 0; i < sortSelection.length; i++ ) {
            switch (sortSelection[i]) {
                case 1:
                    className = "com.gsu.project.sort.BogoSort";
                    break;
                    
                case 2:
                    className = "com.gsu.project.sort.BubbleSort";
                    break;
                    
                case 3:
                    className = "com.gsu.project.sort.BucketSort";
                    break;

                case 4:
                    className = "com.gsu.project.sort.InsertionSort";
                    break;
                    
                default:
                    break;
            }
            
            a = ArrayUtil.randomIntArray(numberRandom, numberRandom);
            System.out.println ("Running " + className + "....");
            
            if ( runMethod(className, methodName, a) == false ) {
                System.out.println ("Error running performance testing for class " + className);
            }
        }
    }
    
    public void runSearchTesting(int[] searchSelection, int searchValue, boolean mustBeSorted, int arraySize) {

        int[] a;
        String className="";
        final String methodName = "run";
        
        System.out.println ("Running Searching algorithms testing....");
        
        for ( int i = 0; i < searchSelection.length; i++ ) {
            
            switch (searchSelection[i]) {
                case 1:
                    className = "com.gsu.project.search.BinarySearch";
                    break;                    

                case 2:
                    className = "com.gsu.project.search.LinearSearch";
                    break;                    
                    
                case 3:
                    className = "com.gsu.project.search.JumpSearch";
                    break;                    
                    
                default:
                    break;
            }
            
            a = ArrayUtil.randomIntArray(arraySize, arraySize);
            
            if ( mustBeSorted == true ) {
                Arrays.sort(a);
            }
            
            System.out.println ("Running " + className + "....");
            
            if ( runMethod(className, methodName, a, searchValue ) == -1 ) {
                System.out.println ("\tElement not found on the array");
            } else {
                System.out.println ("\tElement was found on the array");                
            }
        }
        
        
    }
    
    public void showMeasurementResults() {
        
        Collection<?> keys;
        
        System.out.println ("+--------------------------------------------------------+");
        System.out.println ("Performance results");
        System.out.println ("+--------------------------------------------------------+");
        System.out.println ("\tSort algorithm(s)");
        
        keys = sortPerfCounter.keySet();
        
        for ( Object key: keys) {
            System.out.println ("\t\tAlgorithm........:" + key);
            System.out.println ("\t\tTime taken(ms)...:" + sortPerfCounter.get(key));
            System.out.println ();
        }
        
        System.out.println ("\tFastest sort Algorithm...:" + getPerformanceRecord(sortPerfCounter, "b"));
        System.out.println ("\tSlowest sort Algorithm...:" + getPerformanceRecord(sortPerfCounter, "w"));
        
        System.out.println ("\n\tSearch algorithm(s)");
        
        keys = searchPerfCounter.keySet();
        
        for ( Object key: keys) {
            System.out.println ("\t\tAlgorithm........:" + key);
            System.out.println ("\t\tTime taken(ms)...:" + searchPerfCounter.get(key));
            System.out.println ();
        }
        
        System.out.println ("\tFastest search Algorithm...:" + getPerformanceRecord(searchPerfCounter, "b"));
        System.out.println ("\tSlowest search Algorithm...:" + getPerformanceRecord(searchPerfCounter, "w"));
        
        
    }
    
    public boolean runMethod(String className, String methodName, int[] a) {
        
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

    public int runMethod(String className, String methodName, int[] a, int value) {
        
        Class c;
        Method m;
        Date start;
        Date end;
        int retCode;
        
        try {
            c = Class.forName(className);
            m = c.getDeclaredMethod(methodName, new Class[] { int[].class, int.class} );            
            
            start = new java.util.Date();
                retCode = (int)m.invoke(c.newInstance(), new Object[]{a, value});
                
            end = new java.util.Date();
            
            searchPerfCounter.put (className, end.getTime() - start.getTime());
            
        } catch (ClassNotFoundException | IllegalAccessException | IllegalArgumentException | InstantiationException | NoSuchMethodException | SecurityException | InvocationTargetException e) {
            e.printStackTrace();
            retCode = -1;
            
        }
        
        return retCode;                
    }
    
    public HashMap getPerformanceRecord (HashMap m, String order) {
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
