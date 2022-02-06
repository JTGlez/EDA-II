/*
 * Práctica #2: Algoritmos de ordenamiento Parte 2.
 * Ejercicio 2
 */

/* 
 * Archivo:   main.c
 * Autor: Téllez González Jorge Luis
 * Creado el 13 de febrero de 2020, 03:40 PM
 */

#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include "ordenamientos2.h"
#include <locale.h>

#define N 10

void llenarArreglo(int arreglo[], int n){
    
    int i;
    printf("\nEl arreglo se está generando...\n\n");
    srand(time(NULL));
    for(i=0; i<n; i++){
        arreglo[i]=rand()%100;
    }
}

int main() {
    setlocale(LC_CTYPE,"spanish");
    int seleccion;
    int arreglo[N];
    printf("P2: Algoritmos de ordenamiento. \n\n\n");
    while(seleccion!=4){
        printf("¿Que metodo de ordenamiento desea utilizar?\n1) Quick-Sort \n2) Bubble-Sort \n3) Heap-Sort \n4) Salir del programa\n\nOpción: ");
        scanf("%i", &seleccion);
        
        switch(seleccion){
                
            case 1:
                
                printf("\nUsted ha seleccionado Quick-Sort:\n\n");
                llenarArreglo(arreglo, N);
                printf("\nEl arreglo tiene como entradas iniciales: \n\n");
                printArray(arreglo, N);
                printf("\nAhora, ordenando el arreglo...\n\n");
                quickSort(arreglo, 1, N);
                printf("\n¡Felicidades! Su arreglo está ordenado. :) \n\n");
                printSubArray(arreglo , 1, N);
                
                break;
            case 2:
                printf("\nUsted ha seleccionado Bubble-Sort:\n\n");
                llenarArreglo(arreglo, N);
                printf("\nEl arreglo tiene como entradas iniciales: \n\n");
                printArray(arreglo, N);
                printf("\nAhora, ordenando el arreglo...\n\n");
                bubbleSort(arreglo, N);
                printf("\n¡Felicidades! Su arreglo está ordenado. :) \n\n");
                printArray(arreglo, N);
                
                break;
                
            case 3:
                printf("\nUsted ha seleccionado Heap-Sort:\n\n");
                llenarArreglo(arreglo, N);
                printf("\nEl arreglo tiene como entradas iniciales: \n\n");
                printArray(arreglo, N);
                printf("\nAhora, ordenando el arreglo...\n\n");
                HeapSort(arreglo, N);
                printf("\n¡Felicidades! Su arreglo está ordenado. :) \n\n");
                printArray(arreglo, N);
                break;
                
            case 4:
                printf("Adios!");
                return 0;
                break;
                
                
            default:
                printf("Por favor selecciona una opción válida.\n\n");
                
                break;       
        }
    }
    printf("Adios!");
    return 0;
}

