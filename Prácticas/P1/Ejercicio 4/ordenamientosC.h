#include "utilidades.h"
#include <stdio.h>
void selectionSort(int arreglo[], int n, int *comparaciones, int *intercambios){
	int indiceMenor, i, j;
        *comparaciones=*comparaciones+1;
	for (i=0; i<n-1; i++){
                *comparaciones=*comparaciones+1;
		indiceMenor=i;
                *comparaciones=*comparaciones+1;
		for(j = i+1; j<n; j++){
                    *comparaciones=*comparaciones+1;
		    *comparaciones=*comparaciones+1;
			if(arreglo[j]<arreglo[indiceMenor])
				indiceMenor=j;
		}
                *comparaciones=*comparaciones+1;
		if (i!=indiceMenor){
                *intercambios=*intercambios+1;
			swap(&arreglo[i],&arreglo[indiceMenor]);
		}
        printf("\nIteracion %i:\n\n", i+1);
        printArray(arreglo, n);
	}		
}


void insertionSort(int a[], int n, int *comparaciones, int *intercambios){
	int i,j;
	int aux;
        *comparaciones=*comparaciones+1;
	for(i=1; i<n; i++){
            *comparaciones=*comparaciones+1;
            j=i;
            aux=a[i];
                *comparaciones=*comparaciones+1;
                *comparaciones=*comparaciones+1;
		while (j>0 && aux < a[j-1]){
                        *comparaciones=*comparaciones+1;
                        *comparaciones=*comparaciones+1;
			a[j] = a[j-1];
                        *intercambios=*intercambios+1;
			j--;
		}
		a[j]=aux;
        printf("\nIteración %i:\n\n", i);
        printArray(a, n);
	}
}