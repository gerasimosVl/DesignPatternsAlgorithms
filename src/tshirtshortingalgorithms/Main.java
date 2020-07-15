/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tshirtshortingalgorithms;

/**
 *
 * @author geras
 */
public class Main {

    public static void main(String[] args) {
        TshirtPrint print = new TshirtPrint();
               
        
        System.out.println("---------------- Size Sorting ----------------");       
        print.bubbleSortBySize(50, 0); 
        print.quickSortBySize(50, 0);
        print.bubbleSortBySize(50, 1); 
        print.quickSortBySize(50, 1); 
        print.bucketSortBySize(50, 0, 2);
                    
       
                
        System.out.println("---------------- Color Sorting ----------------");       
        print.bubbleSortByColor(50, 0);
        print.quickSortByColor(50, 0);
        print.bubbleSortByColor(50, 1);
        print.quickSortByColor(50, 1); 
        print.bucketSortByColor(50, 0, 2);
        
        
        
        System.out.println("---------------- Fabric Sorting ----------------");
        print.bubbleSortByFabric(50, 0);
        print.quickSortByFabric(50, 0);
        print.bubbleSortByFabric(50, 1);
        print.quickSortByFabric(50, 1);
        print.bucketSortByFabric(50, 0, 2);
          
        
    }
    
}
