/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica2téllez;

/**
 *
 * @author jorje
 */
public class Quicksort {
    
    double partition(int arr[], int low, int high){
        int pivot=arr[high];
        int i=(low-1);
        for(int j=low; j<high; j++){
            if(arr[j] <=pivot){
                i++;
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
            }
        }
        int temp=arr[i+1];
        arr[i+1]=arr[high];
        arr[high]=temp;
        return i+1;
    }
    
    void sort(int arr[], int low, int high){
        if(low<high){
            double pi=partition(arr,low,high);
            sort(arr,low,pi-1.0);
            sort(arr,pi+1,high);
        }
    }
}


