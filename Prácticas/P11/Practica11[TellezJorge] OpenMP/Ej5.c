#include <stdio.h>
#include <omp.h>

int main(){

    int a, nth;
    #pragma omp parallel private (a)
    {
        a = omp_get_thread_num();
        nth = omp_get_num_threads();
        printf("Hola mundo desde el hilo %d de un total de %d\n", a, nth);
    }

    printf("Adios \n");
    return 0;
}
