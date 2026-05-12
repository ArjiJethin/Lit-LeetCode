1class Solution {
2
3    public int minimumEffort(int[][] tasks) {
4        Arrays.sort(tasks, (a, b) -> a[1] - a[0] - (b[1] - b[0]));
5        int ans = 0;
6        for (int[] task : tasks) {
7            ans = Math.max(ans + task[0], task[1]);
8        }
9        return ans;
10    }
11}