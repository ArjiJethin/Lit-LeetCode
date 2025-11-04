#include <stdio.h>
#include <stdlib.h>
int mutex = 1, full = 0, empty = 3, x = 0;

int wait(int s) { return (--s); }
int signal(int s) { return (++s); }

void producer()
{
    mutex = wait(mutex);
    full = signal(full);
    empty = wait(empty);
    x++;
    printf("Producer produces item %d\n", x);
    mutex = signal(mutex);
}

void consumer()
{
    mutex = wait(mutex);
    full = wait(full);
    empty = signal(empty);
    x--;
    printf("Consumer consumes item %d\n", x + 1);
    mutex = signal(mutex);
}

int main()
{
    int n;
    printf("1)Producer\n2)Consumer\n3)Exit\n");
    while (1)
    {
        printf("Enter your choice:");
        scanf("%d", &n);
        switch (n)
        {
        case 1:
            if ((mutex == 1) && (empty != 0))
                producer();
            else
                printf("Buffer is full or busy, producer can't produce\n");
            break;
        case 2:
            if (mutex == 1 && full != 0)
                consumer();
            else
                printf("Buffer is empty or busy, consumer can't consume\n");
            break;
        case 3:
            printf("Exiting...\n");
            exit(0);
            break;

        default:
            printf("Invalid choice\n");
        }
    }

    return 0;
}