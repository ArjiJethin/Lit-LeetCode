1class Solution {
2    public int maxDistance(int[] A, int[] B) {
3        int i, j;
4
5        for (i = 0, j = 0; i < A.length && j < B.length; j++)
6            if (A[i] > B[j])
7                i++;
8
9        return Math.max(0, j - i - 1);
10    }
11}