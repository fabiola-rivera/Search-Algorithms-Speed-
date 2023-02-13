package com.codepackage;

import java.util.Random;

public class SearchingAlgorithms1 {


    public static boolean binarySearch(int[] list, int x){
        int first = 0, last = list.length - 1, pivot;
        boolean found = false;
        while(first <= last && !found)
        {
            pivot =  (first + last) / 2;
            if (list[pivot] == x) found = true ;
            else
            if (x < list[pivot]) last = pivot - 1;
            else first = pivot + 1;
        }
        if (found )  return true;
        else return false;
    }
    public static int sequentialSearch(int[] list, int x){
        // O(n)
        // boolean found = false;
        for(int i = 0 ; i < list.length ; i++){
            if(list[i] == x){
                return i;
            }

        }
        return -1;
    }
    /**
     * Recursive quickSort algorithm
     * @author Prof. A. Hernandez
     */
    public static void quickSort(int[] list)
    {
        quicksort(list, 0, list.length - 1);
    }
    private static void quicksort(int[] list, int begin, int end)
    {
        int temp;
        int pivot = findPivotLocation(begin, end);
// swap list[pivot] and list[end]
        temp = list[pivot];
        list[pivot] = list[end];
        list[end] = temp;
        pivot = end;
        int i = begin,
                j = end - 1;
        boolean iterationCompleted = false;
        while (!iterationCompleted)
        {
            while (list[i] < list[pivot])
                i++;
            while ((j >= 0) && (list[pivot] < list[j]))
                j--;
            if (i < j)
            {
//swap list[i] and list[j]
                temp = list[i];
                list[i] = list[j];
                list[j] = temp;
                i++;
                j--;
            } else
                iterationCompleted = true;
        }
//swap list[i] and list[pivot]
        temp = list[i];
        list[i] = list[pivot];
        list[pivot] = temp;
        if (begin < i - 1) quicksort(list, begin, i - 1);
        if (i + 1 < end) quicksort(list, i + 1, end);
    }

    /*
     * Computes the pivot
     */
    private static int findPivotLocation(int b, int e)
    {
        return (b + e) / 2;
    }


    public static void fillArray(int[] list, int x){
        Random rand = new Random();
        for(int  i = 0 ; i < list.length ; i++){
            list[i] = rand.nextInt(x); //
        }
    }
    public static void printArray(int[] list){
        int r = 0;
        for(int i = 0 ; i < list.length ; i++){
            r = list[i];
            System.out.print(r + " ");
        }

    }
}
