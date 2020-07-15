/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tshirtshortingalgorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author geras
 */
public class TshirtPrint {
    List<Tshirt> tshirts;
    


    public void printTshirtsColor(List<Tshirt> tshirts) {

        for (Tshirt ts : tshirts) {
            System.out.println("Color: " + ts.getColor());
        }

    }

    public void printTshirtsFabric(List<Tshirt> tshirts) {

        for (Tshirt ts : tshirts) {
            System.out.println("Fabric: " + ts.getFabric());
        }

    }

    public void printTshirtsSize(List<Tshirt> tshirts) {

        for (Tshirt ts : tshirts) {
            System.out.println("Size: " + ts.getSize());
        }

    }

    public List<Tshirt> generateTshirts(int count, int type) {
        List<Tshirt> tshirts = new ArrayList<Tshirt>();

        for (int i = 0; i < count; i++) {
            Tshirt t = new Tshirt();
            t.setColor(randomColor());
            t.setFabric(randomFabric());
            t.setSize(randomSize());
            t.setName(randomName(type));
            tshirts.add(t);
        }
        return tshirts;
    }

    /*
    
    type = 0 -> String concat
    type = 1 -> StringBuilder
    
     */
    public static String randomName(int type) {
        char chars[] = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L',
            'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

        Random random = new Random();
        String s = "";

        switch (type) {
            case 0:

                for (int i = 0; i < 12; i++) {
                    s += chars[random.nextInt(26)];

                }

                break;

            case 1:
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < 12; i++) {
                    sb.append(chars[random.nextInt(26)]);

                }

                s = sb.toString();
                break;
        }
        return s;

    }

    public static Size randomSize() {

        Random random = new Random();

        int choice = random.nextInt(Size.values().length);
        return Size.values()[choice];
    }

    public static Color randomColor() {

        Random random = new Random();

        int choice = random.nextInt(Color.values().length);
        return Color.values()[choice];
    }

    public static Fabric randomFabric() {

        Random random = new Random();

        int choice = random.nextInt(Fabric.values().length);
        return Fabric.values()[choice];
    }

    public static String randomNameWithStringBuilder() {
        char chars[] = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L',
            'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 12; i++) {
            sb.append(chars[random.nextInt(26)]);

        }

        return sb.toString();
    }

    
     
    
    
    /*
    sortMethod = 0, Quick Sort
    sortMethod = 1, Bubble Sort
    sortMethod = 2, Bucket Sort
    
    sortOrder = 0, ASC
    sortOrder = 1, DESC
    
     */
    // Print with BubbleSort //
     public void bubbleSortBySize(int TshirtsNumber, int order) {
        
       
        tshirts = generateTshirts(TshirtsNumber, 1);
        TshirtShort sort = new TshirtShort(tshirts);
        tshirts = sort.sortBySize(1, order, 0);
        
        if (order == 0) {
             System.out.println("\nTshirts bubble sort[ASC] by Size\n");
        }
        else if (order == 1){
        System.out.println("\nTshirts bubble sort[DESC] by Size\n");
        }
        printTshirtsSize(tshirts);
        
    }

    public void bubbleSortByColor(int TshirtsNumber, int order) {
        
        tshirts = generateTshirts(TshirtsNumber, 1);
        TshirtShort sort = new TshirtShort(tshirts);
        tshirts = sort.sortByColor(1, order, 0);
        
        if (order == 0) {
             System.out.println("\nTshirts bubble sort[ASC] by Color\n");
        }
        else if (order == 1){
        System.out.println("\nTshirts bubble sort[DESC] by Color\n");
        }
        printTshirtsColor(tshirts);
    }

    public void bubbleSortByFabric(int TshirtsNumber, int order) {
        
        tshirts = generateTshirts(TshirtsNumber, 1);
        TshirtShort sort = new TshirtShort(tshirts);
        tshirts = sort.sortByFabric(1, order, 0);
        
        if (order == 0) {
             System.out.println("\nTshirts bubble sort[ASC] by Fabric\n");
        }
        else if (order == 1){
        System.out.println("\nTshirts bubble sort[DESC] by Fabric\n");
        }
        printTshirtsFabric(tshirts);
    }

    
    // Print with QuickSort  //    
    public void quickSortBySize(int TshirtsNumber, int order) {
        
         tshirts = generateTshirts(TshirtsNumber, 1);
        TshirtShort sort = new TshirtShort(tshirts);
        tshirts = sort.sortBySize(0, order, 0);
        
        if (order == 0) {
             System.out.println("\nTshirts quick sort[ASC] by Size\n");
        }
        else if (order == 1){
        System.out.println("\nTshirts quick sort[DESC] by Size\n");
        }
        printTshirtsSize(tshirts);
    }

    public void quickSortByColor(int TshirtsNumber, int order) {
        
        tshirts = generateTshirts(TshirtsNumber, 1);
        TshirtShort sort = new TshirtShort(tshirts);
        tshirts = sort.sortByColor(0, order, 0);
        
        if (order == 0) {
             System.out.println("\nTshirts quick sort[ASC] by Color\n");
        }
        else if (order == 1){
        System.out.println("\nTshirts quick sort[DESC] by Color\n");
        }
        printTshirtsColor(tshirts);
    }

    public void quickSortByFabric(int TshirtsNumber, int order) {
        
         tshirts = generateTshirts(TshirtsNumber, 1);
        TshirtShort sort = new TshirtShort(tshirts);
        tshirts = sort.sortByFabric(0, order, 0);
        
        if (order == 0) {
             System.out.println("\nTshirts quick sort[ASC] by Fabric\n");
        }
        else if (order == 1){
        System.out.println("\nTshirts quick sort[DESC] by Fabric\n");
        }
        printTshirtsFabric(tshirts);
    }

    
    // Print with BucketSort //    
    public void bucketSortBySize(int TshirtsNumber, int order, int buckets) {
        
        tshirts = generateTshirts(TshirtsNumber, 1);
        TshirtShort sort = new TshirtShort(tshirts);
        tshirts = sort.sortBySize(2, order, buckets);
        
        if (order == 0) {
             System.out.println("\nTshirts bucket sort[ASC] by Size\n");
        }
        else if (order == 1){
        System.out.println("\nTshirts bucket sort[DESC] by Size\n");
        }
        printTshirtsSize(tshirts);
        
    }

    public void bucketSortByColor(int TshirtsNumber, int order, int buckets) {
        
        tshirts = generateTshirts(TshirtsNumber, 1);
        TshirtShort sort = new TshirtShort(tshirts);
        tshirts = sort.sortByColor(2, order, buckets);
        
        if (order == 0) {
             System.out.println("\nTshirts bucket sort[ASC] by Color\n");
        }
        else if (order == 1){
        System.out.println("\nTshirts bucket sort[DESC] by Color\n");
        }
        printTshirtsColor(tshirts);
    }

    public void bucketSortByFabric(int TshirtsNumber, int order, int buckets) {
        
        tshirts = generateTshirts(TshirtsNumber, 1);
        TshirtShort sort = new TshirtShort(tshirts);
        tshirts = sort.sortByFabric(2, order, buckets);
        
        if (order == 0) {
             System.out.println("\nTshirts bucket sort[ASC] by Fabric\n");
        }
        else if (order == 1){
        System.out.println("\nTshirts bucket sort[DESC] by Fabric\n");
        }
        printTshirtsFabric(tshirts);
    }
}
