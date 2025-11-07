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
        printf("Now in Child Process & its Output is \n");
        execlp("ls", "ls", NULL);
        exit(0);
    }
    else
    {
        printf("Child Process Created Successfully\n");
        printf("process id:%d\n", getpid());
        wait(NULL);
        printf("Now back to Parent Process\n");
        exit(0);
    }
}