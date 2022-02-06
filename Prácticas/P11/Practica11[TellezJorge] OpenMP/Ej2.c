#include <stdio.h>
#include <omp.h>

int main(){

    #pragma omp parallel num_threads (2)
    {
        int i;
        printf("Hola mundo\n");
        for(i=0; i<10; i++)
            printf("Iteracion: %d\n", i);
    }

    printf("Adios \n");
    return 0;
}
