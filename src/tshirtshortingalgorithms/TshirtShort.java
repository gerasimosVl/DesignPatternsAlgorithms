/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tshirtshortingalgorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author geras
 */
public class TshirtShort {
    private List<Tshirt> tshirts;

    public TshirtShort(List<Tshirt> shirts) {
        this.tshirts = new ArrayList<Tshirt>(shirts);
    }

    public List<Tshirt> getTshirts() {
        return tshirts;
    }

    public void setTshirts(List<Tshirt> tshirts) {
        this.tshirts = tshirts;
    }

    /*
    sortMethod = 0, Quick Sort
    sortMethod = 1, Bubble Sort
    sortMethod = 2, Bucket Sort
    
    sortOrder = 0, ASC
    sortOrder = 1, DESC
    
     */
     List<Tshirt> sortBySize(int sortMethod, int sortOrder, int buckets) {
        List<Tshirt> shirts = new ArrayList();
        shirts = this.tshirts;
        switch (sortMethod) {
            case 0:
                shirts = quickSortBySize(0, shirts.size() - 1, sortOrder);
                break;
            case 1:
                shirts = bubbleSortBySize(sortOrder);
                break;
            case 2:
                shirts = bucketSort(sortOrder, buckets);
                break;

        }
        return shirts;

    }

    /*
    sortMethod = 0, Quick Sort
    sortMethod = 1, Bubble Sort
    sortMethod = 2, Bucket Sort
    
    sortOrder = 0, ASC
    sortOrder = 1, DESC
    
     */
    public List<Tshirt> sortByColor(int sortMethod, int sortOrder, int buckets) {
        List<Tshirt> shirts = new ArrayList();
        shirts = this.tshirts;
        switch (sortMethod) {
            case 0:
                shirts = quickSortByColor(0, shirts.size() - 1, sortOrder);

                break;
            case 1:
                shirts = bubbleSortByColor(sortOrder);
                break;
            case 2:
                shirts = bucketSort(sortOrder, buckets);
                break;

        }
        return shirts;

    }

    /*
    sortMethod = 0, Quick Sort
    sortMethod = 1, Bubble Sort
    sortMethod = 2, Bucket Sort
    
    sortOrder = 0, ASC
    sortOrder = 1, DESC
    
     */
    public List<Tshirt> sortByFabric(int sortMethod, int sortOrder, int buckets) {
        List<Tshirt> shirts = new ArrayList();
        shirts = this.tshirts;
        switch (sortMethod) {
            case 0:
                shirts = quickSortByFabric(0, shirts.size() - 1, sortOrder);

                break;
            case 1:
                shirts = bubbleSortByFabric(sortOrder);

                break;
            case 2:
                shirts = bucketSort(sortOrder, buckets);
                break;

        }
        return shirts;
    }

    private List<Tshirt> bubbleSortBySize(int type) {
        int n = tshirts.size();
        List<Tshirt> tempList = tshirts;
        switch (type) {
            //asc
            case 0:

                for (int i = 0; i < n - 1; i++) {
                    for (int j = 0; j < n - i - 1; j++) {
                        if (tempList.get(j).getSize().ordinal()
                                > tempList.get(j + 1).getSize().ordinal()) {
                            // swap arr[j+1] and arr[i] 
                            Tshirt tempShirt = tempList.get(j);
                            tempList.set(j, tempList.get(j + 1));
                            tempList.set(j + 1, tempShirt);
                        }
                    }
                }
                break;

            //desc
            case 1:

                for (int i = 0; i < n - 1; i++) {
                    for (int j = 0; j < n - i - 1; j++) {
                        if (tempList.get(j).getSize().ordinal()
                                < tempList.get(j + 1).getSize().ordinal()) {
                            // swap arr[j+1] and arr[i] 
                            Tshirt tempShirt = tempList.get(j);
                            tempList.set(j, tempList.get(j + 1));
                            tempList.set(j + 1, tempShirt);
                        }
                    }
                }

                break;

        }

        return tempList;
    }
    
    List<Tshirt> quickSortByFabric(int low, int high, int sortOrder) {
        List<Tshirt> arr = this.tshirts;
        List<Tshirt> arr2 = arr;
        if (low < high) {
            /* pi is partitioning index, arr[pi] is  
              now at right place */
            int pi = quickPartitionFabric(arr2, low, high, sortOrder);

            // Recursively sort elements before 
            // partition and after partition 
            quickSortByFabric(low, pi - 1, sortOrder);
            quickSortByFabric(pi + 1, high, sortOrder);
        }

        return arr2;
    }

    List<Tshirt> quickSortByColor(int low, int high, int sortOrder) {
        List<Tshirt> arr = this.tshirts;
        List<Tshirt> arr2 = arr;
        if (low < high) {
            /* pi is partitioning index, arr[pi] is  
              now at right place */
            int pi = quickPartitionColor(arr2, low, high, sortOrder);

            // Recursively sort elements before 
            // partition and after partition 
            quickSortByColor(low, pi - 1, sortOrder);
            quickSortByColor(pi + 1, high, sortOrder);
        }

        return arr2;
    }

    List<Tshirt> quickSortBySize(int low, int high, int sortOrder) {
        List<Tshirt> arr = this.tshirts;
        List<Tshirt> arr2 = arr;
        if (low < high) {
            /* pi is partitioning index, arr[pi] is  
              now at right place */
            int pi = quickPartitionSize(arr2, low, high, sortOrder);

            // Recursively sort elements before 
            // partition and after partition 
            quickSortBySize(low, pi - 1, sortOrder);
            quickSortBySize(pi + 1, high, sortOrder);
        }

        return arr2;
    }

    private int quickPartitionSize(List<Tshirt> arr, int low, int high, int sortOrder) {
        Tshirt pivot = arr.get(high);
        int i = (low - 1); // index of smaller element
        for (int j = low; j < high; j++) {
            if (sortOrder == 0) // If current element is smaller than the pivot
            {
                if (arr.get(j).getSize().ordinal() < pivot.getSize().ordinal()) {
                    i++;
                    // swap arr[i] and arr[j]
                    Tshirt temp = arr.get(i);
                    arr.set(i, arr.get(j));
                    arr.set(j, temp);
                }
            } else {
                if (arr.get(j).getSize().ordinal() > pivot.getSize().ordinal()) {
                    i++;
                    // swap arr[i] and arr[j]
                    Tshirt temp = arr.get(i);
                    arr.set(i, arr.get(j));
                    arr.set(j, temp);
                }
            }
        }
        // swap arr[i+1] and arr[high] (or pivot)
        Tshirt temp = arr.get(i + 1);
        arr.set(i + 1, arr.get(high));
        arr.set(high, temp);
        return i + 1;
    }

    private List<Tshirt> bubbleSortByColor(int type) {
        int n = tshirts.size();
        List<Tshirt> tempList = tshirts;
        switch (type) {
            //asc
            case 0:

                for (int i = 0; i < n - 1; i++) {
                    for (int j = 0; j < n - i - 1; j++) {
                        if (tempList.get(j).getColor().ordinal()
                                > tempList.get(j + 1).getColor().ordinal()) {
                            // swap arr[j+1] and arr[i] 
                            Tshirt tempShirt = tempList.get(j);
                            tempList.set(j, tempList.get(j + 1));
                            tempList.set(j + 1, tempShirt);
                        }
                    }
                }
                break;

            //desc
            case 1:

                for (int i = 0; i < n - 1; i++) {
                    for (int j = 0; j < n - i - 1; j++) {
                        if (tempList.get(j).getColor().ordinal()
                                < tempList.get(j + 1).getColor().ordinal()) {
                            // swap arr[j+1] and arr[i] 
                            Tshirt tempShirt = tempList.get(j);
                            tempList.set(j, tempList.get(j + 1));
                            tempList.set(j + 1, tempShirt);
                        }
                    }
                }

                break;

        }

        return tempList;
    }
    
    
     private List<Tshirt> bubbleSortByFabric(int type) {
        int n = tshirts.size();
        List<Tshirt> tempList = tshirts;
        switch (type) {
            //asc
            case 0:

                for (int i = 0; i < n - 1; i++) {
                    for (int j = 0; j < n - i - 1; j++) {
                        if (tempList.get(j).getFabric().ordinal()
                                > tempList.get(j + 1).getFabric().ordinal()) {
                            // swap arr[j+1] and arr[i] 
                            Tshirt tempShirt = tempList.get(j);
                            tempList.set(j, tempList.get(j + 1));
                            tempList.set(j + 1, tempShirt);
                        }
                    }
                }
                break;

            //desc
            case 1:

                for (int i = 0; i < n - 1; i++) {
                    for (int j = 0; j < n - i - 1; j++) {
                        if (tempList.get(j).getFabric().ordinal()
                                < tempList.get(j + 1).getFabric().ordinal()) {
                            // swap arr[j+1] and arr[i] 
                            Tshirt tempShirt = tempList.get(j);
                            tempList.set(j, tempList.get(j + 1));
                            tempList.set(j + 1, tempShirt);
                        }
                    }
                }

                break;

        }

        return tempList;
    }

    private int quickPartitionColor(List<Tshirt> arr, int low, int high, int sortOrder) {
        Tshirt pivot = arr.get(high);
        int i = (low - 1); // index of smaller element
        for (int j = low; j < high; j++) {
            if (sortOrder == 0) // If current element is smaller than the pivot
            {
                if (arr.get(j).getColor().ordinal() < pivot.getColor().ordinal()) {
                    i++;
                    // swap arr[i] and arr[j]
                    Tshirt temp = arr.get(i);
                    arr.set(i, arr.get(j));
                    arr.set(j, temp);
                }
            } else {
                if (arr.get(j).getColor().ordinal() > pivot.getColor().ordinal()) {
                    i++;
                    // swap arr[i] and arr[j]
                    Tshirt temp = arr.get(i);
                    arr.set(i, arr.get(j));
                    arr.set(j, temp);
                }
            }
        }
        // swap arr[i+1] and arr[high] (or pivot)
        Tshirt temp = arr.get(i + 1);
        arr.set(i + 1, arr.get(high));
        arr.set(high, temp);
        return i + 1;
    }
    
    private int quickPartitionFabric(List<Tshirt> arr, int low, int high, int sortOrder) {
        Tshirt pivot = arr.get(high);
        int i = (low - 1); // index of smaller element
        for (int j = low; j < high; j++) {
            if (sortOrder == 0) // If current element is smaller than the pivot
            {
                if (arr.get(j).getFabric().ordinal() < pivot.getFabric().ordinal()) {
                    i++;
                    // swap arr[i] and arr[j]
                    Tshirt temp = arr.get(i);
                    arr.set(i, arr.get(j));
                    arr.set(j, temp);
                }
            } else {
                if (arr.get(j).getFabric().ordinal() > pivot.getFabric().ordinal()) {
                    i++;
                    // swap arr[i] and arr[j]
                    Tshirt temp = arr.get(i);
                    arr.set(i, arr.get(j));
                    arr.set(j, temp);
                }
            }
        }
        // swap arr[i+1] and arr[high] (or pivot)
        Tshirt temp = arr.get(i + 1);
        arr.set(i + 1, arr.get(high));
        arr.set(high, temp);
        return i + 1;
    }
    
    
    private List<Tshirt> bucketSortUtil(List<Tshirt> shirts, int numberOfBuckets, int sortOrder){
        // Create bucket array
        List<Tshirt>[] buckets = new List[numberOfBuckets];
        // Associate a list with each index 
        // in the bucket array         
        for(int i = 0; i < numberOfBuckets; i++){
            buckets[i] = new LinkedList<>();
        }
        // Assign numbers from array to the proper bucket
        // by using hashing function
        try{
        for(Tshirt tshirt : shirts){
           // System.out.println("hash -> " + tshirt.hashCode());
            buckets[tshirt.hashCode()].add(tshirt);
        }
        }catch(Exception e){
        }
        // sort buckets
        for(List<Tshirt> bucket : buckets){
            Collections.sort(bucket);
        }
        int i = 0;
        // Merge buckets to get sorted array
        for(List<Tshirt> bucket : buckets){
            for(Tshirt num : bucket){
                shirts.set(i++, num);
            }
        }
        return shirts;
    }
    
   

    
    private List<Tshirt> bucketSort(int sortOrder, int numberOfBuckets) {
        List<Tshirt> shirts = this.tshirts;
        shirts = bucketSortUtil(shirts, numberOfBuckets, sortOrder);
        return shirts;
    }
}
