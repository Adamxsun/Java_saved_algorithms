/*
 * AUCSC310 LAB1 SELECTIONSORT
 * ADAM SUN
 * OCT 19
 */
package javaapplication1;

import java.util.Arrays;
import java.util.Random;
/**
 *  
 * @author adam sun
 */
public class MergeSort {
    public static void main(String args[]) 
    {   long startTime = System.currentTimeMillis();
        Random rand =   new Random();   
        int arr[] = new int [10000]; 
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt()   ;} // storing random integers in an array
        System.out.println("Initial");  
        printA(arr); 
  
        MergeSort project1 = new MergeSort(); 
        project1.TotalSort(arr, 0, arr.length-1); 
  
        System.out.println("After sort"); 
        printA(arr); 
        
        long endTime = System.currentTimeMillis();
        System.out.println("runnning time： "+(endTime-startTime)+"ms");   
    } //MAIN    
    public void merge(int arr[], int left, int middle, int right) 
    { 
        int number1 = middle - left + 1; 
        int number2 = right - middle; 
        int Left[] = new int [number1]; 
        int Right[] = new int [number2]; 
  
        for (int i = 0; i < number1; i++) 
            Left[i] = arr[left + i]; 
        for (int j = 0; j < number2; j++) 
            Right[j] = arr[middle + 1+ j]; 

        int i = 0, j = 0; 
        int k = left; 
        while (i < number1 && j < number2) 
        { 
            if (Left[i] <= Right[j]) 
            { 
                arr[k] = Left[i]; 
                i++; 
            } //if
            else
            { 
                arr[k] = Right[j]; 
                j++; 
            } //else
            k++; 
        } //while

        while (i < number1) 
        { 
            arr[k] = Left[i]; 
            i++; 
            k++; 
        } //while

        while (j < number2) 
        { 
            arr[k] = Right[j]; 
            k++;
            j++;  
        } //while
    }//merge
    public void TotalSort(int array[], int left, int right) 
    { 
        if (left < right) 
        { 
            int middle = (left+right)/2; 
            TotalSort(array, left, middle); 
            TotalSort(array , middle + 1,right); 
            merge(array, left, middle, right); 
        } //if
    } //Totalsort
    /* A utility function to print array of size n */
    public static void printA(int array[]) 
    { 
        int number = array.length; 
        for (int i = 0; i < number; i++) 
            System.out.print(array[i] + " "); 
        System.out.println(); 
    } //printA
} //MergeSort

