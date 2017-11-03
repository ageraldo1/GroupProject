/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package com.gsu.project;

import com.gsu.project.util.CommandLineHandler;

/**
 *
 * @author Alexandre
 */


public class Validator {
    
    
    public static void main (String args[]) {
        
        CommandLineHandler c = new CommandLineHandler();
        
        c.showGroupInfo();

        int[] sortSelection = c.showSortMenu();
        int[] searchSelection = c.showSearchMenu();        
        int numberRandom = c.showRandomMenu();        
        int searchNumber = c.showSearchValueMenu();
        
        c.runSortTesting(sortSelection, numberRandom);
        c.runSearchTesting(searchSelection, searchNumber, true, numberRandom);
        
        c.showMeasurementResults();
    }
        
    
}
