#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/wait.h>
int main()
{
    int pid;
    pid = fork();
    if (pid == 0)
    {
        printf("Child Process...\n");
        printf("Child Process ID: %d\n", getpid());
        printf("Parent Process ID: %d\n", getppid());
        printf("Finished with child\n");
    }
    else
    {
        wait(NULL);
        printf("Parent Process...\n");
        printf("Parent Process ID: %d\n", getpid());
        printf("Child Process ID: %d\n", pid);
    }
}