#include "utilidades.h"

/*
 Practica 2: Se han añadido los codigos de quickSort, bubbleSort y heapSort. En este archivo se incluyen los contadores de operaciones. 
 
 */

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

int partition(int arr[], int low, int high, int *comparaciones, int *intercambios){
    int pivot =arr[high];
    printf("Pivote: %d\n",pivot);
    int j,i = (low - 1 );
    *comparaciones=*comparaciones+1;
    for(j=low; j<=high-1 ;j++){
        *comparaciones=*comparaciones+1;
        *comparaciones=*comparaciones+1;
        if(arr[j] <= pivot){
            i++;
            swap(&arr[i], &arr[j]);
            *intercambios=*intercambios+1;
        }
    }
    swap(&arr[i+1], &arr[high]);
    *intercambios=*intercambios+1;
    return (i+1);
}


void quickSort (int arr[], int low, int high, int *comparaciones, int *intercambios){
    *comparaciones=*comparaciones+1; 
    if(low<high){
        int pi = partition(arr,low,high, comparaciones, intercambios);
        printSubArray(arr,low,pi-1);
        quickSort(arr,low,pi-1, comparaciones, intercambios);
        printSubArray(arr,pi+1,high);
        quickSort(arr,pi+1,high, comparaciones, intercambios);
    }
}


int bubbleSort(int a[], int size, int *comparaciones, int *intercambios){
    int i, j, n;
    n=size;
    int revision=1;
    *comparaciones=*comparaciones+1;
    for (i=n-1; i>0; i--) {
        int contadorIter=0;
        *comparaciones=*comparaciones+1;
        *comparaciones=*comparaciones+1;
        printf("\n---Revision %i---\n\n", revision);
        revision=revision+1;
        for(j=0; j<i; j++){
            *comparaciones=*comparaciones+1;
            *comparaciones=*comparaciones+1;
            if(a[j]>a[j+1]){
                swap(&a[j], &a[j+1]);
                contadorIter=1;
                *intercambios=*intercambios+1;
            }
        printf("\nIteracion %i:\n\n", j);
        printArray(a, n);
        }
        *comparaciones=*comparaciones+1;
        if(contadorIter==0){
            printf("Se han realizado todos los intercambios necesarios.\n");
            break;
            //return; también funciona adecuadamente. 
        }
    }
    
}

int heapSize;

void Heapify(int* A, int i, int size, int *comparaciones, int *intercambios)
{
    int l = 2 * i + 1;
    int r = 2 * i + 2;
    int largest;
    
    *comparaciones=*comparaciones+1;
    if(l <= heapSize && A[l] > A[i])
        largest = l;
    else
        largest = i;
    *comparaciones=*comparaciones+1;
    if(r <= heapSize && A[r] > A[largest])
        largest = r;
    *comparaciones=*comparaciones+1;
    if(largest != i){
        swap(&A[i],&A[largest]);
        *intercambios=*intercambios+1;
        printArray(A,size);
        Heapify(A, largest, size, comparaciones, intercambios);
    }
    
}

void BuildHeap(int* A, int size, int *comparaciones, int *intercambios){
    heapSize = size - 1;
    int i;
    *comparaciones=*comparaciones+1;
    for(i = (size - 1) / 2; i >= 0; i--){
        *comparaciones=*comparaciones+1;
        Heapify(A, i,size, comparaciones, intercambios);
    }
    printf("Termino de construir el HEAP \n",162);
}

void HeapSort(int* A, int size, int *comparaciones, int *intercambios){
    BuildHeap(A,size, comparaciones, intercambios);
    int i;
    *comparaciones=*comparaciones+1;
    for(i = size - 1; i > 0; i--){
        *comparaciones=*comparaciones+1;
        *intercambios=*intercambios+1;
        swap(&A[0],&A[heapSize]);
        heapSize--;
        printf("Iteracion HS: \n");
        printArray(A,size);
        Heapify(A, 0, size, comparaciones, intercambios);
    }
}


