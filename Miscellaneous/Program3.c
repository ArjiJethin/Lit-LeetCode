#include <stdio.h>
#include <unistd.h>
#include <sys/wait.h>
#include <fcntl.h>
void main()
{
    char buff;
    int fd1, fd2;
    fd1 = open("file1.txt", O_RDONLY);
    fd2 = open("file2.txt", O_WRONLY | O_CREAT);
    while (read(fd1, &buff, 1))
    {
        write(fd2, &buff, 1);
    }
    printf("The file is successfully copied\n");
    close(fd1);
    close(fd2);
}