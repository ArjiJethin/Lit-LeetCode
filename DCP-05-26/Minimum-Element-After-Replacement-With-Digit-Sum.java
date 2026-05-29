1class Solution {
2
3    public int minElement(int[] nums) {
4        int ans = 37;
5        for (int num : nums) {
6            int dig = 0;
7            while (num > 0) {
8                dig += num % 10;
9                num /= 10;
10            }
11            ans = Math.min(ans, dig);
12        }
13        return ans;
14    }
15}
16