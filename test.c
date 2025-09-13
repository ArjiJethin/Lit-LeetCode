#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <pthread.h>

int g = 0; // global variable

// thread function
void *myThreadFun(void *vargp)
{
    int myid = *(int *)vargp; // thread's own ID (from loop counter)
    static int s = 0;         // static shared across all threads

    ++s;
    ++g;

    // note: ++s and ++g again inside printf
    printf("Thread ID: %d, Static: %d, Global: %d\n", myid, ++s, ++g);

    return NULL;
}

int main()
{
    pthread_t tid[3];

    for (int i = 0; i < 3; i++)
    {
        int *arg = malloc(sizeof(*arg));
        *arg = i;
        pthread_create(&tid[i], NULL, myThreadFun, arg);
    }

    for (int i = 0; i < 3; i++)
    {
        pthread_join(tid[i], NULL);
    }

    return 0;
}
