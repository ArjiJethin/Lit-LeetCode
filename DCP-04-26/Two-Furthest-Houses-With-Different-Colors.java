1class Solution {
2
3    public int maxDistance(int[] colors) {
4        int n = colors.length;
5        int res = 0; // the maximum distance between two houses of different colors
6        // traverse the indices of two houses and maintain the maximum distance
7        for (int i = 0; i < n; i++) {
8            for (int j = i + 1; j < n; j++) {
9                if (colors[i] != colors[j]) {
10                    res = Math.max(res, j - i);
11                }
12            }
13        }
14        return res;
15    }
16}