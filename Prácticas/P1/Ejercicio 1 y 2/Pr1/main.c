/*
 * Práctica #1: Algoritmos de ordenamiento Parte 1
 * Ejercicio 1
 */

/* 
 * Archivo:   main.c
 * Autor: Téllez González Jorge Luis
 * Creado el 6 de febrero de 2020, 07:35 PM
 */

#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include "ordenamientos.h"

#define N 50

void llenarArreglo(int arreglo[], int n){

    int i;
    printf("\nEl arreglo se está generando...\n\n");
    srand(time(NULL));
    for(i=0; i<n; i++){
        arreglo[i]=rand()%100;
    }
}

int main() {
    int seleccion;
    int arreglo[N];
    printf("P1: Algoritmos de ordenamiento. \n\n\n");
    while(seleccion!=3){
        printf("¿Qué método de ordenamiento desea utilizar?\n1) Insertion-Sort \n2) Selection Sort \n3) Salir del programa\n\nOpción: ");
        scanf("%i", &seleccion);
        
        switch(seleccion){
        
            case 1:
                
                printf("\nUsted ha seleccionado Insertion-Sort:\n\n");
                llenarArreglo(arreglo, N);
                printf("\nEl arreglo tiene como entradas iniciales: \n\n");
                printArray(arreglo, N);
                printf("\nAhora, ordenando el arreglo...\n\n");
                insertionSort(arreglo, N);
                printf("\n¡Felicidades! Su arreglo está ordenado. :) \n\n");
                printArray(arreglo, N);
                
            break;
            case 2:
                printf("\nUsted ha seleccionado Selection-Sort:\n\n");
                llenarArreglo(arreglo, N);
                printf("\nEl arreglo tiene como entradas iniciales: \n\n");
                printArray(arreglo, N);
                printf("\nAhora, ordenando el arreglo...\n\n");
                selectionSort(arreglo, N);
                printf("\n¡Felicidades! Su arreglo está ordenado. :) \n\n");
                printArray(arreglo, N);
                
            break;
            
            case 3:
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

