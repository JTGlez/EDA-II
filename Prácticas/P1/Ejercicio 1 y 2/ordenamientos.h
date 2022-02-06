#include "utilidades.h"
#include <stdio.h>
void selectionSort(int arreglo[], int n){
	int indiceMenor, i, j;
	for (i=0; i<n-1; i++){
		indiceMenor=i;
		for(j = i+1; j<n; j++){
			if(arreglo[j]<arreglo[indiceMenor])
				indiceMenor=j;
		}
		if (i!=indiceMenor){
			swap(&arreglo[i],&arreglo[indiceMenor]);
		}
        printf("\nIteracion %i:\n\n", i+1);
        printArray(arreglo, n);
	}		
}
	

void insertionSort(int a[], int n){
	int i,j;
	int aux;
	for(i=1; i<n; i++){
		j=i;
		aux=a[i];
		while (j>0 && aux < a[j-1]){
			a[j] = a[j-1];
			j--;
		}
		a[j]=aux;
        printf("\nIteracion %i:\n\n", i);
        printArray(a, n);
	}
	
	
}



