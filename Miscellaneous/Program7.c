#include <stdio.h>
#include <stdlib.h>

int main()
{
    int max[10][10], alloc[10][10], need[10][10], avail[10];
    int completed[10], safeSequence[10];
    int p, r, i, j, process, count = 0;

    printf("Enter number of processes: ");
    scanf("%d", &p);

    for (int i = 0; i < p; i++)
        completed[i] = 0;

    printf("Enter number of resources: ");
    scanf("%d", &r);

    printf("Enter maximum matrix:\n");
    for (i = 0; i < p; i++)
    {
        printf("Enter for process %d: ", i + 1);
        for (j = 0; j < r; j++)
            scanf("%d", &max[i][j]);
    }

    printf("Enter allocation matrix:\n");
    for (i = 0; i < p; i++)
    {
        printf("Enter for process %d: ", i + 1);
        for (j = 0; j < r; j++)
            scanf("%d", &alloc[i][j]);
    }

    printf("Enter available matrix:\n");
    for (j = 0; j < r; j++)
        scanf("%d", &avail[j]);

    for (i = 0; i < p; i++)
    {
        for (j = 0; j < r; j++)
        {
            need[i][j] = max[i][j] - alloc[i][j];
        }
    }

    do
    {
        process = -1;
        for (i = 0; i < p; i++)
        {
            if (completed[i] == 0)
            {
                process = i;
                for (j = 0; j < r; j++)
                {
                    if (avail[j] < need[i][j])
                    {
                        process = -1;
                        break;
                    }
                }
            }
            if (process != -1)
            {
                break;
            }
        }
        if (process != -1)
        {
            printf("Process %d runs to completion!\n", process + 1);
            safeSequence[count] = process + 1;
            count++;

            for (j = 0; j < r; j++)
            {
                avail[j] += alloc[process][j];
                alloc[process][j] = 0;
                max[process][j] = 0;
                completed[process] = 1;
            }
        }
    } while (count != p && process != -1);

    if (count == p)
    {
        printf("\nSystem is in safe state.\nSafe sequence is: < ");
        for (i = 0; i < p; i++)
        {
            printf("%d ", safeSequence[i]);
        }
        printf(">\n");
    }
    else
    {
        printf("\nSystem is not in safe state.");
    }
}