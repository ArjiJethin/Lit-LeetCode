#include <stdio.h>
#include <stdlib.h>
int main()
{
    int i, j, k, n, a[50], frame[10], no, avail, count = 0;
    printf("Enter number of pages:");
    scanf("%d", &n);

    printf("Enter page reference string:\n");
    for (i = 0; i < n; i++)
        scanf("%d", &a[i]);

    printf("Enter number of frames:");
    scanf("%d", &no);

    for (i = 0; i < no; i++)
        frame[i] = -1;

    j = 0;

    printf("Page\t\tFrames\n");
    for (i = 1; i <= n; i++)
    {
        printf("%d\t\t", a[i]);
        avail = 0;
        for (k = 0; k < no; k++)
        {
            if (frame[k] == a[i])
                avail = 1;
        }
        if (avail = 0)
        {
            frame[j] = [i];
            j = (j + 1) % no;
            count++;
            for (k = 0; k < no; k++)
            {
                printf("%d\t", frame[k]);
            }
            printf("\n");
        }
    }
    printf("Page Faults: %d\n", count);
    return 0;
}