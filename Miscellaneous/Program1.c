#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/wait.h>
void main()
{
    int pid;
    pid = fork();
    if (pid < 0)
    {
        printf("Fork Failure\n");
        exit(1);
    }
    else if (pid == 0)
    {
        printf("Now in Child Process & its output is \n");
        execlp("ls", "ls", NULL);
        exit(0);
    }
    else
    {
        printf("Child Process created successfully\n");
        printf("Process id:%d\n", getpid());
        wait(NULL);
        printf("Now back to Parent Process\n");
        exit(0);
    }
}