#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <fcntl.h>
int main()
{
    int fd1, fd2;
    fd1 = open("file1.txt", O_RDONLY);
    fd2 = open("file2.txt", O_WRONLY | O_CREAT);
    char buffer;
    while (read(fd1, &buffer, 1))
    {
        write(fd2, &buffer, 1);
    }
    close(fd1);
    close(fd2);
    return 0;
}